package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d mapBorderTopRight;
    protected Vector2d mapBorderBottomLeft;


    public AbstractWorldMap(int TopRightX, int TopRightY, int BottomLeftX, int BottomLeftY) {
        this.mapBorderTopRight = new Vector2d(TopRightX, TopRightY);
        this.mapBorderBottomLeft = new Vector2d(BottomLeftX, BottomLeftY);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

    abstract Vector2d[] findPosition();

    public String toString() {
        Vector2d[] cords = findPosition();
        return visualizer.draw(cords[0], cords[1]);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(mapBorderBottomLeft) && position.follows(mapBorderTopRight) && !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

}