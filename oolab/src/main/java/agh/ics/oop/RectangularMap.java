package agh.ics.oop;

import java.util.*;

public class RectangularMap implements IWorldMap{
    private final Vector2d mapBorderTopRightCord;
    private final Vector2d mapBorderBottomLeftCord;
    private final MapVisualizer visualizer;
    private final List<Animal> animals;

    public RectangularMap(int width, int height) {
        mapBorderBottomLeftCord = new Vector2d(0, 0);
        mapBorderTopRightCord = new Vector2d(width-1, height-1);
        this.visualizer = new MapVisualizer(this);
        this.animals = new ArrayList<>();
    }

    public String toString() {
        return visualizer.draw(mapBorderBottomLeftCord, mapBorderTopRightCord);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals) {
            if (position.equals(animal.getPosition()))
                return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(mapBorderBottomLeftCord) && position.follows(mapBorderTopRightCord) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }
}
