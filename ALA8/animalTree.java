/**
 * Kevin Dotel
 * CSE17
 * 4/15/22
 */

import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class animalTree {
    public static void main(String[] args) {
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animalAL = new ArrayList<>();
        readFile(animalAL, "animals.txt");
        testAdd(animalBST, animalHeap, animalAL);
        testContains(animalBST, animalHeap, animalAL);
        testRemove(animalBST, animalHeap, animalAL);
        System.out.println("Before sorting animAl");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());

        System.out.println("\nBST is Balanced? " + animalBST.isBalanced());
        System.out.println("Heap is Balanced? " + animalHeap.isBalanced());
        animalBST.clear();
        animalHeap.clear();

        java.util.Collections.sort(animalAL);
        for(int i = 0; i < animalAL.size(); i++) {
            String name = animalAL.get(i);
            animalBST.add(name);
            animalHeap.add(name);
            
        }

        System.out.println("\nAfter sorting animAl");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());

        System.out.println("\nBST is Balanced? " + animalBST.isBalanced());
        System.out.println("Heap is Balanced? " + animalHeap.isBalanced());
        animalBST.clear();
        animalHeap.clear();

    }


    /**
     * Reads the file 
     * @param al - arraylist
     * @param filename - file
     */
    public static void readFile(ArrayList<String> al, String filename) {
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

    /**
     * Adds into the data structures
     * @param bst - BST
     * @param heap - HEAP
     * @param al - ArrayList
     */
    public static void testAdd(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBst = 0, totalHeap = 0;
        int count = 0;
        System.out.println("Testing Add()");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal Name", "BST Iterations", "Heap Iterations");
        for(int i = 0; i < al.size(); i++) {
            String name = al.get(i);
            int bstIter = bst.add(name);
            int heapIter = heap.add(name);
            if(i % 24 == 0) {
                count++;
                System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
                totalBst += bstIter;
                totalHeap += heapIter;
            }
        }

        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBst/count, totalHeap/count);
    }

    /**
     * Checks to see if the data structures contain things
     * @param bst - BST
     * @param heap - HEAP
     * @param al - Arraylist
     */
    public static void testContains(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBst = 0, totalHeap = 0;
        for(int i = 0; i < 20; i++) {
            int index = (int)(Math.random() * al.size());
            String name = al.get(index);
            int bstIter = bst.contains(name);
            int heapIter = heap.contains(name);
                System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
                totalBst += bstIter;
                totalHeap += heapIter;
        }

        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBst/20, totalHeap/20);
    }

    /**
     * Removes elements from the data structures
     * @param bst - BST
     * @param heap - HEAP
     * @param al - ArrayList
     */
    public static void testRemove(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBst = 0, totalHeap = 0;
        System.out.printf("Testing Remove()");
        System.out.printf("\n%-30s\t%-10s\t%-10s\n", "Animal Name", "BST Iterations", "Heap Iterations");
        for(int i = 0; i < 20; i++) {
            int index = (int)(Math.random() * al.size());
            String name = al.get(index);
            int bstIter = bst.remove(name);
            int heapIter = heap.remove();
                System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
                totalBst += bstIter;
                totalHeap += heapIter;
        }

        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBst/20, totalHeap/20);
    }

    
}
