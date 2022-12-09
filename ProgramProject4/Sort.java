/**
 * Kevin Dotel
 * Sort.java
 * 5/5/22
 */

import java.util.ArrayList;

public class Sort {
    //data members
    public static int[] randomIterations = new int[8];
    
    /**
     * Selection sort method
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        int minIndex;
        for (int i=0; i<list.size()-1; i++) {
            randomIterations[0]++;
            
            E min = list.get(i);
            minIndex = i;
            for (int j=i; j<list.size(); j++){
                randomIterations[0]++;
               
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
            randomIterations[1]++;
            
            //Insert element i in the sorted sub-list
            E currentVal = list.get(i);
            int j = i;
            while (j > 0 && currentVal.compareTo(list.get(j - 1)) < 0) {
                randomIterations[1]++;
                
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
            randomIterations[2]++;
            
            sorted = true;
            for (int i=0; i<list.size()-k; i++) {
                randomIterations[2]++; 
                
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
            randomIterations[3]++;
            
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
        randomIterations[3]++;
        
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
            randomIterations[3]++;
           
            if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
                list.set(listIndex++, list1.get(list1Index++));
            else
                list.set(listIndex++, list2.get(list2Index++));
        }
        while(list1Index < list1.size()){
            randomIterations[3]++;
           
            list.set(listIndex++, list1.get(list1Index++));
        }
            
        while(list2Index < list2.size()){
            randomIterations[3]++;
            
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
        randomIterations[4]++;
        
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
                randomIterations[4]++;
                
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
            randomIterations[5]++;
            
            heap.add(list.get(i));
        }
        for (int i=list.size()-1; i>=0; i--) {
            randomIterations[5]++;
            
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
            randomIterations[6]++;
            
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
        for(int i=0; i<t+1; i++) {
            randomIterations[6]++;
        buckets.add(new ArrayList<>());// bucket i
        }
        //Distribute the data on the buckets
        for(int i=0; i<list.size(); i++) {
            randomIterations[6]++;
        ArrayList<Integer> bucket = buckets.get(list.get(i));
        bucket.add(list.get(i));
        }
        // Move the data from the buckets back to the list
        int k = 0;
        for(int i=0; i<buckets.size(); i++) {
            randomIterations[6]++;
        ArrayList<Integer> bucket = buckets.get(i);
        for(int j=0; j<bucket.size(); j++) {
            randomIterations[6]++;
        list.set(list.get(k++), bucket.get(j));
                }
            }
        }


    // public static void radixSort(ArrayList<Integer> list) {
    //     ArrayList<ArrayList<Integer>> buckets;
    //     buckets = new ArrayList<>(10);// 10 buckets
    //     Integer maxValue = max(list);
    //     int digits = maxValue.toString().length();
    //     for(int d=0; d<digits; d++) {
    //     for(int j=0; j<10; j++) { // create buckets for iteration d
    //     buckets.add(new ArrayList<>());
    //     randomIterations[7]++;
    //     }
    //     //Distribute the data on the buckets
    //     for(int j=0; j<list.size(); j++){
    //         randomIterations[7]++;
    //     int digit = (list.get(j) % (int)(Math.pow(10, d+1))) / (int)(Math.pow(10,d));
    //     ArrayList<Integer> bucket = buckets.get(digit);
    //     bucket.add(list.get(j));
    //     }
    //     // Move the data from the buckets back to the list
    //     list.clear();
    //      int k=0;
    //     for(int l=0; l<10; l++) {
    //         randomIterations[7]++;
    //     ArrayList<Integer> bucket = buckets.get(l);
    //     for(int j=0; j<bucket.size(); j++) {
    //         randomIterations[7]++;
    //     //list[k++] = bucket.get(j);
    //     list.set(list.get(k++), bucket.get(j));
    //         }
    //     }
    //     buckets.clear(); // for next iteration
    //         }
    //     }

    public static void RadixSort(ArrayList<Integer> list) {
        int max = 0;
        int bucketSize = 10;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);

        //Adds buckets into the bucket list
        for(int i = 0; i < bucketSize; i++) {
            randomIterations[7]++;
            buckets.add(new ArrayList<Integer>());
        }

        //locates the list item with the most values 
        for (int i = 0; i < list.size(); i++) {
            randomIterations[7]++;

            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        //Sorts the list by value of list items and multiplied through each loop
        for (int power = 1; max/power != 0; power *= bucketSize) {
            randomIterations[7]++;
            for (int i = 0; i < list.size(); i++) {
                randomIterations[7]++;
                buckets.get(list.get(i) / power % bucketSize).add(list.get(i));
            }

            int index = 0;

            for (int i = 0; i < buckets.size(); i++) {
                randomIterations[7]++;

                for (int j = 0; j < buckets.get(i).size(); j++) {
                    randomIterations[7]++;
                    list.set(index, buckets.get(i).get(j));
                    index++;
                }
            }

            //Dumps bucket value after each loop
            for (int i = 0; i < buckets.size(); i++) {
                randomIterations[7]++;
                buckets.get(i).clear();
            }
        }
        randomIterations[7] -= 11;

    }
    
    public static void clearIter(int[] iter) {
        for(int i=0; i<iter.length; i++ ) {
            iter[i] = 0;
        }
    }

}
