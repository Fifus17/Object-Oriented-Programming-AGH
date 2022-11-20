package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    Comparator<Vector2d> CompareOnX = new OnXComparator(true);
    SortedSet<Vector2d> sortedSetOnX = new TreeSet<>(CompareOnX);
    Comparator<Vector2d> CompareOnY = new OnXComparator(false);
    SortedSet<Vector2d> sortedSetOnY = new TreeSet<>(CompareOnY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d element){
        sortedSetOnX.add(element);
        sortedSetOnY.add(element);
    }

    public void removeElement(Vector2d element){
        sortedSetOnY.remove(element);
        sortedSetOnX.remove(element);
    }

    public Vector2d getBottomLeft(){
        return new Vector2d(sortedSetOnX.first().x, sortedSetOnY.first().y);
    }

    public Vector2d getTopRight(){
        return new Vector2d(sortedSetOnX.last().x, sortedSetOnY.last().y);
    }
}
