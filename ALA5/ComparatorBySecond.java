import java.util.Comparator;

public class ComparatorBySecond<E1, E2 extends Comparable<E2>> implements Comparator<Pair<E1, E2>> {

    public int compare(Pair <E1, E2> p1, Pair <E1, E2> p2) {
        E2 second1 = p1.getSecond();
        E2 second2 = p2.getSecond();
        int comp = second1.compareTo(second2);
        return comp;


    }

    
    
}

