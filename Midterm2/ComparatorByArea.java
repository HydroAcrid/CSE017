import java.util.Comparator;

public class ComparatorByArea implements Comparator<Country> {
    
    public int compare(Country c1, Country c2){
        double area1 = c1.getArea();
        double area2 = c2.getArea();

        if(area1 == area2) {
            return 0;
        }
        else if(area1 > area2){
            return 1;
        }
        else{
            return -1;
        }
    }
}
