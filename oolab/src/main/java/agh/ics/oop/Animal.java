package agh.ics.oop;


public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private Vector2d position = new Vector2d(2, 2);

    public Animal() { this.position = new Vector2d(2, 2); }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
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

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD: switch (this.orientation) {
                case NORTH: if(this.map.canMoveTo(this.position.add(new Vector2d(0, 1)))) this.position = this.position.add(new Vector2d(0, 1));
                break;
                case EAST: if(this.map.canMoveTo(this.position.add(new Vector2d(1, 0)))) this.position = this.position.add(new Vector2d(1, 0));
                break;
                case SOUTH: if(this.map.canMoveTo(this.position.add(new Vector2d(0, -1)))) this.position = this.position.add(new Vector2d(0, -1));
                break;
                case WEST: if(this.map.canMoveTo(this.position.add(new Vector2d(-1, 0)))) this.position = this.position.add(new Vector2d(-1, 0));
                break;
            }
            break;
            case BACKWARD: switch (this.orientation) {
                case NORTH: if(this.map.canMoveTo(this.position.subtract(new Vector2d(0, 1)))) this.position = this.position.subtract(new Vector2d(0, 1));
                break;
                case EAST: if(this.map.canMoveTo(this.position.subtract(new Vector2d(1, 0)))) this.position = this.position.subtract(new Vector2d(1, 0));
                break;
                case SOUTH: if(this.map.canMoveTo(this.position.subtract(new Vector2d(0, -1)))) this.position = this.position.subtract(new Vector2d(0, -1));
                break;
                case WEST: if(this.map.canMoveTo(this.position.subtract(new Vector2d(-1, 0)))) this.position = this.position.subtract(new Vector2d(-1, 0));
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
