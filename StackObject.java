public class StackObject {
    private Object[] elements;
    private int size;

    public StackObject() {
        elements = new Object[10];
        size = 0;
    }

    public void push(Object obj) {
        elements[size++] = obj;
    }

    public Object pop() {
        return elements[size--];
    }

    public Object peek() {
        return elements[size-1];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String out = "Stack: [";
        for(int i=0; i<size; i++) {
            out += elements[i] + ", ";
        } 
        out += "]";
        return out;
    }
    
}
