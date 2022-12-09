/***
 * Class to model the entity DoublyLinkedList
 * @author Jiajun Ye
 * @version 0.1
 * Date of creation: April 17, 2022
 * Last Date Modified: April 17, 2022
 */
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.ListIterator;
public class FakeDoublyLinkedList<E> implements List<E>{
    // Data members
    private Node head, tail;
    int size;

    /**
     * Default constructor
     * Sets head and tail nodes to null
     * Sets size to zero
     * No params
     */
    //O(1)
    public FakeDoublyLinkedList() {
        head = tail = null;
        size = 0;
    }
    /** 
     * Method to add element to beginning of linked list
     * @param item generic value of new node
     * @return boolean to indicate success of method
     * Increments size
     */
    //O(1)
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        if (tail == null) {tail = newNode;}
        size++;
        return true;
    }
    /** 
     * Method to add new node to end of linked list
     * @param item generic value of new node
     * @return boolean to indicate success of method
     * Increments size
     */
    //O(1)
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    /** 
     * Method to add new node to beginning of list
     * @param item generic value of new node
     * @return boolean indicating success of method
     * Calls addFirst method
     */
    //O(1)
    public boolean add(E item) {
        return addLast(item);
    }
    /** 
     * Method to retrieve value of head node
     * @return E generic value of head node
     * Throws error is head is null
     */
    //O(1)
    public E getFirst() {
        if (head == null) {throw new NoSuchElementException();}
        return head.value;
    }
    /** 
     * Method to retrieve tail node value
     * @return E generic value of tail node
     * Throws error if tail is null
     */
    //O(1)
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }
    /** 
     * Method to remove head node
     * @return boolean indicating success of method
     * Throws error if head is null
     * Decrements size
     */
    //O(1)
    public boolean removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        head.prev = null;
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
    //O(n)
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
        current.prev = null;
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
    //O(n)
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
    //O(1)
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /** 
     * Method to check if list is empty
     * @return boolean whether or not size is zero
     * No params
     */
    //O(1)
    public boolean isEmpty() {
        return (size == 0);
    }
    /** 
     * Method to return size of list
     * @return int size of list
     * No params
     */
    //O(1)
    public int size() {
        return size;
    }

    // Class to model LinkedListIterator object
    private class LinkedListIterator implements Iterator<E>{
        //Data member
        private Node current = head;
        /**
         * Method to check whether linked list has a next node
         * @return boolean whether current node is null
         * No params
         */
        //O(1)
        public boolean hasNext() {
            return (current != null);
        }
        /**
         * Method to return next node value
         * @return E generic value of next node
         * Throws exception if current node is null
         * No params
         */
        //O(1)
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
    //O(1)
    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }
    /**
     * Class to model LinkedListListIterator
     */
    private class LinkedListListIterator implements ListIterator<E> {
        //Data members
        private Node current = head;
        /**
         * Default constructor
         * No params
         */
        //O(1)
        public LinkedListListIterator() {}
        /**
         * Constructor w/ single parameter
         * @param index index to begin iterator
         */
        //O(n)
        public LinkedListListIterator(int index) {
            for (int i = 0; i < index; i++) {
                if (current == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                current = current.next;
            }
        }
        /**
         * Method to check whether current node exists
         * @return boolean whether current node is null
         * No param
         */
        //O(1)
        public boolean hasNext() {
            return current != null;
        }  
        /**
         * Method to return current node value
         * @return E generic value of current node
         * Current node is moved forward in list
         * Throws exception if current node is null
         */
        //O(1)
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
        /**
         * Method to check whether previous node exists
         * @return boolean whether previous node is null
         * No param
         */
        //O(1)
        public boolean hasPrevious() {
            return (current.prev != null);
        }
        /**
         * Method to return previous node value
         * @return E generic value of previous node
         * Current node is moved backwards in list
         * Throws exception if previous node is null
         */
        //O(1)
        public E previous() {
            if (current.prev == null) {
                throw new NoSuchElementException();
            }
            E value = current.prev.value;
            current = current.prev;
            return value;

            
        }

        //Un-used methods throw UnsupportOperationException when called (All O(1))
        public int nextIndex() {throw new UnsupportedOperationException();}
        public int previousIndex() {throw new UnsupportedOperationException();}
        public void set(E value) {throw new UnsupportedOperationException();}
        public void add(E value) {throw new UnsupportedOperationException();}
        public void remove() {throw new UnsupportedOperationException();}
    }
    // Node class
    private class Node {
        //data members
        E value;
        Node next, prev;
        /**
         * Constructor with one parameter
         * @param iv initial value for node
         * Sets next and prev nodes to null
         */
        //O(1)
        Node (E iv) {
            value = iv;
            next = null;
            prev = null;
        }
    }

    /** 
     * Method to return ListIterator object starting at beginning of list
     * @return ListIterator<E>
     * No params
     */
    //O(1)
    public ListIterator<E> listIterator() {
        ListIterator<E> firstElement = new LinkedListListIterator();
        return firstElement;
    }
    /** 
     * Method to return list iterator object starting at specific index
     * @param index start index of iterator
     * @return ListIterator<E>
     */
    //O(n)
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
