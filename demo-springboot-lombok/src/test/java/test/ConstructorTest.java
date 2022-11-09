package test;

import demo.lombok.model.Shape;
import demo.lombok.model.TrackedShape;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    @Test
    public void noArgsConstructorX0Y0 () {
        final Shape shape = new Shape ();

        assertEquals (0, shape.getX ());
        assertEquals (0, shape.getY ());
    }

    @Test
    public void allArgsConstructor () {
        Shape shape = new Shape (0, 0);

        assertEquals (0, shape.getX ());
        assertEquals (0, shape.getY ());

        shape = new Shape (334, 46);
        assertEquals (334, shape.getX ());
        assertEquals (46, shape.getY ());
    }

    @Test
    public void constructTrackedShapeRequiredArgs () {
        final long now = System.currentTimeMillis ();

        // required args constructor
        TrackedShape shape = new TrackedShape ("abcd1234", now);

        assertEquals (0, shape.getX ());
        assertEquals (0, shape.getY ());
        assertEquals ("abcd1234", shape.getId ());
        assertEquals (now, shape.getTimestamp ());
        assertNull (shape.getLocalReference ());
    }

    @Test
    public void constructTrackedShapeAllArgsGetsLost () {
        final long now = System.currentTimeMillis ();

        // required args constructor
        TrackedShape shape = new TrackedShape ("badf00d", now, "local ref", false);

        assertEquals (0, shape.getX ());
        assertEquals (0, shape.getY ());
        assertEquals ("badf00d", shape.getId ());
        assertEquals (now, shape.getTimestamp ());
        assertEquals ("local ref", shape.getLocalReference ());
        assertFalse (shape.isLost ());

        shape.setLost (true);
        assertTrue (shape.isLost ());
    }

    @Test
    public void constructTrackedShapeAllArgsLostThenFound () {
        final long now = System.currentTimeMillis ();

        // required args constructor
        TrackedShape shape = new TrackedShape ("badf00d", now, "local ref", true);

        assertEquals (0, shape.getX ());
        assertEquals (0, shape.getY ());
        assertEquals ("badf00d", shape.getId ());
        assertEquals (now, shape.getTimestamp ());
        assertEquals ("local ref", shape.getLocalReference ());
        assertTrue (shape.isLost ());

        shape.setLost (false);
        assertFalse (shape.isLost ());
    }
}