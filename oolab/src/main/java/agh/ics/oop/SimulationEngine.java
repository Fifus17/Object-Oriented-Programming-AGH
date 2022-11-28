package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import agh.ics.oop.gui.App;
import agh.ics.oop.gui.IAnimalObserver;

public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] moves;
    private final List<Animal> animals;
    private List<IAnimalObserver> observers = new ArrayList<IAnimalObserver>();
    private int delay = 0;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        for(int i=0; i<positions.length; i++) {
            Animal newAnimal = new Animal(map, positions[i]);
            if(map.place(newAnimal)) animals.add(newAnimal);
        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positions) {
        this.moves = new MoveDirection[0];
        this.animals = new ArrayList<>();
        for (Vector2d pos : positions) {
            Animal animalToAdd = new Animal(map, pos);
            if (map.place(animalToAdd))
                animals.add(animalToAdd);
        }

    }


    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move : this.moves) {
            animals.get(i).move(move);
            i++;
            if (i == animals.size())
                i = 0;
            for (IAnimalObserver observer : observers) {
                observer.animalMoved();
            }
            try {
                System.out.println("Sleeping...");
                Thread.sleep(this.delay);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted: " + ex);
            }
        }
    }

    public Animal getAnimal(int index) {
        return this.animals.get(index);
    }

    public void setDelay(int _delay) {
        this.delay = _delay;
    }

    public void setMoves(MoveDirection[] directions) {
        this.moves = directions;
    }

    public void addObserver(IAnimalObserver app) {
        this.observers.add(app);
    }

}
