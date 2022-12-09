/***
 * Class to model the entity Test
 * @author Jiajun Ye
 * @version 0.1
 * Date of creation: April 17, 2022
 * Last Date Modified: April 17, 2022
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
public class Test {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        LinkedList<String> ll = new LinkedList<>();
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        readFromFile(al, "countries.txt");
        readFromFile(ll, "countries.txt");
        readFromFile(dll, "countries.txt");

        //Printing the data points
        System.out.println("ArrayList:");
        printListForward(al);
        System.out.println("LinkedList:");
        printListForward(ll);
        System.out.println("DoublyLinkedList:");
        printListForward(dll);
        System.out.println("ArrayList:");
        printListBackward(al);
        System.out.println("LinkedList:");
        printListBackward(ll);
        System.out.println("DoublyLinkedList:");
        printListBackward(dll);
    }
    /**
    * Method to read data from file into List type data structure
    * @param list List type data structure to store data
    * @param filename name of file to search
    * No return value
    */
    public static void readFromFile(List<String> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                list.add(read.nextLine());
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }   
    }

    /** 
     * Method to print items forwards
     * @param list data source
     * No return value
     */
    // For all lists: O(n)
    public static <E> void printListForward(List<E> list) {
        int counter = 0;
        ListIterator<E> iter = list.ListIterator();
        System.out.print("Printing forward:\n");
        while (iter.hasNext()) {
            System.out.printf("%-50s", iter.next());
            counter++;
            if (counter%4 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n\n");
    }

    
    /** 
     * Method to print items backwards
     * @param list data source
     * No return value
     */
    // DoublyLinkedList: O(n)
    // LinkedList: O(n^2)
    // ArrayList: O(n)
    public static <E> void printListBackward(List<E> list) {
        int counter = 0;
        ListIterator<E> iter = list.ListIterator(list.size());
        System.out.print("Printing backwards:\n");
        while (iter.hasPrevious()) {
            System.out.printf("%-50s", iter.previous());
            counter++;
            if (counter%4 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n\n");
    }

    
}
