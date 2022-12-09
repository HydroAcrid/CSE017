/***
 * Class to model the entity LinkedList
 * @author Jiajun Ye
 * @version 0.1
 * Date of creation: April 17, 2022
 * Last Date Modified: April 17, 2022
 */
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.ListIterator;
public class FakeLinkedList<E> implements List<E>{
    // Data members
    private Node head, tail;
    int size;

    /**
     * Default constructor
     * Set head and tail nodes to null and size to zero
     */
    public FakeLinkedList() {
        head = tail = null;
        size = 0;
    }
        
    /** 
     * Method to add element to beginning of linked list
     * @param item generic value of new node
     * @return boolean that indicate the success of the method
     * Increments size
     */
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if(head == null) { 
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }
    
    /** 
     * Method to add new node to end of linked list
     * @param item generic value for new node
     * @return boolean to indicate success of method
     * Increments size
     */
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if(head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++; return true;
    }
    
    /** 
     * Method to add new node to beginning of list
     * @param item generic value of new node
     * @return boolean indicating success of method
     * Calls addFirst method
     */
    public boolean add(E item) {
        return addLast(item);
    }

    /** 
     * Method to retrieve value of head node
     * @return E generic value of head node
     * Throws error is head is null
     */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    
    /** 
     * Method to retrieve tail node value
     * @return E generic value of tail node
     * Throws error if tail is null
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }

    /** 
     * Method to remove head node
     * @return boolean indicating success of method
     * Throws error if head is null
     * Decrements size
     */
    public boolean removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        if(head == null) {
            tail=null;
        }
        size--;
        return true;
    }

    /** 
     * Method to remove tail node
     * @return boolean indicating success of method
     * Throws exception if tail is null
     * Removes head if size is 1
     * Decrements size
     */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if(size == 1)
            return removeFirst();
        Node current = head;
        Node previous = null;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
        return true;
    }

    /** 
     * Method to return String w/ data member info
     * @return String w/ all node values
     * No params
     */
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

    /** 
     * Method to completely clear entire list
     * Set head and tail to null
     * Reset size to zero
     */
    // clear, check if empty, and size of the list
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /** 
     * Method to check if list is empty
     * @return boolean whether or not size is zero
     * No params
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** 
     * Method to return size of list
     * @return int size of list
     * No params
     */
    public int size() {
        return size;
    }

    /**
     * Class to model LinkedListIterator object
     */
    private class LinkedListIterator implements Iterator<E>{
        //Data member
        private Node current = head;
        /**
         * Method to check whether linked list has a next node
         * @return boolean whether current node is null
         * No params
         */
        public boolean hasNext() {
            return (current != null);
        }
        /**
         * Method to return next node value
         * @return E generic value of next node
         * Throws exception if current node is null
         * No params
         */
        public E next() {
            if(current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    /** 
     * Method to return an iterator starting at beginning of list
     * @return Iterator<E> iterator object
     * No params
     */
    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    /**
     * Class to model LinkedListListIterator
     */
    private class LinkedListListIterator implements ListIterator<E> {
        //Data members
        private Node current = head;
        private Node previous = null;
        /**
         * Default constructor
         * No params
         */
        public LinkedListListIterator(){}
        /**
         * Constructor w/ single parameter
         * @param index index to begin iterator
         */
        public LinkedListListIterator(int index) {
            for (int i = 0; i < index; i++) {
                if (current == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                previous = current;
                current = current.next;
            }
        }
        /**
         * Method to check whether next node exists
         * @return boolean whether current node is null
         * No param
         */
        public boolean hasNext() {
            return current != null;
        }  
        /**
         * Method to return next node value
         * @return E generic value of next node
         * Throws exception if current node is null
         */
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = (E)current.value;
            previous = current;
            current = current.next;
            return value;
        }
        /**
         * Method to check whether previous node exists
         * @return boolean whether previous node is null
         * No param
         */
        public boolean hasPrevious() {
            return previous != null;
        }
        /**
         * Method to return previous node value
         * @return E generic value of previous node
         * Current node moved backwards in list
         * Previous node moved backwards in list
         * Throws exception if previous node is null
         */
        public E previous() {
            if (previous == null) {
                throw new NoSuchElementException();
            }
            E value = (E) previous.value;
            current = previous;
            if (current == head) {
                previous = null;
            }
            else {
                previous = head;
            }
            
            while (previous != null && previous.next != current) {
                previous = previous.next;
            }
            return value;
        }
        //Un-used methods throw UnsupportOperationException when called
        public int nextIndex() {throw new UnsupportedOperationException();}
        public int previousIndex() {throw new UnsupportedOperationException();}
        public void set(E value) {throw new UnsupportedOperationException();}
        public void add(E value) {throw new UnsupportedOperationException();}
        public void remove() {throw new UnsupportedOperationException();}
    }

    //Class to model a node in a linked list
    private class Node{
        //data members
        E value;
        Node next;
        /**
         * Constructor with one parameter
         * @param initialValue generic initial value to set node
         * Sets next node equal to null
         */
        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }

    /** 
     * Method to return ListIterator object starting at beginning of list
     * @return ListIterator<E>
     * No params
     */
    public ListIterator<E> listIterator() {
        ListIterator<E> firstElement = new LinkedListListIterator();
        return firstElement;
    }
    /** 
     * Method to return list iterator object starting at specific index
     * @param index start index of iterator
     * @return ListIterator<E>
     */
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> firstElement = new LinkedListListIterator();
        try{
            firstElement = new LinkedListListIterator(index);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bounds");
        }
        return firstElement;
}
}
