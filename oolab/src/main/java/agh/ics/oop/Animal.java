package agh.ics.oop;


public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        return "(%s, %s)".formatted(this.position.toString(), this.orientation.toString());
    }

    public boolean isAt(Vector2d position) {
        if(this.position.equals(position)) return true;
        else return false;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD: switch (this.orientation) {
                case NORTH: if(new Vector2d(4, 3).precedes(this.position)) this.position = this.position.add(new Vector2d(0, 1));
                break;
                case EAST: if(new Vector2d(3, 4).precedes(this.position)) this.position = this.position.add(new Vector2d(1, 0));
                break;
                case SOUTH: if(new Vector2d(0, 1).follows(this.position)) this.position = this.position.add(new Vector2d(0, -1));
                break;
                case WEST: if(new Vector2d(1, 0).follows(this.position)) this.position = this.position.add(new Vector2d(-1, 0));
                break;
            }
            break;
            case BACKWARD: switch (this.orientation) {
                case NORTH: if(new Vector2d(1, 1).follows(this.position)) this.position = this.position.subtract(new Vector2d(0, 1));
                break;
                case EAST: if(new Vector2d(1, 1).follows(this.position)) this.position = this.position.subtract(new Vector2d(1, 0));
                break;
                case SOUTH: if(new Vector2d(4, 3).precedes(this.position)) this.position = this.position.subtract(new Vector2d(0, -1));
                break;
                case WEST: if(new Vector2d(3, 4).precedes(this.position)) this.position = this.position.subtract(new Vector2d(-1, 0));
                break;
            }
            break;
            case RIGHT: this.orientation = this.orientation.next();
            break;
            case LEFT: this.orientation = this.orientation.previous();
            break;
        }
    }
}
