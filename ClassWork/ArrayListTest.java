import java.util.*;
public class ArrayListTest {
    public static void main(String[] args) {
    ArrayList<String> cities = new ArrayList<>();
    cities.add("New York");
    cities.add("San Diego");
    cities.add("Atlanta");
    cities.add("Baltimore");
    cities.add("Pittsburg");
    //display the content of the list
    System.out.println(cities.toString());
     // iterator to display the elements of the list
    Iterator<String> cityIterator = cities.iterator();
    while(cityIterator.hasNext()) {
    System.out.print(cityIterator.next() + " ");
        }
    System.out.println();
    
    // get(index) to display the elements of the list
    for(int i=0; i<cities.size(); i++) {
    System.out.print(cities.get(i) + " ");
        }
    }
}
