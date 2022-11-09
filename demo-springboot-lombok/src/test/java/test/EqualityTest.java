package test;

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

import demo.lombok.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EqualityTest {
    @Test public void samePersonIsTheSame () {
        final Person adam1 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();
        final Person adam2 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        assertEquals (adam1, adam2);
        assertEquals (adam1.hashCode (), adam2.hashCode ());
    }

    @Test public void samePersonIsNotTheSameWithoutAJob () {
        final Person adam1 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();
        final Person adam2 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .build ();

        assertNotEquals (adam1, adam2);
        assertNotEquals (adam1.hashCode (), adam2.hashCode ());
    }

    @Test public void samePersonInAList () {
        final Person adam1 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        final Person bob = Person.builder ()
                                 .name ("Bob De Buildeur")
                                 .age (25)
                                 .job ("Building")
                                 .build ();

        assertNotEquals (bob, adam1);

        final List<Person> people = new ArrayList<Person> ();
        people.add (bob);
        assertTrue (people.contains (bob));
        assertFalse (people.contains (adam1));

        people.add (adam1);
        assertTrue (people.contains (adam1));

        final Person adam2 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        assertTrue (people.contains (adam2));
        assertEquals (people.indexOf (adam1), people.indexOf (adam2));
    }

    @Test public void onlyOneOfYouInASet () {
        final Person adam1 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        final Person adam2 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        final Person bob = Person.builder ()
                                 .name ("Bob De Buildeur")
                                 .age (25)
                                 .job ("Building")
                                 .build ();

        assertNotEquals (bob, adam1);

        final Set<Person> people = new HashSet<Person> ();

        people.add (bob);
        assertEquals (1, people.size ());
        people.add (bob);
        assertEquals ("Same Bob is taking two spots? No megusta!", 1, people.size ());

        people.add (adam1);
        assertEquals ("Where is Adam?", 2, people.size ());
        people.add (adam2);
        assertEquals ("Equality! If Bob couldn't take two seats, Adam won't either!", 2, people.size ());
    }

    @Test public void youAreTheKeyToMyHashMap () {
        final Person adam1 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        final Person adam2 = Person.builder ()
                                   .name ("Adam Savage")
                                   .age (47)
                                   .job ("MythBusters")
                                   .job ("Unchained Reaction")
                                   .build ();

        final Person bob = Person.builder ()
                                 .name ("Bob De Buildeur")
                                 .age (25)
                                 .job ("Building")
                                 .build ();

        final Map<Person, String> people = new HashMap<Person, String> ();
        people.put (adam1, adam1.getName ());
        people.put (bob, bob.getName ());

        final Person luke = Person.builder ()
                                  .name ("Lucky Luke")
                                  .age (32)
                                  .job ("Cowboy")
                                  .build ();

        assertNull (people.get (luke));
        assertEquals (adam1.getName (), people.get (adam1));
        assertEquals (adam2.getName (), people.get (adam2));
        assertEquals (adam1.getName (), people.get (adam2));
        assertEquals (bob.getName (), people.get (bob));
    }
}
