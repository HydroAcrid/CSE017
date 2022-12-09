/**
 * Test.java
 * Kevin Dotel
 * 4/30/22
 */

import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap<>(new StringComparator<>());
        HashMapSC<String,String> sc = new HashMapSC<>(100000);
        HashMapLP<String,String> lp = new HashMapLP<>(100000);
        readDataUserList(tm, sc, lp, "users.txt");

        System.out.println("Testing get method: ");
        System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\n", "Username:", "TreeMap", "HashMapSC", "HashMapLP");
        try{ 
            File file = new File("user_list.txt");
            Scanner read = new Scanner(file);
            int count, iTree, iHashLP, iHashSC;
            int totalTree, totalHashLp, totalHashSc;
            count = 0;
            totalTree = 0;
            totalHashLp = 0; 
            totalHashSc = 0;
            String[] line;
            while(read.hasNextLine()) {
                if(count % 5 == 0) {
                    line = read.nextLine().split(" ");
                    tm.get(line[0]);
                    sc.get(line[0]);
                    lp.get(line[0]);

                    iTree = TreeMap.iterations;
                    iHashLP = HashMapLP.iterations;
                    iHashSC = HashMapSC.iterations;

                    totalTree += TreeMap.iterations;
                    totalHashLp += HashMapLP.iterations;
                    totalHashSc += HashMapSC.iterations;

                    System.out.printf("%-15s\t%-15d\t%-15d\t%-15d\n", line[0], iTree, iHashSC, iHashLP);
                }
                else {
                    read.nextLine();
                }
                count++;
            }
            System.out.printf("\n%-15s\t%-15d\t%-15d\t%-15d\n\n\n", "Average", (int)Math.round(totalTree / 20.0), totalHashSc / 20, totalHashLp / 20);
        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        try {
            File file = new File("users.txt");
            int collisionsSC, collisionsLP;
            collisionsSC = 0;
            collisionsLP = 0;

            System.out.println("Testing put(): ");
            System.out.printf("%-15s\t%-15s\t%-15s\n", "Size", "HashMapSC", "HashMapLP");

            for(int i = 50000; i <= 500000; i+= 50000) {
                Scanner read = new Scanner(file);
                HashMapSC<String, String> hMapSC1 = new HashMapSC<>(i);
                HashMapLP<String, String> hMapLP1 = new HashMapLP<>(i);

                while(read.hasNextLine()) {
                    String[] items;
                    items = read.nextLine().split(" ");
                    hMapSC1.put(items[0], items[1]);
                    hMapLP1.put(items[0], items[1]);
                }
                System.out.printf("%-15d\t%-15d\t%-15d\n", i, HashMapSC.collisons, HashMapLP.collisions);
                HashMapLP.collisions = 0;
                HashMapSC.collisons = 0;


            }
        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        }


        /**
         * Discussion of Get() method
         * The treemap has higher iterations than both hashmaps because it has to iterate through the treemap while hashmpa starts at the index
         */

         /**
         * Discussion of Put() method
         * HashMapSC has less collisions than HashMapLP because linear probing causes more collisions due to it moving the entry to another index, which mmeans it is less efficient. 
         */
        


       




        

    }

    /**
     * Reads the file
     * @param h - hashmap
     * @param al - arraylist
     * @param filename - file
     */
    public static void readDataUsers(HashMapSC<String,String> sc, HashMapLP<String,String> lp, String filename) {
        File file = new File(filename);

        try {
            Scanner read = new Scanner(file);
            while(read.hasNextLine()) {
                String line = read.nextLine();
                String[] items = line.split(" ");
                sc.put(items[0], items[1]);
                lp.put(items[0], items [1]);
            }
            read.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    /**
     * Reads the file
     * @param h - hashmap
     * @param al - arraylist
     * @param filename - file
     */
    public static void readDataUserList(TreeMap<String,String> t, HashMapSC<String,String> sc, HashMapLP<String,String> lp, String filename) {
        File file = new File(filename);

        try {
            Scanner read = new Scanner(file);
            while(read.hasNextLine()) {
                String line = read.nextLine();
                String[] items = line.split(" ");
                t.add(new MapEntry<String,String>(items[0], items[1]));
                sc.put(items[0], items[1]);
                lp.put(items[0], items[1]);
            }
            read.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    




}
