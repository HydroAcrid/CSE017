/*
Kevin Dotel
2/11/22
*/

package Media2;

import java.nio.file.*;
import java.util.*;
import java.io.*;

public class MediaTest2 {
    public static void main(String[] args) throws Exception {
        //Variables
        Scanner scnr = new Scanner(System.in);
        File aFile = new File ("media.txt");
        int option;
        int count = 0;
        boolean buggin = true;
        String[] list = new String[5];
        Media2[] programs = new Media2[50];


        //Reads media.txt file and displays it
        try {
            Scanner fileReader = new Scanner(aFile);
            while (fileReader.hasNextLine()) {
                list = fileReader.nextLine().split("\\|");
                if(list[0].equals("Movie")) {
                    programs[count] = new Movie2(list[1], list[2], list[3], Integer.parseInt(list[4]));
                }
                else if(list[0].equals("Show")) { 
                    programs[count] = new Show2(list[1], list[2], list[3], Integer.parseInt(list[4]));
                }
                count++;
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("this is what the file looks like: ");
        System.out.println(Arrays.toString(programs));

        do {
        System.out.println("Welcome to Kevins's MediaTest2 program!! So much fun yayyy!!!!");
        display();

        //Input Validation for choices. 
        option = getInt(scnr);

        //Options
        switch(option) {
            //View Media List 
            case 1:
                System.out.println("You have selected: View Media List");
                printMedia(programs, count);
                break;
            //Search Media by Title
            case 2:
                System.out.println("You have selected: Search Media by Title");
                System.out.println("Enter a title: ");
                scnr.useDelimiter("\n");
                String input = scnr.next();
                int temp = findMedia(programs, count, input);
                if(temp < 0) {
                    System.out.println("Media not found");
                }
                else {
                    System.out.println("Media was found at: " + temp);
                }
                break;
            //Adds new Media
            case 3:
                System.out.println("You have selected: Add a New Media");
                System.out.println("Enter media title: ");
                //scnr.useDelimiter("\n");

                //Choose title and finds if title already exists
                String mediaTitle = scnr.next();
                if(findMedia(programs, count, mediaTitle) != -1) {
                    System.out.println("this title already exists");
                    break;
                }

                //Determines whether the media is a movie or show
                System.out.println("Enter the type (Movie/Show): ");
                String mediaType = scnr.next();    
                if(mediaType.equalsIgnoreCase("Movie")) {
                    System.out.println("Movie was chosen");
                    System.out.println("Enter the genre (Drama/Comedy/Action/Animation/Anime/Documentary etc.) :");
                    String mediaGenre = scnr.next();
                    System.out.println("Enter the rating: ");
                    String mediaRating = scnr.next();
                    try {
                        checkRating(mediaRating, "Movie");
                    } catch(InvalidRatingException e) {
                        System.out.println("Invalid");
                        break;
                    }
                    System.out.println("Enter movie duration: ");
                    int mediaDuration;
                    try {
                    mediaDuration = scnr.nextInt();
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid");
                        break;
                    }
                    programs[count] = new Movie2(mediaTitle, mediaGenre, mediaRating, mediaDuration);
                    count++;

                    
                }
                //Path code takes if show is chosen
                else if(mediaType.equalsIgnoreCase("Show")) {
                    System.out.println("Show was chosen");
                    System.out.println("Enter the genre (Drama/Comedy/Action/Animation/Anime/Documentary etc.) :");
                    String mediaGenre = scnr.next();
                    System.out.println("Enter the rating: ");
                    String mediaRating = scnr.next();
                    try {
                        checkRating(mediaRating, "Show");
                    } catch(InvalidRatingException e) {
                        System.out.println("Invalid");
                        break;
                    }
                    System.out.println("Enter show seasons: ");
                    int mediaSeasons;
                    try {
                    mediaSeasons = scnr.nextInt();
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid");
                        break;
                    }
                    programs[count] = new Show2(mediaTitle, mediaGenre, mediaRating, mediaSeasons);
                    count++;

                }
                else {
                    System.out.println("Incorrect. Choose either 'Movie' or 'Show'");
                }
                break;

            //Removes media
            case 4:
                System.out.println("You have selected: Remove an Existing Media");
                System.out.println("Enter a title: ");
                scnr.useDelimiter("\n");
                String checkTitle = scnr.next();
                if(findMedia(programs, count, checkTitle) != -1) {
                    if(findMedia(programs, count, checkTitle) == programs.length -1) {
                        programs[programs.length -1] = null;
                        
                    }
                    else {
                        for(int i=findMedia(programs, count, checkTitle); i<count; i++) {
                            programs[i] = programs[i+1];
                        }
                    }
                    count--;
                    System.out.println("Successfully removed media");

                }
                else {
                    System.out.println("Media not found bozo");
                }
                
                break;
                
            //Sorts media
            case 5:
                System.out.println("You have selected: Sort Media by Genre");
                sortMedia(programs, count);
                break;
            case 6:
                try {
                    PrintWriter save = new PrintWriter("media.txt");
                    for(int i=0; i<count; i++) {
                        save.println(programs[i].simpleString());
                    }
                    save.close();
                } catch(FileNotFoundException e) {
                    System.out.println("Error");
                }
                break;
            }
            
        } while (option != 6);
        
    }




    //this method needs to print the amount of objects as the count I guess? I'm not too sure what they mean by this honestly 
    public static void printMedia(Media2[] list, int count) {
        System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<count; i++) {
                System.out.println(list[i]);
                System.out.println();
            }
    }

    //Searches for a media object
    public static int findMedia(Media2[] list, int count, String title) {
        //System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
        for (int i = 0; i<count; i++) {
            if (title.equals(list[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    //Sorts based off of genre rather than rating 
    public static void sortMedia(Media2[] list, int count) {
        for (int i=1; i<count; i++) {
            Media2 currentVal = list[i];
            int j = i;
            while ((j>0) && (currentVal.getGenre().compareTo(list[j - 1].getGenre()) < 0)){
                 list[j] = list[j - 1];
                 j--;
            }
            list[j] = currentVal;
         }

         System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<count; i++) {
                System.out.println(list[i]);
                System.out.println();
            }

    }

    
   
    public static boolean checkRating(String rating, String type) throws InvalidRatingException {
        if(type.toLowerCase().equals("movie")) {
            if(rating.equals("G") || rating.equals("PG") || rating.equals("PG-13") || rating.equals("R") || 
            rating.equals("NC-17")) {
                return true;
            }
            else {
                throw new InvalidRatingException("Invalid Rating.");
            }

        }
        else if(type.toLowerCase().equals("show")) {
            if(rating.equals("TV-Y") || rating.equals("TV-Y7") || rating.equals("TV-G") || rating.equals("TV-PG") ||
            rating.equals("TV-14") || rating.equals("TV-MA")) {
                return true;
            }
        }
        else {
            throw new InvalidRatingException("Invalid Rating.");
        }

        return false;

    }




     //Options display Method. Prints the menu and does not take any parameters. 
     public static void display() {
        System.out.println("Select an operation: ");
        System.out.println("1: View Media List");
        System.out.println("2: Search media by title");
        System.out.println("3: Add a new media");
        System.out.println("4: Remove an existing media");
        System.out.println("5: Sort media by genre");
        System.out.println("6: Exit");
    }

    //Checks to see if integer is valid and in range 
    /**
     * 
     * @param scnr - Accepts input from the user
     * @return - Returns the value if it is a valid integer
     */
    public static int getInt(Scanner scnr) {
        int number=0;
        System.out.println("Pick between 1-6");
        try{
             number = scnr.nextInt();
             if(number<1 || number>6) throw new Exception();
        }
        catch(Exception e){
             System.out.println("Invalid Input");
             scnr.nextLine();
             getInt(scnr);
        }
        return number;
    }

    

    
    
}
