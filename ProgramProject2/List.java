/***
 * List.java
 * Kevin Dotel
 * 4/18/22
 */
import java.util.ListIterator;

public interface List<E> {

    public abstract boolean add(E value);

    public abstract int size();

    public abstract ListIterator<E> listIterator();

    public abstract ListIterator<E> listIterator(int index);


}