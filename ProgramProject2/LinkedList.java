/***
 * LinkedList.java
 * Kevin Dotel
 * 4/18/22
 */

import java.util.*;

public class LinkedList<E> implements List<E> {
    // Data members
   private Node head, tail;
   int size;
    // Inner class Node
   private class Node   {
   E value;
   Node next;
   Node(E initialValue){
   value = initialValue; 
   next = null;
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
        size++; 
        return true;
        }

    //Adding item to last node in the list
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if(head == null) { 
            head = tail = newNode; 
        }
        else { 
            tail.next = newNode; 
            tail = newNode; 
        }
        size++; 
        return true;
        }

    //Adding an item
    public boolean add(E item) {
        return addLast(item);
        }

        // Retrieving an item from the list
    public E getFirst() {
        if (head == null)
        throw new NoSuchElementException();
        return head.value;
        }

        //Getting item from the end of the list
        public E getLast() {
            if (head == null)
            throw new NoSuchElementException();
            return tail.value;
            }

        // Removing an item from the list
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

        //Removing the last item from the list
    public boolean removeLast() {
        if (head == null) throw new NoSuchElementException();
        if(size == 1) return removeFirst();
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
        head = tail = null; size = 0;
    }

    //Checks to see if list is empty and empties it
    public boolean isEmpty() { 
        return (size == 0); 
    }
    //Checks the size of the list 
    public int size() { 
        return size;
     }

        //Implementing an iterator for the list
    public Iterator<E> iterator(){
        return new LinkedListListIterator();
    }

    //Private inner class to create an iterator
    private class LinkedListListIterator implements Iterator<E> {
        private Node current = head;
        public boolean hasNext() {
        return (current != null);
        }

        public E next() {
        if(current == null)
        throw new NoSuchElementException();
        E value = current.value;
        current = current.next; 
        return value;
            }
        }

        public ListIterator<E> listIterator() {
            ListIterator<E> firstElement = new LinkedListIterator();
            return firstElement;
        }

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


        //Private inner class to create a listIterator
        private class LinkedListIterator implements ListIterator<E> {
            private Node current = head;
            private Node previous = null;
    

            public LinkedListIterator(){}

            public LinkedListIterator(int index) {
                for (int i = 0; i < index; i++) {
                    if (current == null) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    previous = current;
                    current = current.next;
                }
            }

            public boolean hasNext() {
                return current != null;
                    
            }

    
            public E next() {
                // if(current == null)
                // throw new NoSuchElementException();
                // E value = current.value;
                // current = current.next;
                // return value; 

                if (current == null) {
                    throw new NoSuchElementException();
                }
                E value = (E)current.value;
                previous = current;
                current = current.next;
                return value;
            }
    
            //Try these later honestly 
            public boolean hasPrevious() {
                return (previous != null);
            }
    
            //Try this one later as well
            public E previous() {
                // if(current == null)
                // throw new NoSuchElementException();
                // E value = current.value;
                // current = current.next;
                // return value; 

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

        // Inner class Node
//    private class Node   {
//     E value;
//     Node next;
//     Node(E initialValue){
//     value = initialValue; 
//     next = null;
//          }
//      }

        

        









    }
