//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalMovingTest {
//
//    @Test
//    void orientationTest() {
//        Animal hippo = new Animal();
//        hippo.move(MoveDirection.RIGHT);
//        assertEquals("((2, 2), Wschód)", hippo.toString());
//        hippo.move(MoveDirection.RIGHT);
//        hippo.move(MoveDirection.LEFT);
//        hippo.move(MoveDirection.LEFT);
//        assertEquals("((2, 2), Północ)", hippo.toString());
//        hippo.move(MoveDirection.LEFT);
//        hippo.move(MoveDirection.LEFT);
//        assertEquals("((2, 2), Południe)", hippo.toString());
//        hippo.move(MoveDirection.RIGHT);
//        assertEquals("((2, 2), Zachód)", hippo.toString());
//    }
//
//    @Test
//    void positionTest(){
//        Animal hippo = new Animal();
//        hippo.move(MoveDirection.FORWARD);
//        assertEquals("((2, 3), Północ)", hippo.toString());
//        hippo.move(MoveDirection.RIGHT);
//        hippo.move(MoveDirection.FORWARD);
//        hippo.move(MoveDirection.FORWARD);
//        assertEquals("((4, 3), Wschód)", hippo.toString());
//        hippo.move(MoveDirection.BACKWARD);
//        assertEquals("((3, 3), Wschód)", hippo.toString());
//        hippo.move(MoveDirection.RIGHT);
//        hippo.move(MoveDirection.FORWARD);
//        hippo.move(MoveDirection.FORWARD);
//        assertEquals("((3, 1), Południe)", hippo.toString());
//    }
//
//    @Test
//    void borderParserTest() {
//        Animal hippo = new Animal();
//        OptionsParser parser = new OptionsParser();
//        String[] moves = {"f", "f", "f", "f"};
//        MoveDirection[] steps = parser.parse(moves);
//        for(MoveDirection step: steps) {
//            hippo.move(step);
//        }
//        assertEquals("((2, 4), Północ)", hippo.toString());
//        String[] moves1 = {"r", "f", "f", "f"};
//        MoveDirection[] steps1 = parser.parse(moves1);
//        for(MoveDirection step: steps1) {
//            hippo.move(step);
//        }
//        assertEquals("((4, 4), Wschód)", hippo.toString());
//        String[] moves2 = {"b", "b", "b", "b", "b", "b", "b"};
//        MoveDirection[] steps2 = parser.parse(moves2);
//        for(MoveDirection step: steps2) {
//            hippo.move(step);
//        }
//        assertEquals("((0, 4), Wschód)", hippo.toString());
//        String[] moves3 = {"r", "f", "f", "f", "f", "f", "f"};
//        MoveDirection[] steps3 = parser.parse(moves3);
//        for(MoveDirection step: steps3) {
//            hippo.move(step);
//        }
//        assertEquals("((0, 0), Południe)", hippo.toString());
//    }
//}
//
//// Moim zdaniem powinniśmy stworzyć observera, który na bieżąco śledzi zależnie od stosunku ilości zwierząt do wielkości
//// mapy albo macierz z zajęciem pól na planszy albo pozycję poszczególnych zwierząt. Do metodyAnimal.move() trzeba
//// dodać warunek sprawdzający dostępność danego pola bądź kolizję z innym zwierzęciem. W pierwszym przypadku potrzebujemy
//// dużej ilości pamięci na macierz Op(ilość pól), Ocz(1), w drugiej sprawdzanie zajmuje więcej czasu Ocz(ilość zwierząt)
//// Op(ilość zwierząt)
