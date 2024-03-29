/**
 * Kevin Dotel
 * Sort.java
 * 5/5/22
 */

import java.util.ArrayList;

public class Sort {
    //data members
    public static int[] iterations = new int[7];
    /**
     * Selection sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        int minIndex;
        for (int i=0; i<list.size()-1; i++) {
            iterations[0]++;
            E min = list.get(i);
            minIndex = i;
            for (int j=i; j<list.size(); j++){
                iterations[0]++;
                if (list.get(j).compareTo(min) < 0){
                    min = list.get(j);
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }
    /**
     * Insertion Sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
        for (int i=1; i<list.size(); i++) {
            iterations[1]++;
            //Insert element i in the sorted sub-list
            E currentVal = list.get(i);
            int j = i;
            while (j > 0 && currentVal.compareTo(list.get(j - 1)) < 0) {
                iterations[1]++;
                // Shift element (j-1) into element (j)
                list.set(j, list.get(j - 1));
                j--;
            }
            // Insert currentVal at position j
            list.set(j, currentVal);
        }
    }
    /**
     * Bubble sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
        boolean sorted = false;
        for (int k=1;k < list.size() && !sorted; k++) {
            iterations[2]++;
            sorted = true;
            for (int i=0; i<list.size()-k; i++) {
                iterations[2]++; 
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                    // swap
                    swap(list, i, i+1);
                    sorted = false;
                }
            }
        }
    }
    /**
     * SubList method
     * @param <E>
     * @param list
     * @param start
     * @param end
     * @return
     */
    public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end){
        ArrayList<E> subList = new ArrayList<>();
        for(int i=start; i<end; i++){
            iterations[3]++;
            subList.add(list.get(i));
        }
        return subList;
    }
    /**
     * Merge sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
        iterations[3]++;
        if (list.size() > 1) { // ==1: base case
            ArrayList<E> firstHalf;
            ArrayList<E> secondHalf;
            firstHalf = subList(list, 0, list.size()/2);
            secondHalf = subList(list, list.size()/2, list.size());
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }
    /**
     * Merge method
     * @param <E>
     * @param list1
     * @param list2
     * @param list
     */
    public static  <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while( list1Index < list1.size() && list2Index < list2.size()) {
            iterations[3]++;
            if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
                list.set(listIndex++, list1.get(list1Index++));
            else
                list.set(listIndex++, list2.get(list2Index++));
        }
        while(list1Index < list1.size()){
            iterations[3]++;
            list.set(listIndex++, list1.get(list1Index++));
        }
            
        while(list2Index < list2.size()){
            iterations[3]++;
            list.set(listIndex++, list2.get(list2Index++));
        }
            
    }
    /**
     * Quicksort helper method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
        quickSort(list, 0, list.size()-1);
    }
    /**
     * Quick sort method
     * @param <E>
     * @param list
     * @param first
     * @param last
     */
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
        iterations[4]++;
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex-1);
            quickSort(list, pivotIndex+1, last);
        }
    }
    /**
     * Partition method
     * @param <E>
     * @param list
     * @param first
     * @param last
     * @return
     */
    public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last){
            E pivot;
            int index, pivotIndex;
            pivot = list.get(first);// pivot is the first element
            pivotIndex = first;
            for (index = first + 1; index <= last; index++){
                iterations[4]++;
                if (list.get(index).compareTo(pivot) < 0){
                    pivotIndex++;
                    swap(list, pivotIndex, index);
                }
            }
                
            swap(list, first, pivotIndex);
            return pivotIndex;
    }
    /**
     * Heap sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
        Heap<E> heap = new Heap<>();
        for(int i=0; i<list.size(); i++){
            iterations[5]++;
            heap.add(list.get(i));
        }
        for (int i=list.size()-1; i>=0; i--) {
            iterations[5]++;
            list.set(i, heap.remove());
        }
    }
    /**
     * Swap method
     * @param <E>
     * @param list
     * @param i1
     * @param i2
     */
    public static <E> void swap(ArrayList<E> list, int i1, int i2) {
        E temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public static int max(ArrayList<Integer> list) {
        int maxValue = list.get(0);
        for(int i=1; i<list.size(); i++) {
            iterations[6]++;
            if(list.get(i) > maxValue) {
                maxValue = list.get(i);
            } 
        }
        return maxValue;
    } 
                
    //bucket sort
    public static void bucketSort(ArrayList<Integer> list) {
        int t = max(list);
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(t+1);
        for(int i=0; i<t+1; i++)
        buckets.add(new ArrayList<>());// bucket i
        //Distribute the data on the buckets
        for(int i=0; i<list.size(); i++) {
        ArrayList<Integer> bucket = buckets.get(list.get(i));
        bucket.add(list.get(i));
        }
        // Move the data from the buckets back to the list
        int k = 0;
        for(int i=0; i<buckets.size(); i++) {
        ArrayList<Integer> bucket = buckets.get(i);
        for(int j=0; j<bucket.size(); j++)
        list.set(k++, bucket.get(j));
        }
        }

}