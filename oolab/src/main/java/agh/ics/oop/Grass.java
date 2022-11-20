package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass extends AbstractWorldMapElement{
    private Vector2d position;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
//    private IWorldMap map;

    public Grass (Vector2d position) {
        super(position);
    }

    public String toString() {
        return "*";
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }
}
