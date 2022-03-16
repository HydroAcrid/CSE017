import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Pair<String, String>> states;
        states = new ArrayList<>();
        readStates(states, "states.txt");

        ArrayList<Pair<String, Integer>> trees;
        trees = new ArrayList<>();
        readTrees(trees, "trees.txt");

        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do {
            printMenu();
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation) {
                case 1:
                    printArrayList(states);
                break;
                case 2:
                    System.out.println("Enter a state:");
                    String name = keyboard.nextLine();
                    int index = search(states, name);
                    if(index == -1) {
                        System.out.println("State not found");
                    }
                    else {
                        System.out.println("Select an operation:");
                        states.get(index);
                    }
                break;
                case 3:
                    states.sort(new ComparatorByFirst<>());
                    printArrayList(states);
                break;
                case 4:
                    states.sort(new ComparatorBySecond<>());
                    printArrayList(states);

                break;
                case 5:
                    printArrayList(trees);

                break;
                case 6:
                System.out.println("Enter a tree name:");
                name = keyboard.nextLine();
                index = search(trees, name);
                if(index == -1) {
                    System.out.println("Tree not found");
                }
                else {
                    System.out.println("Select an operation:");
                    trees.get(index);
                }

                break;
                case 7:
                    trees.sort(new ComparatorByFirst<>());
                    printArrayList(trees);

                break;
                case 8:
                    trees.sort(new ComparatorBySecond<>());
                    printArrayList(trees);
                break;
                case 9:
                    System.out.println("Bye bye bozo");
                    System.exit(0);
                break;
    

            
            }
        }while(operation!=9);

        

    }

    public static <E> void printArrayList(ArrayList<E> list) {
        for(E element: list) {
            System.out.println(element);
        }
    }



    public static void printMenu() {
        System.out.println("Select an operation");
        System.out.println("1: View the list of states");
        System.out.println("2: Search for a state");
        System.out.println("3: Sort states by name");
        System.out.println("4: Sort states by capital");
        System.out.println("5: View the list of trees");
        System.out.println("6: Search for a tree");
        System.out.println("7: Sort trees by name");
        System.out.println("8: Sort trees by height");
        System.out.println("9: Exit");


    }

    public static void readStates(ArrayList<Pair<String, String>> list, String filname) {
        File file = new File("states.txt");
        try {
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                String capital = items[1];
                Pair<String, String> p;
                p = new Pair<>(name, capital);
                list.add(p);
            }
            scanFile.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public static void readTrees(ArrayList<Pair<String, Integer>> list, String filname) {
        File file = new File("trees.txt");
        try {
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                Integer height = Integer.parseInt(items[1]);
                Pair<String, Integer> p;
                p = new Pair<>(name, height);
                list.add(p);
            }
            scanFile.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public static <E1,E2> int search (ArrayList<Pair<E1,E2>> list, E1 key) {
        for(int i=0; i<list.size(); i++) {
            Pair<E1,E2> p = list.get(i);
            if(p.getFirst().equals(key)) {
                return i;
            }
        }
        return -1;
    }



    

    

    
}
