import java.util.Comparator;

public class ComparatorByDistance<c1 extends Comparable<c1>, c2> implements Comparator<Pair<c1, c2>> {
    
    public int compare(Pair <c1, c2> p1, Pair <c1, c2> p2) {
        c1 first1 = p1.getFirst();
        c1 first2 = p2.getFirst();
        int comp = first1.compareTo(first2);
        return comp;


    }
}
