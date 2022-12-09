import java.util.Comparator;

public class StringComparator<K> implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.substring(0,3).compareTo(o2.substring(0,3));
    }
}
