/**
 * Kevin Dotel
 * Test.java
 * 5/5/22
 */


import java.util.*;

public class Test {
public static final int SIZE = 10000;

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            data.add((int)(Math.random()*(SIZE-1))+ 1);
        }

        Sort.selectionSort(data);
        java.util.Collections.shuffle(data);
        Sort.insertionSort(data);

        java.util.Collections.shuffle(data);
        Sort.bubbleSort(data);

        java.util.Collections.shuffle(data);
        Sort.mergeSort(data);

        java.util.Collections.shuffle(data);
        Sort.quickSort(data);

        java.util.Collections.shuffle(data);
        Sort.heapSort(data);

        System.out.println("Data size: " + SIZE);

        String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
        for(int i=0; i<Sort.iterations.length; i++) {
            System.out.printf("%-20s\t%-10d\n", algorithms[i], Sort.iterations[i]);
        }
    }
}
