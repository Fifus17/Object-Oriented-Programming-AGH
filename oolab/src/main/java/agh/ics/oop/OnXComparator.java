package agh.ics.oop;

import java.util.Comparator;

public class OnXComparator implements Comparator<Vector2d> {

    private boolean flag = false;

    public OnXComparator(boolean flag){
        this.flag = flag;
    }
    @Override
    public int compare(Vector2d vec1, Vector2d vec2){
        if (flag){
            if (vec1.x< vec2.x)
                return -1;
            else if (vec1.x > vec2.x)
                return 1;
            else if (vec1.y < vec2.y)
                return -1;
            else if (vec1.y > vec2.y)
                return 1;
        }
        else{
            if (vec1.y< vec2.y)
                return -1;
            else if (vec1.y > vec2.y)
                return 1;
            else if (vec1.x < vec2.x)
                return -1;
            else if (vec1.x > vec2.x)
                return 1;
        }
        return 0;
    }
}
