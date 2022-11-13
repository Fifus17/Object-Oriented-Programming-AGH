package agh.ics.oop;


import java.util.*;

public class Animal extends AbstractWorldMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private List<IPositionChangeObserver> observers;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.map = map;
        this.observers = new ArrayList<>();
    }

    public String toString() {
        switch (this.orientation) {
            case NORTH: return "N";
            case SOUTH: return "S";
            case EAST: return "E";
            case WEST: return "W";
        }
        return "";
    }

    public boolean isAt(Vector2d position) {
        if(this.position.equals(position)) return true;
        else return false;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    void move(MoveDirection direction) {
        boolean opposite = false;
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case BACKWARD:
                opposite = true;
            case FORWARD:
                Vector2d movementChange = this.orientation.toUnitVector();
                if (opposite)
                    movementChange = movementChange.opposite();
                Vector2d newPos = this.position.add(movementChange);
                if (map.canMoveTo(newPos))
                    positionChanged(newPos);
                break;
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d newPos) {
        for (IPositionChangeObserver observer : observers)
            observer.positionChanged(this.position, newPos);
            this.position = newPos;
    }

}

