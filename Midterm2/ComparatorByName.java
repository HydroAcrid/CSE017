import java.util.*;


public class ComparatorByName implements Comparator<Country> {

    public int compare(Country c1, Country c2) {
        String name1 = c1.getName();
        String name2 = c2.getName();
        if(name1.equals(name2)) {
            return 0;
        }
        else if(name1.length() > name2.length()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    
}
