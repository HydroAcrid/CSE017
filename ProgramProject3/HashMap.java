/**
 * HashMap.java
 * Kevin Dotel
 * 4/30/22
 */


import java.util.ArrayList;
import java.util.LinkedList;
public class HashMap <K, V> {
private int size;
private double loadFactor;

private LinkedList<MapEntry<K,V>>[] hashTable;
 // Constructors
public HashMap() {
this(100, 0.9);
}
public HashMap(int c) {
this(c, 0.9);
}
public HashMap(int c, double lf) {
hashTable = new LinkedList[trimToPowerOf2(c)];
loadFactor = lf;
size = 0;
}

// private methods
private int trimToPowerOf2(int c) {
    int capacity = 1;
    while (capacity < c)
    capacity = capacity << 1; // * 2
    return capacity;
    }
     private int hash(int hashCode) {
    return hashCode & (hashTable.length-1);
    }
    private void rehash() {
    ArrayList<MapEntry<K,V>> list = toList();
    hashTable = new LinkedList[hashTable.length << 1];
    size = 0;
    for(MapEntry<K,V> entry: list)
    put(entry.getKey(), entry.getValue());
    }

    // public interface
public int size() {
    return size;
    }
    public void clear() {
    size = 0;
    for(int i=0; i<hashTable.length; i++)
    if(hashTable[i] != null)
    hashTable[i].clear();
    }
    public boolean isEmpty() {
    return (size == 0);
    }
    // search for key - returns true if found
    public boolean containsKey(K key) {
    if(get(key) != null)
    return true;
    return false;
    }

    // returns the value of key if found, null otherwise
public V get(K key) {
    int HTIndex = hash(key.hashCode());
    if(hashTable[HTIndex] != null) {
    LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
    for(MapEntry<K,V> entry: ll) {
    if(entry.getKey().equals(key))
    return entry.getValue();
    }
    }
    return null;
    }

    // remove a key if found
public void remove(K key) {
    int HTIndex = hash(key.hashCode());
    if (hashTable[HTIndex]!=null) { //key is in the hash map
    LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
    for(MapEntry<K,V> entry: ll) {
    if(entry.getKey().equals(key)) {
    ll.remove(entry);
    size--;
    break;
    }
    }
    }
    }

    // adds a new key or modifies an existing key
public V put(K key, V value) {
    if(get(key) != null) { // The key is in the hash map
    int HTIndex = hash(key.hashCode());
    LinkedList<MapEntry<K,V>> ll;
     ll = hashTable[HTIndex];
    for(MapEntry<K,V> entry: ll) {
    if(entry.getKey().equals(key)) {
     V old = entry.getValue();
     entry.setValue(value);
     return old;
    }
    }
    }

    // key not in the hash map - check load factor
 if(size >= hashTable.length * loadFactor)
 rehash();
  int HTIndex = hash(key.hashCode());
  //create a new LL if empty
  if(hashTable[HTIndex] == null){
 hashTable[HTIndex] = new LinkedList<>();
  }
  hashTable[HTIndex].add(new MapEntry<>(key, value));
  size++;
  return value;
 }

 // returns the elements of the hash map as a list
public ArrayList<MapEntry<K,V>> toList(){
    ArrayList<MapEntry<K,V>> list = new ArrayList<>();
    for(int i=0; i< hashTable.length; i++) {
    if(hashTable[i]!= null) {
    LinkedList<MapEntry<K,V>> ll = hashTable[i];
    for(MapEntry<K,V> entry: ll)
    list.add(entry);
    }
    } return list;
    }
    // returns the elements of the hash map as a string
    public String toString() {
    String out = "[";
    for(int i=0; i<hashTable.length; i++) {
    if(hashTable[i]!=null) {
    for(MapEntry<K,V> entry: hashTable[i])
    out += entry.toString();
    out += "\n";
    }
    }
    out += "]"; return out;
    }

    public int collisions() {
        int maxSize = 0;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                if (hashTable[i].size() > maxSize) {
                    maxSize = hashTable[i].size();
                }
            }
        }
        return maxSize;
    }




    }

    
