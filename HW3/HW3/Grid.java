/**
 * Kevin Dotel
 * Grid.java
 *3/21/22
 */
import java.util.*;
import java.io.*;


public class Grid <E> {

    //private ArrayList<ArrayList<E>>[][] cells;
    private E[][] cells;
    private int rows;
    private int cols;

    public Grid() {
        cells = (E[][]) new ArrayList[10][10];
    }

    public Grid(int rows, int cols) {
        cells = (E[][]) new ArrayList[rows][cols];
    }

    public Grid(E[][] array) {
        // E[][] table = array;
        // cells = (ArrayList<ArrayList<E>>[][]) array;
        cells = array;
        
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
        if(r < 0 || r > 10) throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Row out of bounds");
        }

    }
    
    private void checkCol(int c) {
        //Checks if the col is valid or not
        try {
            int[] temp = new int[c];
            if(c < 0 || c > 10) throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Column out of bounds");
        }
    }   

    public E get(int rows, int cols) {
        //int[][] temp = new int[rows][cols];
        //cells = new ArrayList[rows][cols];
        checkRow(rows);
        checkCol(cols);
        //What would this return exactly? 
        return cells[rows][cols];
        
    }

    public void set(int rows, int cols, E v) {
        //cells = new ArrayList[rows][cols];
        checkRow(rows);
        checkCol(cols);
        cells[rows][cols] = v;
        //What would this return exactly?

        
    }

    public String toString() {
        String output = "";
        for(int i = 0; i< rows; i++){
            output += "[ ";
            for(int j = 0; j< cols;j++){
                output += get(i,j).toString() + " ";
            }
            output += "]\n";
        }
        return output;
    }



}
