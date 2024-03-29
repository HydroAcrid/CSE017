/**
 * Kevin Dotel
 * Heap.java
 * 5/5/22
 */

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    // data members
    private ArrayList<E> list;
    // empty constructor
    public Heap(){
        list = new ArrayList<>();
    }
    //Getter method for size
    public int size(){
        return list.size();
    }
    // Returns true if the ArrayList is empty
    public boolean isEmpty(){
        return list.isEmpty();
    }
    // Clears the Arraylist
    public void clear(){
        list.clear();
    }
    //toString method
    public String toString(){
        return list.toString();
    }
    // Checks if the arraylist contains a value 
    public boolean contains(E value) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(value)){
                return true;
            }
        }
        return false;
    }
    // Adds a value to the arraylist
    public void add(E value) {
        list.add(value); //append value to the heap
        int currentIndex = list.size()-1;
        //index of the last element
        while(currentIndex > 0) {
            Sort.iterations[5]++;
            int parentIndex = (currentIndex-1)/2;
            //swap if current is greater than its parent
             E current = list.get(currentIndex);
             E parent = list.get(parentIndex);
                if(current.compareTo(parent) > 0) {
                    list.set(currentIndex, parent);
                    list.set(parentIndex, current);
                }
                else{
                    break; // the tree is a heap
                }
            currentIndex = parentIndex;
        }
    }
    // removes an element from the arraylist
    public E remove() {
        if(list.size() == 0) return null;
        //copy the value of the last node to root
        E removedItem = list.get(0);
        list.set(0, list.get(list.size()-1));
        //remove the last node from the heap
        list.remove(list.size()-1);
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            Sort.iterations[5]++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            //find the maximum of the left and right nodes
            if (left >= list.size()) {
                break; // no left child
            }
            int maxIndex = left;
            E max = list.get(maxIndex);
            if (right < list.size()) // right child exists
                if(max.compareTo(list.get(right)) < 0)
                    maxIndex = right;
            // swap if current is less than max
            E current = list.get(currentIndex);
            max = list.get(maxIndex);
            if(current.compareTo(max) < 0){
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            }
            else{
                break; // the tree is a heap
            }
        }
        return removedItem;
    }
}
