package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void equalsTest() {
        Vector2d vector = new Vector2d(10, -64);
        assertTrue(vector.equals(new Vector2d(10, -64)));
        assertFalse(vector.equals(new Vector2d(10, -65)));
        assertFalse(vector.equals(new Vector2d(15, -64)));
        assertFalse(vector.equals(new Vector2d(14215, -6820)));
    }

    @Test
    public void toStringTest() {
        assertEquals("(5, 9)", new Vector2d(5, 9).toString());
        assertEquals("(-1431, 1223)", new Vector2d(-1431, 1223).toString());
        assertFalse(new Vector2d(5, 9).toString().equals("(5, 5)"));
    }

    @Test
    public void precedesTest() {
        Vector2d vector = new Vector2d(5, 5);
        assertTrue(vector.precedes(new Vector2d(-6, 3))); // Both lower
        assertFalse(vector.precedes(new Vector2d(4, 6))); // x lower, y higher
        assertFalse(vector.precedes(new Vector2d(8, 3))); // x higher, y lower
        assertFalse(vector.precedes(new Vector2d(10, 11))); // Both higher
        assertTrue(vector.precedes(new Vector2d(5, 5))); // Both equal
        assertTrue(vector.precedes(new Vector2d(4, 5))); // x lower, y equal
        assertTrue(vector.precedes(new Vector2d(5, -6))); // x equal, y lower
        assertFalse(vector.precedes(new Vector2d(7, 5))); // x higher, y equal
        assertFalse(vector.precedes(new Vector2d(5, 9))); // x equal, y higher
    }

    @Test
    public void followsTest() {
        Vector2d vector = new Vector2d(5, 5);
        assertFalse(vector.follows(new Vector2d(-6, 3))); // Both lower
        assertFalse(vector.follows(new Vector2d(4, 6))); // x lower, y higher
        assertFalse(vector.follows(new Vector2d(8, 3))); // x higher, y lower
        assertTrue((vector.follows(new Vector2d(10, 11)))); // Both higher
        assertTrue((vector.follows(new Vector2d(5, 5)))); // Both equal
        assertFalse(vector.follows(new Vector2d(4, 5))); // x lower, y equal
        assertFalse(vector.follows(new Vector2d(5, -6))); // x equal, y lower
        assertTrue(vector.follows(new Vector2d(7, 5))); // x higher, y equal
        assertTrue((vector.follows(new Vector2d(5, 9)))); // x equal, y higher
    }

    @Test
    public void upperRightTest () {
        Vector2d vector = new Vector2d(5, 5);
        assertTrue(vector.upperRight(new Vector2d(5, 6)).equals(new Vector2d(5, 6)));
        assertTrue(vector.upperRight(new Vector2d(6, 5)).equals(new Vector2d(6, 5)));
        assertTrue(vector.upperRight(new Vector2d(6, 6)).equals(new Vector2d(6, 6)));
        assertTrue(vector.upperRight(new Vector2d(4, 5)).equals(new Vector2d(5, 5)));
        assertTrue(vector.upperRight(new Vector2d(5, 4)).equals(new Vector2d(5, 5)));
        assertTrue(vector.upperRight(new Vector2d(4, 4)).equals(new Vector2d(5, 5)));
    }

    @Test
    public void lowerLeftTest() {
        Vector2d vector = new Vector2d(5, 5);
        assertTrue((vector.lowerLeft(new Vector2d(5, 6))).equals(new Vector2d(5, 5)));
        assertTrue(vector.lowerLeft(new Vector2d(6, 5)).equals(new Vector2d(5, 5)));
        assertTrue(vector.lowerLeft(new Vector2d(6, 6)).equals(new Vector2d(5, 5)));
        assertTrue(vector.lowerLeft(new Vector2d(4, 5)).equals(new Vector2d(4, 5)));
        assertTrue(vector.lowerLeft(new Vector2d(5, 4)).equals(new Vector2d(5, 4)));
        assertTrue(vector.lowerLeft(new Vector2d(4, 4)).equals(new Vector2d(4, 4)));
        assertFalse(vector.lowerLeft(new Vector2d(4, 4)).equals(new Vector2d(5, 5)));
    }

    @Test
    public void addTest() {
        assertEquals(new Vector2d(5, 5).add(new Vector2d(-7, 8)), new Vector2d(-2, 13));
        assertFalse(new Vector2d(5, 5).add(new Vector2d(-7, 8)).equals(new Vector2d(-5, 9)));
    }

    @Test
    public void subtractTest() {
        assertEquals(new Vector2d(5, 5).subtract(new Vector2d(-7, 8)), new Vector2d(12, -3));
        assertFalse(new Vector2d(5, 5).subtract(new Vector2d(-7, 8)).equals(new Vector2d(-5, 9)));
    }

    @Test
    public void opposite() {
        assertEquals(new Vector2d(5, -9).opposite(), new Vector2d(-5, 9));
        assertFalse(new Vector2d(5, -9).opposite().equals(new Vector2d(-4, 12)));
    }
}