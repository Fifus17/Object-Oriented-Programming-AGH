package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(%d, %d)".formatted(this.x, this.y);
    }

    public boolean precedes(Vector2d other) {
        if(other.x <= this.x && other.y <= this.y) return true;
        else return false;
    }

    public boolean follows(Vector2d other) {
        if(other.x >= this.x && other.y >= this.y) return true;
        else return false;
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    public enum MoveDirection {
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }

    public enum MapDirection {
        NORTH,
        SOUTH,
        WEST,
        EAST;

        public String toString() {
            switch (this) {
                case NORTH: return "Północ";
                case SOUTH: return "Południe";
                case WEST: return "Zachód";
                case EAST: return "Wschód";
                default: return null ;
            }
        }

        public MapDirection next() {
            switch (this) {
                case NORTH: return EAST;
                case EAST: return SOUTH;
                case SOUTH: return WEST;
                case WEST: return NORTH;
                default: return null ;
            }
        }

        public MapDirection previous() {
            switch (this) {
                case NORTH: return WEST;
                case EAST: return NORTH;
                case SOUTH: return EAST;
                case WEST: return SOUTH;
                default: return null ;
            }
        }

        public Vector2d toUnitVecrtor() {
            switch (this) {
                case NORTH: return new Vector2d(0, 1);
                case EAST: return new Vector2d(1, 0);
                case SOUTH: return new Vector2d(0, -1);
                case WEST: return new Vector2d(-1, 0);
                default: return null ;
            }
        }
    }
}
