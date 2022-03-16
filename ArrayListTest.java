import java.util.*;
public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("Lion");
        words.add("Cat");
        words.add("Rabbit");
        System.out.println("List: " + words);
        words.add(1, "Squirrel");
        System.out.println("List: " + words);

        StackTest<String> cities = new StackTest<>();
        cities.push("NYC");
        cities.push("Boston");
        cities.push("Philly");
        System.out.println("Top: " + cities.peek());
        System.out.println("Number of cities: " + cities.size());
        System.out.println(cities);

        StackObject items = new StackObject();
        items.push("NYC");
        items.push("Boston");
        items.push("Philly");
        items.push("Allentown");
        System.out.println("Top: " + items.peek());
        System.out.println("Number of cities: " + items.size());
        System.out.println(items);

        Pair<String, String> country1 = new Pair<>("USA", "Washington D.C.");
        Pair<String, String> country2 = new Pair<>("Japan", "Tokyo");
        Pair<String, Integer> student = new Pair<>("Isabelle Clark", 123456);
        System.out.println(country1);
        System.out.println(country2);
        System.out.println(student);
        if(country1.equals(country2)) {
            System.out.println("Equal countries");
        }
        else {
            System.out.println("Not equal countries");
        }






}
    
}
