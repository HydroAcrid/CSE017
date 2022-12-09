/***
 * Class to model the entity ArrayList
 * @author Jiajun Ye
 * @version 0.1
 * Date of creation: April 17, 2022
 * Last Date Modified: April 17, 2022
 */
import java.util.Iterator;
import java.util.ListIterator;
public class FakeArrayList<E> implements List<E>{
    // data members
    private E[] elements;
    private int size;

    /**
     * Default Constructor
     * No params
     * Set elements equal to Object array and the size variable to 0
     */
    public FakeArrayList() { //O(1)
        elements = (E[]) new Object[10];
        size = 0;
    }
    /**
     * Constructor with one parameter
     * @param length size of array
     * Set elements equal to new Object array and size to zero
     */
    public FakeArrayList(int length ) {  //O(1)
        elements = (E[]) new Object[length];
        size = 0;
    }
    /** 
     * Method to add new item to back of list
     * @param item generic item to add
     * @return boolean indicating success of method
     */
    public boolean add(E item) {  //O(1) - majority of the time, O(n) - worst case
        return add(size, item);  
    }
    /** 
     * Method to add item to specific index
     * @param index specific index to add item
     * @param item generic item to add
     * @return boolean which states the success of the method
     */
    public boolean add(int index, E item){  //O(n)
        if(index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        ensureCapacity();   //O(n)
        for(int i=size-1; i>index; i--) {  //O(n) ~ worst case
            elements[i+1] = elements[i];
        }
        elements[index] = item;
        size++;
        return true;
    }
    /** 
     * Method to get item at specific index
     * @param index index to search
     * @return E generic item at index
     */
    public E get(int index) {  //O(1)
        checkIndex(index);
        return elements[index];
    }
    /** 
     * Method to set element at specific index
     * @param index index of item to set/replace
     * @param item generic item to set
     * @return E Old element at the index
     */
    public E set(int index, E item) {  //O(1)
        checkIndex(index);
        E oldItem = elements[index];
        elements[index] = item;
        return oldItem;
    }
    /** 
     * Method to return the arraylist size
     * No params
     * @return int size
     */
    public int size() { return size; }  //O(1)
    
    /** 
     * Method to completely clear the arraylist
     * No params
     * No return value
     */
    public void clear() { size = 0; }  //O(1)
    
    /** 
     * Method to check if the arraylist is empty
     * No params
     * @return boolean if size == 0
     */
    public boolean isEmpty() { return (size == 0);}  //O(1)

    /** 
     * Method to remove specific object in list
     * @param o Object to remove
     * @return boolean indicating success of method
     */
    public boolean remove(Object o) {  // O(n)
        E item = (E) o;
        for(int i=0; i<size; i++)
            if(elements[i].equals(item)){
                remove(i);  //O(n)
                return true;
            }
        return false;
    }
    /** 
     * Method to remove object at specific index
     * @param index of object to remove
     * @return E generic removed object
     */
    public E remove(int index) {  //O(n)
        checkIndex(index);  //O(1)
        E item = elements[index];
        for(int i=index; i<size-1; i++)  //O(n)
            elements[i] = elements[i+1];
        size--;
        return item;
    }
    /** 
     * Method to trim array size to number of elements
     * No param
     * No return value
     */
    public void trimToSize() {  //O(n)
        if (size != elements.length) {
            E[] newElements = (E[]) new Object[size];
            for(int i=0; i<size; i++)  //O(n)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }
    /** 
     * Method to lengthen array size by 50%
     * No param
     * No return value
     */
    private void ensureCapacity() {  //O(n) ~ worst case
        if(size >= elements.length) {
            int newCap = (int) (elements.length * 1.5);
            E[] newElements = (E[]) new Object[newCap];
            for(int i=0; i<size; i++)  //O(n)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }
    /** 
     * Method to validity of index
     * @param index to check
     * No return value
     * Throws exception if index is negative or greater than size
     */
    private void checkIndex(int index){  //O(1)
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(
            "Index out of bounds. Must be between 0 and "+
            (size-1));
    }

    
    /** 
     * Method to convert arraylist to string
     * No params
     * @return String contianing all arraylist elements
     */
    public String toString() {  //O(n)
        String output = "[";
        for(int i=0; i<size-1; i++)  //O(n)
            output += elements[i] + " ";
        output += elements[size-1] + "]";
        return output;
    }


    /**
     * Class to model ArrayIterator object
     */
    private class ArrayIterator implements Iterator<E>{
        //data members
        private int current = -1;
        /**
         * Method to determine whether a next element exists
         * No param
         * @return boolean whether current index is less than the last index
         */
        public boolean hasNext() {  //O(1)
            return current < size-1;
        }
        /**
         * Method to retrieve next element in arraylist
         * No param
         * @return E generic value at next index
         */
        public E next() {  //O(1)
            return elements[++current];
        }
    }
    /** 
     * Method to return an Iterator object
     * No param
     * @return Iterator<E> object that iterates through arraylist
     */
    public Iterator<E> iterator() {  //O(1)
        return new ArrayIterator();
    }
    /**
     * Class to model ArrayListIterator object
     */
    private class ArrayListIterator<E> implements ListIterator<E>{
        //data members
        private int current = -1;   
        /**
         * Default constructor
         */
        public ArrayListIterator() {}
        /**
         * Constructor w/ single param
         * @param index to start interator at
         */
        public ArrayListIterator(int index) {
            while (current < index) {
                current++;
                if (current > size - 1) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
        /**
         * Method to determine whether next element exists
         * No params
         * @return boolean whether current index is less than last index
         */
        public boolean hasNext() {
            return current < size - 1;
        }
        /**
         * Method to retrieve next element
         * No params
         * @return E generic object at next index
         * Increments current index
         */
        public E next() {
            return (E)elements[++current];
        }
        /**
         * Method to determine whether previous element exists
         * No params
         * @return boolean whether current index is greater than zero
         */
        public boolean hasPrevious() {
            return current > 0;
        }
        /**
         * Method to retrieve previous element
         * No params
         * @return E generic object at previous index
         * Decrements current index
         */
        public E previous() {
            return (E)elements[--current];
        }

        //Un-used methods 
        public int nextIndex() {throw new UnsupportedOperationException();}
        public int previousIndex() {throw new UnsupportedOperationException();}
        public void set(E value) {throw new UnsupportedOperationException();}
        public void add(E value) {throw new UnsupportedOperationException();}
        public void remove() {throw new UnsupportedOperationException();}
    }

    
    /** 
     * Method to return ListIterator<E> object
     * @return ListIterator<E> iterator beginning at first index
     * No param
     */
    public ListIterator<E> listIterator() {
        ListIterator<E> firstElement = new ArrayListIterator<E>();
        return firstElement;
    }

    /** 
     * Method to return ListIterator<E> object at specific index
     * @param index to start the iterator
     * @return ListIterator<E> iterator beginning at certain index
     */
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> firstElement = new ArrayListIterator<>();
        try{
            firstElement = new ArrayListIterator<>(index);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bounds");
        }
        return firstElement;
    }
}