/***
 * Test.java
 * Kevin Dotel
 * 4/18/22
 */

import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> countryAl = new ArrayList<>();
        DoublyLinkedList<String> countryDll = new DoublyLinkedList<>();
        LinkedList<String> countryLl = new LinkedList<>();
        readFromFile(countryAl, "countries.txt");
        readFromFile(countryDll, "countries.txt");
        readFromFile(countryLl, "countries.txt");

        System.out.println("Arraylist(Forward): ");
        printListForward(countryAl);
        System.out.println("\n\nDoublyLinkedList(Forward): ");
        printListForward(countryDll);
        System.out.println("\n\nLinkedList(Forward): ");
        printListForward(countryLl);

        System.out.println("\n\nArrayList(Backwards): ");
        printListBackward(countryAl);

        System.out.println("\n\nDoublyLinkedList(Backwards): ");
        try {
        printListBackward(countryDll);
        }
        catch(Exception e) {
            System.out.println("NullPointerException");
        }

        System.out.println("\n\nLinkedList(Backwards): ");
        printListBackward(countryLl);


        
    }

    /**
     * Prints the lists forward
     * @param <E> - generic data structure
     * @param list - list being entered
     */
    public static <E> void printListForward(List<E> list) {
        ListIterator<E> iterations = list.listIterator();
        while (iterations.hasNext()) {
            System.out.printf("%-50s", iterations.next());
        }
        System.out.println("\n\n");

    }

    /**
     * Prints the lists backward
     * @param <E> - generic data structure
     * @param list - list being entered
     */
    public static <E> void printListBackward(List<E> list) {
        ListIterator<E> iterations = list.listIterator(list.size());
        while (iterations.hasPrevious()) {
            System.out.printf("%-50s", iterations.previous());
        }
        System.out.println("\n\n");
    
    }

    /**
     * Reads the file 
     * @param al - data structure
     * @param filename - file
     */
    public static void readFromFile(List<String> al, String filename) {
        File file = new File(filename);
        try {
            Scanner read = new Scanner(file);
            while(read.hasNextLine()) {
                al.add(read.nextLine());
            }
            read.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }


    }

    

    
    
}
