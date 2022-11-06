package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    private Vector2d position;

    public Grass (Vector2d position) {
        super(position);
    }

    public String toString() {
        return "*";
    }
}
