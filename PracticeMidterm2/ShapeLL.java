import java.util.*;

public class ShapeLL {
    
    private LinkedList<Pair<Integer, Integer>> points;

    public ShapeLL() {
        points = new LinkedList<>();
    }

    public void add(Pair<Integer, Integer> p) {
        points.add(p);
    }

    public boolean isClosed() {
        // if(points.get(0) == points.get(points.size() - 1)){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        if(points.get(0).getFirst() == points.get(points.size() - 1).getFirst() && points.get(0).getSecond() == points.get(points.size() - 1).getSecond()){
            return true;
        }
        else{
            return false;
        }
    }

    // public boolean containsPoint(Pair<Integer, Integer> p) {
    //     // Iterator<Pair<Integer, Integer>> iter = points.iterator();

    //     // while (iter.hasNext()) {
    //     //     if (iter.next().equals(p)){
    //     //         return true;
    //     //     }
    //     // }
    //     // return false;

    //     for(int x = 0;x<points.size();x++){
    //         if(points.get(x).getFirst()==p.getFirst() && points.get(x).getSecond()==p.getSecond()){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean containsPoint(Pair<Integer, Integer> p) {
        return containsPoint(points.iterator(), p);
    }

    private boolean containsPoint(Iterator<Pair<Integer, Integer>> iterator, Pair<Integer, Integer> p) {
            if (!iterator.hasNext()) {
                return false;
            }
            if (iterator.next().equals(p)) {
                return true;
            }
            return containsPoint(iterator, p);
        }

    public String toString() {
        String str = "" + points;
        return str;
    }




}
