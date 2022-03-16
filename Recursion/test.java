package Recursion;

import java.io.*;
import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter folder path: ");
        String folder = scnr.nextLine();
        System.out.println("Enter filename: ");
        String filename = scnr.nextLine();
        String out = searchFile(folder, filename);
        if(out.equals("")) {
            System.out.println("File " + filename + " not found");
        }
        else {
            System.out.println("File " + filename + " found at: " + out);
        }
    }

    public static String searchFile(String folder, String filename) {
        File file = new File(folder);
        if(!file.isDirectory()) {
            return "";
        }
        else {
            File[] files = file.listFiles(); //return the content of the files
            for(int i=0; i<files.length; i++) {
                if(files[i].isFile()) {
                    if(files[i].getName().equals(filename)) {
                        return files[i].getAbsolutePath();
                    }
                }
                else {
                    String out = searchFile(files[i].getAbsolutePath(), filename); //recursion
                    if(!out.equals("")) {
                        return out;
                    }
                }
            }
        }
        return "";
    }
    
}
