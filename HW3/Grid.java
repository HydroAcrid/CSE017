import java.util.*;
import java.io.*;


public class Grid <E> {

    private ArrayList<ArrayList<E>> cells;
    private int rows;
    private int cols;

    public Grid() {
        int[][] table = new int[10][10];
    }

    public Grid(int rows, int cols) {
        int[][] table = new int[rows][cols];
    }

    public Grid(E[][] array) {
        E[][] table = array;
        
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private void checkRow(int r) {
        //Checks if the row is valid or not 
        try {
        int[] temp = new int[r];
        if(r < 0 || r>= temp.length) throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Row out of bounds");
        }

    }
    
    private void checkCol(int c) {
        //Checks if the col is valid or not
        try {
            int[] temp = new int[c];
            if(c < 0 || c >= temp.length) throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Column out of bounds");
        }
    }   

    public E get(int rows, int cols) {
        int[][] temp = new int[rows][cols]; 
        checkRow(rows);
        checkCol(cols);
        //What would this return exactly? 
        return cells;
        
    }

    public E set(int rows, int cols, Grid<E>v) {
        checkRow(rows);
        checkCol(cols);
        //What would this return exactly?
        return cells; 
        
    }

    public String toString() {
        return "null";
    }



}