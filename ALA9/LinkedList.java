/**
 * Kevin Dotel
 * LinkedList.java
 */
import java.util.*;

public class LinkedList<E> {
    // Data members
   private Node head, tail;
   int size;
    // Inner class Node
   private class Node   {
   E value;
   Node next;
   Node(E initialValue){
   value = initialValue; next = null;
        }
    }

   // Constructor
    public LinkedList() {
    head = tail = null;
    size = 0;
        }

    // Adding an item to the list
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if(head == null) { 
            head = tail = newNode; }
        else { 
        newNode.next = head;
        head = newNode;
        }
        size++; return true;
        }

    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if(head == null) { head = tail = newNode; }
        else { tail.next = newNode; tail = newNode; }
        size++; return true;
        }

    public boolean add(E item) {
        return addFirst(item);
        }

        // Retrieving an item from the list
    public E getFirst() {
        if (head == null)
        throw new NoSuchElementException();
        return head.value;
        }

        public E getLast() {
            if (head == null)
            throw new NoSuchElementException();
            return tail.value;
            }

        // Removing an item from the list
    public boolean removeFirst() {
        if (head == null) throw new NoSuchElementException();
        head = head.next;
        if(head == null) tail=null;
        size--; return true;
        }

    public boolean removeLast() {
        if (head == null) throw new NoSuchElementException();
        if(size == 1) return removeFirst();
        Node current = head;
        Node previous = null;
        while(current.next != null) {
        previous = current; current = current.next;
        }
        previous.next = null; tail = previous;
        size--; return true;
        }

        // toString() method
    public String toString() {
        String output = "[";
        Node node = head;
        while(node != null) {
        output += node.value + " ";
        node = node.next;
        }
        output += "]";
        return output;
        }

        // clear, check if empty, and size of the list
    public void clear() { 
        head = tail = null; size = 0; }
    public boolean isEmpty() { 
        return (size == 0); }
    public int size() { 
        return size; }

        // Implementing an iterator for the list
    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node current = head;
        public boolean hasNext() {
        return (current != null);
        }
        public E next() {
        if(current == null)
        throw new NoSuchElementException();
        E value = current.value;
        current = current.next; return value;
            }
        }

        //method contains
    public int contains(Object o) {
        Iterator<E> iter = iterator();
        int iterations = 0;

        while(iter.hasNext()) {
            iterations++;
            if(iter.next().equals(o)) {
                return iterations;
            }
        }
        return iterations;
    }

    //method remove
    public int remove(E item) {
        int iterations = 0;
        Node current = head;
        Node previous = null;

        while(current != null && current.value.equals(item)) {
            iterations++;
            previous = current;
            current = current.next;
        }
        
        if(current != null) {
            if(previous == null) {
                removeFirst();
            }
            else {
                previous.next = current.next;
            }
        }

        return iterations;
    }

    //Method add(int, E)
    public int add(int index, E item) {
        if(index > size || index < 0) {
        throw new ArrayIndexOutOfBoundsException();
        }
        int iterations = 0;
        if(index == 0) {
            addFirst(item);
            return iterations;
        }
        if(index == size-1) {
            addLast(item);
            return iterations;
        }
        int i = 0;
        Node current = head;
        Node previous = null;
        while(i < index) {
            iterations++;
            previous = current;
            current = current.next;
            i++;
        }
        Node newNode = new Node(item);
        previous.next = newNode;
        newNode.next = current;
        size++;
        return iterations;
    }







    }