import java.util.*;



public class Test {
    public static void main(String[] args) {

        ShapeAl crescent = new ShapeAl();
        ShapeLL hexagon = new ShapeLL();
        Pair<Integer, Integer> p = new Pair<>();

        //Arraylist Adding
        crescent.add(new Pair<>(30, 50));
        crescent.add(new Pair<>(25, 40));
        crescent.add(new Pair<>(25, 30));
        crescent.add(new Pair<>(30, 20));
        crescent.add(new Pair<>(40, 10));


        //LinkedList Adding
        hexagon.add(new Pair<>(50, 60));
        hexagon.add(new Pair<>(40, 40));
        hexagon.add(new Pair<>(50, 20));
        hexagon.add(new Pair<>(70, 20));
        hexagon.add(new Pair<>(90, 40));
        hexagon.add(new Pair<>(70, 60));
        hexagon.add(new Pair<>(50, 60));


        System.out.println("Crescent List: " + crescent.toString());
        System.out.println("Hexagon List: " + hexagon.toString());

        Pair<Integer, Integer> check = new Pair<>(50, 60);
        boolean swag = crescent.containsPoint(check);
        boolean superSwag = hexagon.containsPoint(check);

        if(swag == true) {
            System.out.println("(50, 60) exists in the crescent!");
        }
        else if(swag == false) {
            System.out.println("\n(50, 60) Does not exist!");
        }

        if(crescent.isClosed()) {
            System.out.println("Yeah its closed");
        }
        else {
            System.out.println("Yeah its open");
        }
        

        if(superSwag == true) {
            System.out.println("\n(50, 60) is in the hexagon list!");
        }
        else if(superSwag == false) {
            System.out.println("(50, 60) Does not exist!");
        }

        if(hexagon.isClosed()) {
            System.out.println("Yeah its closed");
        }
        else {
            System.out.println("Yeah its not closed");
        }
        



    }
}
