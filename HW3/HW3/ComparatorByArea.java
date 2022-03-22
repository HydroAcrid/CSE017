/**
 * Kevin Dotel
 * ComparatorByArea.java
 * 3/21/22
 */
import java.util.Comparator;

// public class ComparatorByArea<c1, c2 extends Comparable<c2>> implements Comparator<Pair<c1, c2>> {
    
//     public int compare(Pair <c1, c2> p1, Pair <c1, c2> p2) {
//         c2 second1 = p1.getSecond();
//         c2 second2 = p2.getSecond();
//         int comp = second1.compareTo(second2);
//         return comp;

//     }
// }


public class ComparatorByArea implements Comparator<Coordinate>{
    
    /**
     * Compares distance of both coordinates in order to do sort 
     */
    public int compare(Coordinate E1, Coordinate E2){
        double topDistanceE1 = E1.getX() * E1.getY();
        double distanceE1 = topDistanceE1 / 2;

        double topDistanceE2 = E2.getX() * E2.getY();
        double distanceE2 = topDistanceE2 / 2;

        if(distanceE1 == distanceE2){
            return 0;
        }
        else if(distanceE1 > distanceE2){
            return 1;
        }
        else{
            return -1;
        }
    }
}