/**
 * Kevin Dotel
 * 2/19/22
 */

//package ProgramProject1;

import java.io.*;
import java.time.Period;
import java.util.*;
import java.util.regex.*;

public class Catalog {
    public static void main(String[] args) {

        //Variables
        Scanner scnr = new Scanner(System.in);
        int option;
        int count = 0;
        //File myFile = new File("epic.txt");
        String reader;
        String[] list = new String[7];
        Titles[] literature = new Titles[50];
        

        //Reads titles.txt file 
        try {
            File myFile = new File("epic.txt");
            Scanner fileReader = new Scanner(myFile);
            //System.out.println("List[i] has this now: ");
            while(fileReader.hasNextLine()) {

                for(int i=0; i<list.length; i++) {
                    list[i] = fileReader.nextLine();
                }
                
                //System.out.println("List[i] has this now: ");
                //System.out.println(Arrays.toString(list));

                if(list[0].charAt(0) == 'B') {
                    literature[count] = new Book(list[0], list[1], list[2], Integer.parseInt(list[3]), Integer.parseInt(list[4]),list[5], Long.parseLong(list[6]));
                }
                else if(list[0].charAt(0) == 'P') {
                    literature[count] = new Periodical(list[0], list[1], list[2], Integer.parseInt(list[3]), Integer.parseInt(list[4]), Integer.parseInt(list[5]), Integer.parseInt(list[6]));
                }
                count++;
            }
            fileReader.close();

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // System.out.println("This is what the file should read: ");
        // System.out.println(Arrays.toString(literature));
        
        //Intro
        do {
        System.out.println("Welcome to Kevin's Library Program yay!!!!");
        display();

        //Options
        option = getInt(scnr);

        //Switch case that uses the option variable
        switch(option) {
            //first option
            case 1:
                System.out.println("You have selected: View all titles");
                printLit(literature, count);
            break;

            //2nd option
            case 2:
                System.out.println("You have selected: Search by call number");
                System.out.println("Enter a call number:");
                scnr.nextLine();
                String input = scnr.nextLine();
                int temp = findCallNum(literature, count, input);
                if(temp < 0) {
                    System.out.println("Call number not found");
                }
                else {
                    System.out.println("Title found at row: " + temp);
                    //This is going to display everything about the title
                }

            break;

            //3rd option
            case 3:
                System.out.println("You have selected: Search by title");
                System.out.println("Enter a title:");
                scnr.nextLine();
                input = scnr.nextLine();
                temp = findTitle(literature, count, input);
                if(temp < 0) {
                    System.out.println("Title not found");
                }
                else {
                    System.out.println("Title found at row: " + temp);
                }
            break;

            //4th option
            case 4:
                System.out.println("You have selected: Search by year");
                System.out.println("Enter a year:");
                int year = getYear(scnr); //This needs to change year has to be in range 
                temp = findPubDate(literature, count, year);
            break;

            //5th option
            case 5:
                System.out.println("You have selected: Add a new title");

                //Checks if the title already exists 
                System.out.println("Enter the title: ");
                scnr.nextLine();
                String inputTitle = scnr.nextLine();
                if(findTitle(literature, count, inputTitle) != -1)  {
                    System.out.println("This title already exists bozo");
                    break;
                }

                System.out.println("Enter the publisher: ");
                String inputPub = scnr.nextLine();
                //Checks to see if year is valid. If not, program restarts 
                System.out.println("Enter the year of publication: ");
                int inputYear = 0;
                    try {
                        inputYear = scnr.nextInt();
                        if(inputYear<1900 || inputYear>2020) throw new Exception();
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. Year must be between 1900 and 2020");
                        break;
                    }

                //Checks to see if the number of copies is valid
                System.out.println("Enter the number of copies");
                int inputCopies = 0;
                    try {
                        inputCopies = scnr.nextInt();
                        if(inputCopies < 0) throw new Exception();
                    }
                    catch(Exception e) {
                        System.out.println("Invalid number of copies");
                        break;
                    }

                //Checks to see if input is a book or periodical
                System.out.println("Enter the type: (Book/Periodical)");
                String inputType = scnr.next();
                if(inputType.equalsIgnoreCase("Book")) {
                    System.out.println("Book was chosen");
                    System.out.println("Enter the call number: (B-ddd-ddd-ddd)");

                    //Regex pattern identifier. If not the correct format, the program restarts.
                    boolean matches = false;
                    String regexPattern = "B-[0-9]{3}+-[0-9]{3}+-[0-9]+{3}";
                    String selfCallNum = scnr.next();
                    matches = Pattern.matches(regexPattern, selfCallNum);
                    printMatchedResult(matches);
                    if(matches == false) {
                        System.out.println("Incorrect call number format.");
                        break;
                    }

                    //Adds the author to the array
                    System.out.println("Enter the author: ");
                    scnr.nextLine();
                    String selfAuthor = scnr.nextLine();
                    int selfISBN =0;

                    //Validates that the ISBN is an int and is 10 digits long
                    System.out.println("Enter ISBN: (10 digits)");
                    try {
                        selfISBN = scnr.nextInt();
                        if(selfISBN < 0) throw new Exception();
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. Must be 10 digits long");
                        break;
                    }
                    String convert = Integer.toString(selfISBN);
                    regexPattern = "[0-9]{10}";
                    matches = Pattern.matches(regexPattern, convert);
                    printMatchedResult(matches);
                    if(matches == false) {
                        System.out.println("Invalid input. Must be 10 digits long");
                        break;
                    }

                    literature[count] = new Book(selfCallNum, inputTitle, inputPub, inputYear, inputCopies, selfAuthor, selfISBN);
                    count++;

                    System.out.println("Book Added Successfully!");

                }
                else if(inputType.equalsIgnoreCase("Periodical")) {
                    System.out.println("Periodical was chosen");
                    System.out.println("Enter the call number: (P-ddd-ddd-ddd)");

                    //Regex pattern identifier. If not the correct format, the program restarts.
                    boolean matches = false;
                    String regexPattern = "P-[0-9]{3}+-[0-9]{3}+-[0-9]+{3}";
                    String selfCallNum = scnr.next();
                    matches = Pattern.matches(regexPattern, selfCallNum);
                    printMatchedResult(matches);
                    if(matches == false) {
                        System.out.println("Incorrect call number format.");
                        break;
                    }

                    //Validates the month is between 1-12
                    int selfMonth = 0;
                    System.out.println("Enter the month: ");
                    try {
                        selfMonth = scnr.nextInt();
                        if(selfMonth > 12 || selfMonth < 0) throw new Exception();
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. Must be between 1-12");
                        break;
                    }


                    //Checks to make sure the issue number is above 0
                    System.out.println("Enter the issue Number: ");
                    int selfIssueNum = 0;
                    try {
                        selfIssueNum = scnr.nextInt();
                        if(selfIssueNum < 0) throw new Exception();
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input.");
                        break;
                    }


                    literature[count] = new Periodical(selfCallNum, inputTitle, inputPub, inputYear, inputCopies, selfMonth, selfIssueNum);
                    count++;

                    System.out.println("Periodical Added Successfully!");

                }

            break;

            //6th option
            case 6:
                System.out.println("You have selected: Remove title");
                System.out.println("Enter Title: ");
                scnr.nextLine();
                String titleRemove = scnr.nextLine();
                if(findCallNum(literature, count, titleRemove) != -1) {
                    if(findCallNum(literature, count, titleRemove) == literature.length -1) {
                        literature[literature.length -1] = null;
                    }
                    else {
                        for(int i=findCallNum(literature, count, titleRemove); i<count; i++) {
                            literature[i] = literature[i+1];
                        }
                    }
                    count--;
                    System.out.println("Successfully removed title");
                }
                else {
                    System.out.println("Title not found bozo");
                }

            break;

            case 7: 
                System.out.println("You have selected: Sort titles by year");
                compareTo(literature, count);
                //compareTest(literature, count);

            break;

            case 8:
                System.out.println("You have selected: View titles due for restoration");
                System.out.println("Titles found: ");
                findRestore(literature, count);

            break;

            case 9:
                System.out.println("You have selected: Exit the program");
                System.out.println("Goodbye.");
                try {
                    PrintWriter save = new PrintWriter("epic.txt");
                    for(int i=0; i<count; i++) {
                        save.println(literature[i].simpleString());
                    }
                    save.close();
                } catch(FileNotFoundException e) {
                    System.out.println("Error");
                }
                
            break;

        }


        }while(option != 9);
    }

    /**
     * Compares the titles in the array and sorts them by year
     * @param literature - Array of books and periodicals 
     * @param count - Keeps track of the number of books/periodicals in the array 
     */
    public static void compareTo(Titles[] literature, int count) {
        for (int i=1; i<count; i++) {
            Titles currentVal = literature[i];
            int j = i;
            while ((j>0) && (currentVal.getPubDate() > (literature[j - 1].getPubDate()))) {
                 literature[j] = literature[j - 1];
                 j--;
            }
            literature[j] = currentVal;
         }

         System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
            for(int i=0; i<count; i++) {
                System.out.println(literature[i]);
                System.out.println();
            }
    }


    /**
     * Checks to see if the title is older than 20 years
     * @param literature - array of titles 
     * @param count - keeps track of the number of titles in the array
     */
    public static void findRestore(Titles[] literature, int count) {
        System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
        for(int i=0; i<count; i++) {
            if(literature[i].getPubDate() < 2022-20) {
                System.out.println(literature[i]);
                
            }

        }
        
    }
    


    /**
     * This method prints out the literature list 
     * @param literature - Array gained from reading the 'titles.txt' file
     * @param count - Counter that makes sure the array hasn't run out of space
     */
    public static void printLit(Titles[] literature, int count) {
        System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
        for(int i=0; i<count; i++) {
            System.out.println(literature[i]);
            System.out.println();
        }

    }

    /**
     * Finds if a user's inputted call number exists in the array
     * @param literature - the array of titles
     * @param count - keeps track of all titles in the array
     * @param input - user's input for a call number
     * @return
     */
    public static int findCallNum(Titles[] literature, int count, String input) {
        System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
        for (int i = 0; i < count; i++) {
            if (input.equals(literature[i].getCallNum())) {
                System.out.println(literature[i]);
                return i;
            }
            
        }
        return -1;

    }

    /**
     * Finds the title in the array that the user inputted and check if the title exists or not 
     * @param literature - the array of every title
     * @param count - keeps track of all the titles in the array
     * @param input - the user's inputted title. This gets compared to any title found in the array
     * @return - returns a -1 if no title is found
     */
    public static int findTitle(Titles[] literature, int count, String input) {
        //System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
        for (int i = 0; i < count; i++) {
            if (input.equals(literature[i].getTitle())) {
                System.out.println(literature[i]);
                return i;
            }
            
        }
        return -1;

    }

    /**
     *Visually displays if the user's input matched the regex
     * @param matches - Checks to see if the user's input matches the regex
     */
    public static void printMatchedResult(boolean matches) {
        if(matches) {
            System.out.println("Nice match");
        }
        else {
            System.out.println("Bad match yikes");
        }
    }

    /**
     * Finds if titles exsist in the year the user inputted
     * @param literature - array that is read 
     * @param count - counts how many titles are in the array
     * @param input - takes the input of the user
     * @return
     */
    public static int findPubDate(Titles[] literature, int count, int input) {
        System.out.printf("%-16s%-56s%-28s%-10s%s\n", "Call Number", "Title", "Publisher", "Year", "Copies");
        for (int i = 0; i < count; i++) {
            if(input == literature[i].getPubDate()) {
                System.out.println(literature[i]);
                //return i;
            }
            
        }
        return -1;

    }


    /**
     * This is the method used to display the options available
     */
    public static void display() {
        System.out.println("Select an operation:");
        System.out.println("1: View all titles");
        System.out.println("2: Search by call number");
        System.out.println("3: Search by title");
        System.out.println("4: Search by year");
        System.out.println("5: Add a new title");
        System.out.println("6: Remove title");
        System.out.println("7: Sort titles by year");
        System.out.println("8: View titles due for restoration");
        System.out.println("9: Exit the program");
    }

    //Checks to see if integer is valid and in range 
    /**
     * 
     * @param scnr - Accepts input from the user
     * @return - Returns the value if it is a valid integer
     */
    public static int getInt(Scanner scnr) {
        int number=0;
        try{
             number = scnr.nextInt();
             if(number<1 || number>9) throw new Exception();
        }
        catch(Exception e){
             System.out.println("Invalid Input");
             scnr.nextLine();
             getInt(scnr);
        }
        return number;
    }

     //Checks to see if integer is valid and in range 
    /**
     * 
     * @param scnr - Accepts input from the user
     * @return - Returns the value if it is a valid integer
     */
    public static int getYear(Scanner scnr) {
        int number=0;
        try{
             number = scnr.nextInt();
             if(number<1900 || number>2022) throw new Exception();
        }
        catch(Exception e){
             System.out.println("Invalid year. Must be between 1900 and 2022");
             scnr.nextLine();
             getYear(scnr);
        }
        return number;
    }
    
}
