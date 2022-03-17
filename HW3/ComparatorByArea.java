import java.util.Comparator;

public class ComparatorByArea<c1, c2 extends Comparable<c2>> implements Comparator<Pair<c1, c2>> {
    
    public int compare(Pair <c1, c2> p1, Pair <c1, c2> p2) {
        c2 second1 = p1.getSecond();
        c2 second2 = p2.getSecond();
        int comp = second1.compareTo(second2);
        return comp;

    }
}
