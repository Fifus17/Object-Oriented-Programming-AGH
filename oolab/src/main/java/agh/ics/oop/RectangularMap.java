package agh.ics.oop;

import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        super(width - 1, height - 1, 0, 0);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }

    //    @Override
//    Vector2d[] findPosition() {
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
//        return result;
//    }
}
