import java.util.*;

public class ArrayList <E> { //O(1)
    // data members
    private E[] elements;
    private int size;
    // Constructors
    public ArrayList() { //O(1)
    elements = (E[]) new Object[10];
    size = 0;
    }
    public ArrayList(int capacity) { //O(1)
    elements = (E[]) new Object[capacity];
    size = 0;
    }

    // Adding an item to the list (2 methods)
    public boolean add(E item) { //O(n)
        return add(size, item);
        }

    public boolean add(int index, E item){ //O(n)
    if(index > size || index < 0)
    throw new ArrayIndexOutOfBoundsException();
    ensureCapacity();
    if(size == 0) {
        elements[0] = item;
    }
    else {
    for(int i=size-1; i>index; i--){
    elements[i+1] = elements[i];
     }
    elements[index] = item;
    }
    size++;
    return true;
    }

    // Getter and Setter
public E get(int index) { //O(1)
    checkIndex(index);
    return elements[index];
    }
    public E set(int index, E item) {
    checkIndex(index);
    E oldItem = elements[index];
    elements[index] = item;
    return oldItem;
    }
    // Size of the list
    public int size() { return size; }
    // Clear the list
public void clear() { size = 0; }
// Check if the list is empty
public boolean isEmpty() { 
    return (size == 0);}

    // Removing an object from the list
public boolean remove(Object o) {
    E item = (E) o;
    for(int i=0; i<size; i++)
   if(elements[i].equals(item)){
    remove(i);
    return true;
    }
    return false;
   }

   // Removing the item at index from the list
public E remove(int index) {
    checkIndex(index);
    E item = elements[index];
    for(int i=index; i<size-1; i++)
   elements[i] = elements[i+1];
    size--;
    return item;
   }

   // Shrink the list to size
public void trimToSize() {
    if (size != elements.length) {
    E[] newElements = (E[]) new Object[size];
    for(int i=0; i<size; i++)
    newElements[i] = elements[i];
    elements = newElements;
        }
    }

    // Grow the list if needed
private void ensureCapacity() {
    if(size >= elements.length) {
     int newCap = (int) (elements.length * 1.5);
    E[] newElements = (E[]) new Object[newCap];
    for(int i=0; i<size; i++)
    newElements[i] = elements[i];
    elements = newElements;
        }
    }

    // Check if the index is valid
private void checkIndex(int index){
    if(index < 0 || index >= size)
    throw new ArrayIndexOutOfBoundsException(
     "Index out of bounds. Must be between 0 and "+
     (size-1));
    }

    // toString() method
public String toString() {
    String output = "[";
    for(int i=0; i<size-1; i++)
    output += elements[i] + " ";
    output += elements[size-1] + "]";
    return output;
    }

    // Iterator for the list
public Iterator<E> iterator(){
    return new ArrayIterator();
   }

   // Inner class that implements Iterator<E>
private class ArrayIterator implements Iterator<E>{
    private int current = -1;
    public boolean hasNext() { 
        return current < size-1; }
    public E next() { 
        return elements[++current]; }
    }









}