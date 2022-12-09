/**
 * HashMapLP.java
 * Kevin Dotel
 * 4/30/22
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
/**
 * Class HashMap an implementation of the hash table
 * data structure using separate chaining
 */
public class HashMapLP <K, V> {
	private int size;
	private double loadFactor;
	private MapEntry<K,V>[] hashTable;
	public static int iterations, collisions;

   /**
   * Default constructor
   * Creates an empty hash table with capacity 100
   * and default load factor of 0.9
   */
	public HashMapLP() {
		this(100, 0.9);
	}
   /**
   * Constructor with one parameters
   * Creates an empty hash table with capacity c
   * and default load factor of 0.9
   */
	public HashMapLP(int c) {
		this(c, 0.9);
	}
	/**
  	* Constructor with two parameters
   	* Creates an empty hash table with capacity c
   	* and load factor lf
  	 */
	public HashMapLP(int c, double lf) {
		hashTable = new MapEntry[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
	}
	/**
	 * Private method to find the closest power of 2
	 * to the capacity of the hash table
	 * @param c desired capacity for the hash table
	 * @return  closest power of 2 to c
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity  = capacity << 1;
		return capacity;
	}
	/**
	 * hash method
	 * @param hashCode
	 * @return valid index in the hash table
	 */
	private int hash(int hashCode) {
		return hashCode & (hashTable.length-1);
	}
	/**
	 * Rehash method called when the size of the hashtable
	 * reached lf * capacity
	 */
	private void rehash() {
		ArrayList<MapEntry<K,V>> list = toList();
		hashTable = new MapEntry[hashTable.length << 1];
		size = 0;
		for(MapEntry<K,V> entry: list)
			put(entry.getKey(), entry.getValue());

	}
	/**
	 * Method size
	 * @return the number of elements added to the hash table
	 */
	public int size() {
		return size;
	}
	/**
	 * Method clear
	 * resets all the hash table elements to null
	 * and clears all the linked lists attached to the hash table
	 */
	public void clear() {
		size = 0;
		for(int i=0; i<hashTable.length; i++)
			if(hashTable[i] != null)
				hashTable[i] = null;
	}
	/**
	 * Method isEmpty
	 * @return true if there are no valid data in the hash table
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Search method
	 * @param key being searched for
	 * @return true if key is found, false otherwise
	 */
	public boolean containsKey(K key) {
		if(get(key) != null)
			return true;
		return false;
	}
	/**
	 * Get method
	 * @param key being searched for
	 * @return the value of the hash table entry if the key is found,
	 * null if the key is not found
	 */
	public V get(K key) {
		iterations = 1;
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null) {
			while(hashTable[HTIndex] != null && !hashTable[HTIndex].getKey().equals(key)) {
				iterations++;
				HTIndex = hash(HTIndex+1);
			}
			if(hashTable[HTIndex] == null) {
				return null;
			}
			else {
				return hashTable[HTIndex].getValue();
			}
			
		}
		return null;
	}
	/**
	 * Add a new entry to the hash table
	 * @param key key of the entry to be added
	 * @param value value of the entry to be added
	 * @return the old value of the entry if an entry with the same key is found
	 * the parameter value is returned if a new entry has been added
	 */
	public V put(K key, V value) {
		if(get(key) != null) { // The key is in the hash map
			int index = hash(key.hashCode());
			V old = hashTable[index].getValue();
			hashTable[index].setValue(value);
			return old;

		}
		// check load factor
		if(size >= hashTable.length * loadFactor)
			rehash();
		int HTIndex = hash(key.hashCode());
		//create a new LL if empty
		if(hashTable[HTIndex] == null){
			hashTable[HTIndex] = new MapEntry<K,V>(key,value);
			return value;
		}
		collisions++;
		while(hashTable[HTIndex] != null) {
			HTIndex = hash(HTIndex+1);
		}
		hashTable[HTIndex] = new MapEntry<K,V>(key, value);

		size++;
		return value;
	}


	/**
	 * Method toList used by rehash
	 * @return all the entries in the hash table in an array list
	 */
	public ArrayList<MapEntry<K,V>> toList(){
		ArrayList<MapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			list.add(hashTable[i]);
		} return list;
	}
	/**
	 * toString method
	 * @return the hashtable entries formatted as a string
	 */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				out += hashTable[i].toString() + "\n";
			}
		}
		out += "]";
		return out;
	}

	

}
