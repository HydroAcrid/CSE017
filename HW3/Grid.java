import java.util.*;
import java.io.*;


public class Grid <E> {

    private ArrayList<ArrayList<E>> cells;
    private int rows;
    private int cols;

    public Grid() {
    }

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public Grid(E[][] array) {
        
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private void checkRow(int r) {
        
    }
    
    private void checkCol(int c) {

    }

    public <E> int get(Grid<E> row, Grid<E> cols) {
        return 0;
    }

    public <E> void set(Grid<E> row, Grid<E> cols) {
        
    }

    public String toString() {
        return "null";
    }



}