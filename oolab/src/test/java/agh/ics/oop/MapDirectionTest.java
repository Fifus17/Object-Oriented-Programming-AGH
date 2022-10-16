package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    public void nextTest () {
        assertEquals(Vector2d.MapDirection.NORTH.next(), Vector2d.MapDirection.EAST);
        assertEquals(Vector2d.MapDirection.EAST.next(), Vector2d.MapDirection.SOUTH);
        assertEquals(Vector2d.MapDirection.SOUTH.next(), Vector2d.MapDirection.WEST);
        assertEquals(Vector2d.MapDirection.WEST.next(), Vector2d.MapDirection.NORTH);
    }

    @Test
    public void previousTest () {
        assertEquals(Vector2d.MapDirection.NORTH.previous(), Vector2d.MapDirection.WEST);
        assertEquals(Vector2d.MapDirection.EAST.previous(), Vector2d.MapDirection.NORTH);
        assertEquals(Vector2d.MapDirection.SOUTH.previous(), Vector2d.MapDirection.EAST);
        assertEquals(Vector2d.MapDirection.WEST.previous(), Vector2d.MapDirection.SOUTH);
    }
}
