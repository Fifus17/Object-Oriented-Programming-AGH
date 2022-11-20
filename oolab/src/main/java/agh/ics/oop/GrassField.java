package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{
    private final int numOfGrassFields;
    private final MapVisualizer visualizer = new MapVisualizer(this);
    private Map<Vector2d, Grass> grassFields = new LinkedHashMap<>();


    public GrassField (int number) {
        super(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1);
        this.numOfGrassFields = number;
        this.mapBoundary = mapBoundary;
        this.initializer();
    }

    private void initializer() {
        boolean flag = true;
        for (int i=0; i<numOfGrassFields; i++) {
            while(flag) {
                int x = (int) Math.floor(Math.random() * (int) Math.sqrt(10 * numOfGrassFields));
                int y = (int) Math.floor(Math.random() * (int) Math.sqrt(10 * numOfGrassFields));
                flag = isOccupied(new Vector2d(x, y));
                if (!flag) placeGrass(new Grass(new Vector2d(x, y)));
            }
            flag = true;
        }
    }

    public String toString() {
        Vector2d[] cords = {
                new Vector2d(this.mapBoundary.sortedSetOnX.first().x, this.mapBoundary.sortedSetOnY.first().y),
                new Vector2d(this.mapBoundary.sortedSetOnX.last().x, this.mapBoundary.sortedSetOnY.last().y)
        };
        return visualizer.draw(cords[0], cords[1]);
    }

//    public Vector2d[] findPosition() {
//        Vector2d min = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        Vector2d max = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
//        Vector2d[] result = {min, max};
//        for (Map.Entry<Vector2d, Animal> set :
//                animals.entrySet()) {
//            if(set.getValue().getPosition().x > max.x) max = new Vector2d(set.getValue().getPosition().x, max.y);
//            if(set.getValue().getPosition().y > max.y) max = new Vector2d(max.x, set.getValue().getPosition().y);
//            if(set.getValue().getPosition().x < min.x) min = new Vector2d(set.getValue().getPosition().x, min.y);
//            if(set.getValue().getPosition().y < min.y) min = new Vector2d(min.x, set.getValue().getPosition().y);
//        }
//        for (Map.Entry<Vector2d, Grass> set :
//                grassFields.entrySet()) {
//            if(set.getValue().getPosition().x > max.x) max = new Vector2d(set.getValue().getPosition().x, max.y);
//            if(set.getValue().getPosition().y > max.y) max = new Vector2d(max.x, set.getValue().getPosition().y);
//            if(set.getValue().getPosition().x < min.x) min = new Vector2d(set.getValue().getPosition().x, min.y);
//            if(set.getValue().getPosition().y < min.y) min = new Vector2d(min.x, set.getValue().getPosition().y);
//        }
//        return result;
//    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position))
            return true;
        if (grassFields.get(position) instanceof Grass) {
            return true;
        }
        return false;
    }

    public boolean canMoveTo(Vector2d position) {
        if (position.precedes(mapBorderBottomLeft) &&
                position.follows(mapBorderTopRight) &&
                !(objectAt(position) instanceof Animal)) {
            // now lets check if animal will land on grass
            Object checkedPos = objectAt(position);
            if (checkedPos instanceof Grass) {
                // "eating" grass
                System.out.println("stepped in, generating");
                grassFields.remove(checkedPos);
                // spawning one grass
                boolean flag = true;
                while(flag) {
                    int x = (int) Math.floor(Math.random() * (int) Math.sqrt(10 * numOfGrassFields));
                    int y = (int) Math.floor(Math.random() * (int) Math.sqrt(10 * numOfGrassFields));
                    flag = isOccupied(new Vector2d(x, y));
                    if (!flag) placeGrass(new Grass(new Vector2d(x, y)));
                }
            }
            return true;
        }
        return false;
    }

    public boolean placeGrass(Grass grass) {
        if (!isOccupied(grass.getPosition())) {
            grassFields.put(grass.getPosition(), grass);
            grass.addObserver(this.mapBoundary);
            mapBoundary.addElement(grass.getPosition());
            return true;
        }
        throw new IllegalArgumentException(grass.getPosition() + " is not a valid position to place grass");
    }

    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        if (grassFields.get(position) instanceof Grass) {
            return grassFields.get(position);
        }
        return null;
    }
}
