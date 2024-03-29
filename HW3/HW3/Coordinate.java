/**
 * Kevin Dotel
 * Coordinate.java
 * 3/21/22
 */
public class Coordinate {

    private Pair<Integer, Integer> point;
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        // private Pair<Integer, Integer> point;
        // public int x;
        // public int y;
        this.x = x;
        this.y = y;

    }

    public int getX() {
        //return point.getFirst();
        return x;
    }

    public int getY() {
        //return point.getSecond();
        return y;
    }

    public void setX(int x) {
        this.x = x;
        //point.getFirst();
    }

    public void setY(int y) {
        this.y = y;
        //point.getSecond();
    }

    public void translateX(int d) {
       x += d;
    }

    public void translateY(int d) {
        y += d;
    }

    public void scaleX(int f) {
        x *= f;
    }

    public void scaleY(int f) {
        y *= f;
    }

    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    public boolean equals(Object o) {
        Coordinate c = (Coordinate) o;
        boolean x = c.getX() == point.getFirst();
        boolean y = c.getY() == point.getSecond();
        return x && y;
    }


    
}