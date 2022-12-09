import java.util.*;

public class StackTest <E> {
    ArrayList<E> elements;

    public StackTest() {
        elements = new ArrayList<>();
    }

    public void push(E item) {
        elements.add(item);
    }

    public E pop() {
        E value = elements.get(elements.size() -1);
        elements.remove(elements.size() -1);
        return value;
    }

    public E peek() {
        return elements.get(elements.size()-1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public String toString() {
        return "Stack: " + elements.toString();
    }
    
}
