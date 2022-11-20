package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void parserTest() {
        OptionsParser parser = new OptionsParser();

        //basic test
        String[] test_args = {"wrong input"};
        try{
            MoveDirection[] output = parser.parse(test_args);
            Assertions.fail("This should have failed since the arguments were invalid");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true, "successfully caught good exception");
        }

        // normal moves check
        String[] test_args2 = {"f", "b", "r", "l", "forward", "backward", "right", "left"};
        MoveDirection[] valid = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        };
        Assertions.assertArrayEquals(valid, parser.parse(test_args2));

        // all wrong inputs
        String[] test_args3 = {"bagno", "2138", "hibdfaihbafbi", "ff"};
        try{
            MoveDirection[] output = parser.parse(test_args);
            Assertions.fail("This should have failed since the arguments were invalid");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true, "successfully caught good exception");
        }


    }
}
