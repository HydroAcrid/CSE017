/**
 * Kevin Dotel
 * Test.java
 */
import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();
        readFile(animalAL, animalLL, "animals.txt");
        testContains(animalAL, animalLL);
        testAdd(animalAL, animalLL);
        testRemove(animalAL, animalLL);
    }

    /**
     * Reads the animals.txt file and adds them into the arraylist and linkedlist
     * @param al - arraylist
     * @param LL - linkedlist
     * @param filename - animals.txt file 
     */
    public static void readFile(ArrayList<String> al, LinkedList<String> LL, String filename) {
        File file = new File("animals.txt");
        try {
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()) {
                String name = scnr.nextLine();
                al.add(name);
                LL.add(name);
            }
            scnr.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    /**
     * Checks if the arraylist and linkedlist contains the element or not 
     * @param al - arraylist
     * @param LL - linkedlist
     */
    public static void testContains(ArrayList<String> al, LinkedList<String> LL) {
        int totalIterAl = 0, totalIterLL = 0;
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i =0; i<20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int iterAl = al.contains(randomName);
            int iterLL = LL.contains(randomName);

            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAl, iterLL);
            totalIterAl += iterAl;
            totalIterLL += iterLL;            
        } 
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAl/20, totalIterLL/20);

    }

    /**
     * Adds the element into the arraylist and linkedlist
     * @param al - arraylist
     * @param LL - linkedlist
     */
    public static void testAdd(ArrayList<String> al, LinkedList<String> LL) {
        int totalIterAl = 0, totalIterLL = 0;
        System.out.println("\n\nTesting the method contains(Object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i =0; i<20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int iterAl = al.add(randomIndex, randomName);
            int iterLL = LL.add(randomIndex, randomName);

            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAl, iterLL);
            totalIterAl += iterAl;
            totalIterLL += iterLL;            
        } 
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAl/20, totalIterLL/20);

    }

    /**
     * Removes the elements from the arraylist and linkedlist
     * @param al - arraylist
     * @param LL - linkedlist
     */
    public static void testRemove(ArrayList<String> al, LinkedList<String> LL) {
        int totalIterAl = 0, totalIterLL = 0;
        System.out.println("\n\nTesting the method contains(Object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i =0; i<20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int iterAl = al.remove(randomName);
            int iterLL = LL.remove(randomName);

            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAl, iterLL);
            totalIterAl += iterAl;
            totalIterLL += iterLL;            
        } 
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAl/20, totalIterLL/20);

    }






}
