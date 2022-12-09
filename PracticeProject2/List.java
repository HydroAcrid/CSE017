/***
 * Class to model the entity List
 * @author Jiajun Ye
 * @version 0.1
 * Date of creation: April 17, 2022
 * Last Date Modified: April 17, 2022
 */
import java.util.ListIterator;
public interface List<E> {
    /**
     * abstract method add
     * returns a boolean value
     */
    public abstract boolean add(E value);
     /**
     * abstract method size
     * returns an int value
     */
    public abstract int size();
     /**
     * abstract method ListIterator
     * no return
     */
    public abstract ListIterator<E> ListIterator();
     /**
     * abstract method ListIterator(int index)
     * no return
     */
    public abstract ListIterator<E> ListIterator(int index);
}