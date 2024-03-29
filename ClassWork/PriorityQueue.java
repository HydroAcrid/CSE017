import java.util.*;

public class PriorityQueue<E> {
    private ArrayList<E> list;
    private Comparator<E> comparator;

    public PriorityQueue() {
        list = new ArrayList<>();
        comparator = null; 
    }

    public PriorityQueue(Comparator<E> c) {
        list = new ArrayList<>();
        comparator = c;
    }

    public E poll() {
        E value = list.get(0);
        list.remove(0); return value;
    }

    public void offer(E item) {
        int i, c;
        for(i=0; i<list.size(); i++){
        if(comparator == null)
        c = ((Comparable<E>)item).compareTo(list.get(i));
        else
        c = comparator.compare(item, list.get(i));
       if(c < 0)
        break;
       }
       list.add(i, item);
       }

    public E peek() {
        return list.get(0);
    }

    public String toString() {
        return "Priority Queue: " + list.toString();
         }
        public int size() { 
            return list.size(); 
        }
        public void clear() { 
            list.clear();
         }
        public boolean isEmpty() { 
            return list.size() == 0;
        }


}
