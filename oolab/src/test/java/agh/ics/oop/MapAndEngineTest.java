package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapAndEngineTest {
    @Test
    public void directionTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.NORTH);

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.EAST);

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.SOUTH);

        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.WEST);

        animal.move(MoveDirection.RIGHT);


        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.NORTH);
    }

    @Test
    public void movementTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));
        // starting at (2,2)
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //should be (2,4) and heading north
        Assertions.assertEquals(animal.getPosition(), new Vector2d(2, 4));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        //position should be (4,4)
        Assertions.assertEquals(animal.getPosition(), new Vector2d(4, 4));


        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(animal.getPosition(), new Vector2d(0, 4));

        //animal is at (0,4) east
        // goal is (0,0)

        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(animal.getPosition(), new Vector2d(0, 0));

    }

    @Test
    public void mapBoundariesTest() {
        RectangularMap testMap = new RectangularMap(5,5);
        Animal animal = new Animal(testMap, new Vector2d(2,2));
        animal.move(MoveDirection.RIGHT);

        //starting position is (2,2), heading east

        //right border of the map
        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition(), new Vector2d(4, 2));


        animal.move(MoveDirection.LEFT);

        //heading north

        //top border of the map
        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition(), new Vector2d(4, 4));

        animal.move(MoveDirection.LEFT);

        //left border of the map
        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition(), new Vector2d(0, 4));

        animal.move(MoveDirection.LEFT);

        //bottom border of the map
        for (int i = 0; i < 20; i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition(), new Vector2d(0, 0));
    }



    @Test
    public void worldTest(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(engine.getAnimal(0).getPosition(), new Vector2d(2, 0));
        Assertions.assertEquals(engine.getAnimal(1).getPosition(), new Vector2d(3, 4));

    }
}
