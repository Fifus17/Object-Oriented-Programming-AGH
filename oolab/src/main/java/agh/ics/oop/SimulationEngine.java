package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private final MoveDirection[] moves;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        for(int i=0; i<positions.length; i++) {
            Animal newAnimal = new Animal(map, positions[i]);
            if(map.place(newAnimal)) animals.add(newAnimal);
        }
    }

    @Override
    public void run() {
        for (int i=0; i<moves.length; i++) {
            animals.get(i % animals.size()).move(moves[i]);
        }
    }

    public Animal getAnimal(int index) {
        return this.animals.get(index);
    }
}
