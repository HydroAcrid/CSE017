/***
 * DoublyLinkedList.java
 * Kevin Dotel
 * 4/18/22
 */

import java.util.*;


public class DoublyLinkedList<E> implements List<E> {
    
    private Node head;
    private Node tail;
    private int size;

    /**
     * Node constructor
     */
    private class Node {
        E value;
        Node next;
        Node previous;
        Node(E initialValue) {
            value = initialValue;
            next = null;
            previous = null;
        }
    }

    /**
     * Doublylinkedlist constructor
     * O(1)
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element into the first slot in linkedlist
     * @param item - element being placed
     * @return - returns true if successful 
     * O(1)
     */
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        if (tail == null) {tail = newNode;}
        size++;
        return true;
        }

        /**
         * Adds an element into the last slot in linkedlist
         * @param item - element being placed
         * @return - returns true if successful 
         * O(1)
         */
        public boolean addLast(E item) {
            Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;

        }

        /**
         * Adds item into linkedlist
         * O(1)
         */
        public boolean add(E item) {
            return addLast(item);
            }

        /**
         * Gets the first item in the doublylinkedlist
         * @return - returns the value of the first item
         * O(1)
         */
        public E getFirst() {
            if (head == null)
            throw new NoSuchElementException();
            return head.value;
            }

        /**
         * Gets the last item in the doublylinkedlist
         * @return - returns the value of the last item
         * O(1)
         */
        public E getLast() {
            if (tail == null)
            throw new NoSuchElementException();
            return tail.value;
            }

        /**
         * Removes the first item in the doublylinkedlist
         * @return - returns the value of the first item
         * O(1)
         */
        public boolean removeFirst() {
            // if (head == null) throw new NoSuchElementException();
            // head = head.next;
            // if(head == null) tail=null;
            // size--; 
            // return head.value;

            // if(head != null) {
            //     Node temp = head;
            //     head = head.next;
            //     temp = null;
            //     if(head != null) 
            //       head.previous = null;
            //   }
            // return head.value;

            if (head == null) {
                throw new NoSuchElementException();
            }
            head = head.next;
            head.previous = null;
            if(head == null) {
                tail=null;
            }
            size--;
            return true;

            
                
        }

         /**
         * Removes the last item in the doublylinkedlist
         * @return - returns the value of the last item
         * O(n)
         */
        public boolean removeLast() {
            // if(tail != null) {
            //     Node temp = tail;
            //     tail = tail.next;
            //     temp = null;
            //     if(tail != null) 
            //       tail.previous = null;
            //   }
            // return tail.value;

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
            current.previous = null;
            previous.next = null;
            tail = previous;
            size--;
            return true;
            }

        /**
         * Gets size of the list
         * O(1)
         */
        public int size() {
            return size;
        }

        /**
         * Clears the list
         */
        public void clear() { 
            head = tail = null; 
            size = 0;
        }

        /**
         * Checks to see if the list is empty 
         * @return - makes the size 0 again
         * O(1)
         */
        public boolean isEmpty() { 
            return (size == 0); 
        }

        /**
         * String output for doublylinkedlist
         * O(n)
         */
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
         * Constructor for Iterator 
         * @return a new iterator 
         * O(1)
         */
        public Iterator<E> iterator() {
            return new DoublyLinkedListIterator();
        }

        /**
         * Inner class for linkedlist iterator 
         */
        private class DoublyLinkedListIterator implements Iterator<E> {
        private Node current = head;

        /**
         * Checks to see if the current node is filled
         * O(1)
         */
        public boolean hasNext() {
        return (current != null);
        }

        /**
         * Goes to the next element in the list
         * O(1)
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
         * Initializes the listIterator
         * O(1)
         */
        public ListIterator<E> listIterator() {
            ListIterator<E> firstElement = new LinkedListIterator();
            return firstElement;
                
        }

        /**
         * Places listiterator at the index
         * O(n)
         */
        public ListIterator<E> listIterator(int index) {

            //FIX THIS LATER
            // if (index < 0 || index > size)
            //       throw new IndexOutOfBoundsException();
            //     for (int i = 0; i < index; i++)
            //       head = head.next;

            //     return new LinkedListIterator();

            ListIterator<E> firstElement = new LinkedListIterator();
            try{
                firstElement = new LinkedListIterator(index);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Array out of bounds");
            }
            return firstElement;
        }


        /**
         * ListIterator inner class 
         */
        private class LinkedListIterator implements ListIterator<E> {
            private Node current = head;
            private Node previous = null;


            /**
             * Constructor
             * O(1)
             */
            public LinkedListIterator() {}

            /**
             * constructor with one parameter 
             * @param index - input to begin iterator 
             * O(n)
             */
            public LinkedListIterator(int index) {
                for (int i = 0; i < index; i++) {
                    if (current == null) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    current = current.next;
                }
            }
    
            /**
             * Checks to see if list has a filled node
             * O(1) 
             */
            public boolean hasNext() {
                return (current != null);
                    
            }
    
            /**
             * Continues to the next node in the list
             * O(1)
             */
            public E next() {
                if(current == null) {
                throw new NoSuchElementException();
                }
                E value = (E)current.value;
                current = current.next;
                return value; 
            }
    
            /**
             * Checks to see if the last node was filled 
             * O(1)
             */
            public boolean hasPrevious() {
                //return (current.previous != null);

                if(head == null){
                    return false;
                }
                else if(current == null && tail != null){
                    return true;
                }
                else {
                    return current.previous != null;
                }
            }
    
            /**
             * Goes to the previous node 
             * O(1)
             */
            public E previous() {
                
                E value = null;
                if(current == null){
                    value  = tail.value;
                    current = tail;
                }
                else {
                    if(current.previous == null) {
                        throw new NoSuchElementException();
                    }
                    value = current.previous.value;
                    current = current.previous;
                }
                return value;
                    
                }
    
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }
    
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }
    
            public void set(E value) {
                throw new UnsupportedOperationException();
            }
    
            public void add(E value) {
                throw new UnsupportedOperationException();
            }
    
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

         

    



        
    





}
