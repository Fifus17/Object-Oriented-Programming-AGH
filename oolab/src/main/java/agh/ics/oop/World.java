package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        Animal giraffe = new Animal();
        System.out.println(giraffe.toString());
        OptionsParser instructions = new OptionsParser();
        //MoveDirection[] moves = instructions.parse(args);  Steering with main arguments
        String[] testString = {"", "b", "backward", "b", "b", "l", "f", "f", "f", "right", "f", "f"}; // Steering with pre-made array
        MoveDirection[] moves = instructions.parse(testString);
        for(MoveDirection move: moves) {
            giraffe.move(move);
            System.out.println(giraffe.toString());
        }
        System.out.println(giraffe.toString());
    }
}

