package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(2, 2);
        // the maps is 2x2

        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(1, 2)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(5, 5);
        // chc
        // checking if an animal can be placed on an empty map
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(2, 2))));
        try{
            map.place(new Animal(map, new Vector2d(2, 2)));
            Assertions.fail("an exception should be thrown at (2, 2)");
        }
        catch (IllegalArgumentException ex){
            Assertions.assertTrue(true, "an exception was caught (2, 2)");
        }

        // chceking placing outside the map
        try{
            map.place(new Animal(map, new Vector2d(6, 2)));
            Assertions.fail("an exception was meant to throw at (6, 2)");
        }
        catch (IllegalArgumentException ex){
            Assertions.assertTrue(true, "an exception was caught at (6,2)");
        }
    }

    @Test
    public void isOccupiedTest() {
        IWorldMap map = new RectangularMap(2, 2);
        Assertions.assertFalse(map.isOccupied(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1, 1)));
    }

    @Test
    public void objectAtTest() {
        IWorldMap map = new RectangularMap(2, 2);
        Assertions.assertNull(map.objectAt(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
    }
}