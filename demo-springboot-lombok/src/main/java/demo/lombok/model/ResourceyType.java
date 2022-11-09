package demo.lombok.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 Copyright 2015 Mahram Z. Foadi
 <p/>
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 <p/>
 http://www.apache.org/licenses/LICENSE-2.0
 <p/>
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 /*
 <p/>
 /**

 @author mahram */

public final class ResourceyType {

    @RequiredArgsConstructor
    public static class Closable {

        private final Callback callback;

        @Getter
        private boolean opened = true;

        @Override protected void finalize () throws Throwable {
            super.finalize ();

            if (!opened) {
                return;
            }

            callback.fail ();
            System.err.println ("Y U NO CLOSE?");
            throw new IllegalStateException ("Y U NO CLOSE?");
        }

        public void doWork () {
            System.out.println ("LOL@u thinking I'm gonna do any work");
        }

        public final void close () {
            opened = false;
            System.out.println ("Closed.");
            callback.call ();
        }
    }

    @RequiredArgsConstructor @ToString
    public static class Recyclable {

        private final Callback callback;
        @Getter private boolean recycled = false;

        @Override protected final void finalize () throws Throwable {
            super.finalize ();

            if (recycled)
                return;

            callback.fail ();
            System.err.println ("Y U NO RECYCLE?");
            throw new IllegalStateException ("Y U NO RECYCLE?");
        }

        public final void recycle () {
            recycled = true;
            System.out.println ("Recycled");
            callback.call ();
        }
    }

    public static class Callback {

        private transient boolean called     = false;
        @Getter private   boolean successful = false;

        public void call () {
            synchronized (this) {
                called = true;
                successful = true;
                notifyAll ();
            }
        }

        public void fail () {
            synchronized (this) {
                called = true;
                successful = false;
                notifyAll ();
            }
        }

        public boolean awaitCall () {

            synchronized (this) {
                System.out.printf ("Current state: %s\n", called ? "called" : "waiting");

                while (!called) {

                    try {
                        wait ();
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }

                System.out.printf ("Done: %s\n", successful ? "successful" : "failed");
                return successful;
            }
        }
    }
}
