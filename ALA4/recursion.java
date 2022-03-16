package ALA4;

import java.io.*;
import java.util.*;

public class recursion {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a path");
        String path = scnr.nextLine();
        System.out.println("Enter a word");
        String word = scnr.nextLine();
        findWord(path, word);

        System.out.println("Enter a path");
        path = scnr.nextLine();
        long size = getSize(path);
        String unit = "bytes";
        if(size > 1000000000) {
            size /= 1000000000;
            unit = "GBytes";
        }
        else if(size > 1000000) {
            size /= 1000000;
            unit = "MBytes";
        }
        else if(size > 1000) {
            size /= 1000;
            unit = "KBytes";
        }
        if(size != 0) {
        System.out.println("Size of " + path + " is " + size + unit);
        } 


    }

    public static void findWord(String path, String word) {
        File file = new File(path);
        if(file.isDirectory()) { //is a folder
            File[] files = file.listFiles(); //get the content of the folder 
            for(int i=0; i<files.length; i++) {
                if(files[i].isFile()) {
                    int count = countWord(files[i], word);
                    if(count != 0) {
                        System.out.println("The word " + word + " appears " + count + " times in " + files[i].getAbsoluteFile());
                    }
                }
                else {
                    //find word in the sub folder
                    findWord(files[i].getAbsolutePath(), word);
                }
            }
        }
        else if(file.isFile()) {
            int count = countWord(file, word);
            if(count != 0) {
                System.out.println("The word " + word + " appears " + count + " times in " + file.getAbsoluteFile());
            }
        }
        else {
            System.out.println("Directory not found");
        }
    }

    public static int countWord(File file, String word) {
        int count =0;
        try {
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()) {
                String line = readFile.nextLine();
                int index = line.indexOf(word, 0);
                while(index != -1) {
                    count++;
                    index = line.indexOf(word, index+1);
                }
            }
            readFile.close();
        } 
        catch(FileNotFoundException e) {
        }
        return count;
    }

    public static long getSize(String path) {
        long size =0;
        File file = new File(path);
        if(file.isFile()) {
            return file.length(); //size of the file in bytes
        }
        else if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++) {
                size += getSize(files[i].getAbsolutePath());
            }
        }
        else {
            System.out.println("Directory not found");
        }
        return size;
    }


    
    
}
