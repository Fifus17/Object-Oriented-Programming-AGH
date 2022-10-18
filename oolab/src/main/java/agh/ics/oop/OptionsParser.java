package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
        List<MoveDirection> movesList = new ArrayList<MoveDirection>();
        for(String arg : args) {
            switch (arg) {
                case "f", "forward": movesList.add(MoveDirection.FORWARD);
                break;
                case "b", "backward": movesList.add(MoveDirection.BACKWARD);
                break;
                case "r", "right": movesList.add(MoveDirection.RIGHT);
                break;
                case "l", "left": movesList.add(MoveDirection.LEFT);
                break;
            }
        }
        MoveDirection[] moves = new MoveDirection[movesList.size()];
        movesList.toArray(moves);
        return moves;
    }
}
