package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        System.out.println();
        Direction.Directon[] array = new Direction.Directon[args.length];
        for(int i=0; i < args.length; i++) {
            switch(args[i]) {
                case "f":
                    array[i] = Direction.Directon.FORWARD;
                    break;
                case "b":
                    array[i] = Direction.Directon.BACKWARD;
                    break;
                case "r":
                    array[i] = Direction.Directon.RIGHT;
                    break;
                case "l":
                    array[i] = Direction.Directon.LEFT;
                    break;
                default:
                    array[i] = Direction.Directon.NULL;
            }
        }
        run(array);
        System.out.println();
        System.out.println("system zakończył działanie");
    }
    public static void run(Direction.Directon[] args) {
        /* Points 11-13
        for(int i = 0; i < args.length - 1; i++) {
            System.out.print(args[i] + ", ");
        }
        System.out.println(args[args.length -1]); */

        /* Points 14-15
        System.out.println("Start");
        for(String argument: args) {
            String message = switch (argument) {
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do tyłu";
                case "r" -> "Zwierzak skręca w prawo";
                case "l" -> "Zwierzak skręca w lewo";
                default -> null;
            };
             if(message != null) System.out.println(message);
        } */
        for(Direction.Directon argument: args) {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                case NULL -> null;
            };
            if(message != null) System.out.println(message);
        }

        System.out.println("Stop");
    }
}

