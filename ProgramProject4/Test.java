/**
 * Kevin Dotel
 * Test.java
 * 5/5/22
 */
import java.util.*;


public class Test {
    public static final int SIZE = 10000;

    public static void main(String[] args) {
        ArrayList<Integer> randomList = new ArrayList<>();
        int[] randomIter = new int[8];
        int[] sortedIter = new int[8];
        int[] reverseIter = new int[8];
        for(int i = 0; i < SIZE; i++) {
            randomList.add((int)(Math.random()*(SIZE-1) + 1));
        }

        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList = (ArrayList)randomList.clone();
        java.util.Collections.sort(sortedList);

        ArrayList<Integer> reverseList = new ArrayList<>();
        reverseList = (ArrayList)randomList.clone();
        java.util.Collections.reverse(reverseList);

        //RandomArray
        java.util.Collections.shuffle(randomList);
        Sort.selectionSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.insertionSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.bubbleSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.mergeSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.quickSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.heapSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.bucketSort(randomList);
        java.util.Collections.shuffle(randomList);
        Sort.RadixSort(randomList);

        for(int i=0; i<Sort.randomIterations.length; i++) {
            randomIter[i] = Sort.randomIterations[i];
        }

        System.out.println(Arrays.toString(randomIter));
        Sort.clearIter(Sort.randomIterations);


        //SortedArray
        java.util.Collections.shuffle(sortedList);
        Sort.selectionSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.insertionSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.bubbleSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.mergeSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.quickSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.heapSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.bucketSort(sortedList);
        java.util.Collections.shuffle(sortedList);
        Sort.RadixSort(sortedList);


        for(int i=0; i<Sort.randomIterations.length; i++) {
            sortedIter[i] = Sort.randomIterations[i];
        }

        System.out.println(Arrays.toString(sortedIter));
        Sort.clearIter(Sort.randomIterations);


        //ReverseArray
        java.util.Collections.shuffle(reverseList);
        Sort.selectionSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.insertionSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.bubbleSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.mergeSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.quickSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.heapSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.bucketSort(reverseList);
        java.util.Collections.shuffle(reverseList);
        Sort.RadixSort(reverseList);

        for(int i=0; i<Sort.randomIterations.length; i++) {
            reverseIter[i] = Sort.randomIterations[i];
        }

        System.out.println(Arrays.toString(reverseIter));
        Sort.clearIter(Sort.randomIterations);

        String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", 
                                "Merge Sort", "Quick Sort", "Heap Sort", "Bucket Sort", "Radix Sort"};

        System.out.printf("%-30s\t%-20s\t%-20s\t%-20s\n","Sorting Algorithm","Random","Sorted","Reversed");
        for(int i=0; i<algorithms.length; i++){
            System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", algorithms[i], randomIter[i], sortedIter[i], reverseIter[i]);
        }

        
        




        


    }



}
