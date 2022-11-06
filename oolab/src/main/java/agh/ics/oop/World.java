package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(-1, -2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
    }

    public static void run(Direction[] array) {
        for (Direction d : array) {
            switch (d) {
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tylu");
                case RIGHT -> System.out.println("zwierzak skręca w prawo");
                case LEFT -> System.out.println("zwierzak skręca w lewo");
                default -> {
                }
            }
        }
    }

    public static Direction[] convert(String[] array) {
        Direction[] result = new Direction[array.length];
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case "f" -> result[i] = Direction.FORWARD;
                case "b" -> result[i] = Direction.BACKWARD;
                case "r" -> result[i] = Direction.RIGHT;
                case "l" -> result[i] = Direction.LEFT;
                default -> result[i] = Direction.NULL;
            }
        }
        return result;
    }
}

