package Airplane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Airplane {

    private char[][] seatMap;

    public Airplane() {
        seatMap = new char[9][8];
        for(int i=0; i<seatMap.length; i++) {
            for(int j=0; j<seatMap[i].length; j++) {
                seatMap[i][j] = '.';
            }
        }
    }

    public Airplane(String filename) {
        seatMap = new char[9][8];
        readFromFile(filename);
    }

    private void readFromFile(String filename) {
        File file = new File(filename);
        try {
            Scanner readFile = new Scanner(file);
            for(int i=0; i<seatMap.length; i++) {
                for(int j=0; j<seatMap[i].length; j++) {
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
        }
        catch(FileNotFoundException e) {
            for(int i=0; i<seatMap.length; i++) {
                for(int j=0; j<seatMap[i].length; j++) {
                    seatMap[i][j] = '.';
                }
            }
        }
    }

    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException {
        if(seatNumber.matches("[1-9][A-H]")) {
            return true;
        }
        else {
            throw new InvalidSeatException("Inalid Seat Number: " + seatNumber + ". Must be [1-9][A-H]");
        }
    }

    public boolean reserveSeat(String seatNumber) throws InvalidSeatException {
        if(checkSeatNumber(seatNumber)) {
            //"3B" 3 row 2, column 1
            char rowNumber = seatNumber.charAt(0);
            char colNumber = seatNumber.charAt(1);
            int row = rowNumber - '1';
            int col = colNumber - 'A';
            if(seatMap[row][col] == '.') { //seat is free
                seatMap[row][col] = 'X';
                return true; 
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean freeSeat(String seatNumber) throws InvalidSeatException {
        if(checkSeatNumber(seatNumber)) {
            //"3B" 3 row 2, column 1
            char rowNumber = seatNumber.charAt(0);
            char colNumber = seatNumber.charAt(1);
            int row = rowNumber - '1';
            int col = colNumber - 'A';
            if(seatMap[row][col] == 'X') { //seat is not free
                seatMap[row][col] = '.';
                return true; 
            }
            else { //already free
                return false;
            }
        }
        return true;
        
    }

    public void saveMap(String filename) {
         File file = new File(filename);
         try {
         PrintWriter writeFile = new PrintWriter(file);
         for(int i=0; i<seatMap.length; i++) {
             for(int j=0; j<seatMap[i].length; j++) {
                 writeFile.print(seatMap[i][j] + " ");
             }
            writeFile.println();
         }
         writeFile.close();

         }
         catch(FileNotFoundException e) {
             System.out.println("Cannot write to file.");
         }

    }

    public String toString() {
        String  output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int i=0; i<seatMap.length; i++) {
            output += (i+1) + "\t";
            for(int j=0; j<seatMap[i].length; j++) {
                output += seatMap[i][j] + "\t";
            }
            output += "\n";
        }
        return output;
    }


    
}
