import java.util.Comparator;
// public class ComparatorByDistance<c1 extends Comparable<c1>, c2> implements Comparator<Pair<c1, c2>> {
    
//     public int compare(Pair <c1, c2> p1, Pair <c1, c2> p2) {
//         c1 first1 = p1.getFirst();
//         c1 first2 = p2.getFirst();
//         int comp = first1.compareTo(first2);
//         return comp;


//     }
// }

public class ComparatorByDistance implements Comparator<Coordinate> {

    /**
     * Compares both coordinates by distance in order to calculate coordinates 
     */
    public int compare(Coordinate E1, Coordinate E2) {
        double preE1 = (E1.getX() * E1.getX() + E1.getY() * E1.getY());
        double postE1 = Math.sqrt(preE1);

        double preE2 = (E2.getX() * E2.getX() + E2.getY() * E2.getY());
        double postE2 = Math.sqrt(preE2);


        if(postE1 == postE2) {
            return 0;
        }
        else if(postE1 > postE2) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

