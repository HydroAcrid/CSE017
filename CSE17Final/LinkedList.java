import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class LinkedList
 * @author Houria Oudghiri
 * Date of creation: May 10, 2022
 * @param <E> Type of the linked list nodes
 */
public class LinkedList<E>{
	// Data members
	private Node head, tail;
	int size;

	/**
	 * Inner class for the linked list nodes
	 *
	 */
	private class Node {
		E value;
		Node next;
		/**
		 * Constructor to initialize the value of a node
		 * @param initialValue
		 */
		Node(E initialValue) {
			value = initialValue;
			next = null;
		}
	}

	/**
	 * LinkedList constructor
	 * creates and empty linked list
	 */
	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Method addFirst to add a new node at the head of the linked list
	 * @param item value of the new node
	 * @return always true
	 */
	public boolean addFirst(E item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return true;
	}
	/**
	 * Method addLast to add a new node at the tail of the linked list
	 * @param item value of the new node
	 * @return always true
	 */
	public boolean addLast(E item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}
	/**
	 * Method add to add a new node at the head or tail of the linked list
	 * inherited from the interface Collection (implemented to add at the tail)
	 * @param item value of the new node
	 * @return always true
	 */
	public boolean add(E item) {
		return addLast(item);
	}
	/**
	 * Method getFirst
	 * @return the value of the node at the head of the linked list
	 * @throws an exception if the linked list is empty
	 */
	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
	}
	/**
	 * Method getLast
	 * @return the value of the node at the tail of the linked list
	 * @throws an exception if the linked list is empty
	 */
	public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
	}
	/**
	 * Method removeFirst to remove the node at the head of the linked list
	 * @return true if the node was removed successfully
	 * @throws an exception if the linked list is empty
	 */
	public boolean removeFirst() {
		if (head == null)
			throw new NoSuchElementException();
		head = head.next;
		if (head == null)
			tail = null;
		size--;
		return true;
	}
	/**
	 * Method removeLast to remove the node at the tail of the linked list
	 * @return true if the node was removed successfully
	 * @throws an exception if the linked list is empty
	 */
	public boolean removeLast() {
		if (head == null)
			throw new NoSuchElementException();
		if (size == 1)
			return removeFirst();
		Node current = head;
		Node previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		tail = previous;
		size--;
		return true;
	}
	
	/**
	 * Method toString
	 * return the values of the linked list nodes as a string
	 */
	public String toString() {
		String output = "[";
		Node node = head;
		while (node != null) {
			output += node.value + " ";
			node = node.next;
		}
		output += "]";
		return output;
	}

	/**
	 * Method clear to remove all the linked list nodes
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Method isEmpty
	 * @return true if there are no nodes in the linked list,
	 *         false otherwise
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Method size
	 * @return the number of nodes in the linked list
	 */
	public int size() {
		return size;
	}
	/**
	 * Method iterator
	 * @return an iterator object positioned at the head of the linked list
	 */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	/**
	 * Inner class LinkedListIterator to implement the interface Iterator for a linked list
	 */
	private class LinkedListIterator implements Iterator<E> {
		private Node current = head;
		/**
		 * Method hasNext 
		 * @return true if there is a node to move forward to, false otherwise
		 */
		public boolean hasNext() {
			return (current != null);
		}
		/**
		 * Method next
		 * @return the value of the current node and moves the iterator to the next node
		 * @throws an exception if the current node is null
		 */
		public E next() { // O(1)
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next;
			return value;
		}
	}
	/**
	 * Method bubbleSort to sort the nodes of the linked list
	 * @param comp Comparator object used by the method to order the nodes
	 * Time complexity of O(n^2)
	 */
	public void bubbleSort(Comparator<E> comp) {
		boolean sorted = false; 
		for (int k=1; 
				k < size() && !sorted; k++) {
			sorted = true; 
			for (int i=0; i<size()-k; i++) { 
				if (comp.compare(get(i), get(i+1)) > 0) {
					// swap 
					E temp = get(i);
					set(i, get(i+1));
					set(i+1, temp);
					sorted = false; 
				} 
			} 
		}

		
	}

	/**
	 * Get method for the linkedlist. I used this for the bubble sort method 
	 * @param index
	 * @return
	 */
	public E get(int index) { // O(n)
		Node current = head;
		if (index < 0 || index >= size)
		throw new NoSuchElementException();
		for(int i=0; i<index; i++)
		current = current.next;
		return current.value;
	   }


	/**
	 * Set method for the linkedList. I used this for the bubble sort method
	 * @param index
	 * @param newValue
	 * @return
	 */
	public E set(int index, E newValue) { // O(n)
		Node current = head;
		if (index < 0 || index >= size)
		throw new NoSuchElementException();
		for(int i=0; i<index; i++)
		current = current.next;
		E old = current.value;
		current.value = newValue;
		return old;
	   }
}


