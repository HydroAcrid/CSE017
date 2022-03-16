package Media;
import java.util.*;
public class MediaTest {
    public static void main(String[] args) {
        
        //Variables
        Scanner scnr = new Scanner(System.in);
        int option;
        boolean buggin = true;
        Media[] programs = new Media[10];
        programs[0] = new Show("Archive81", "Sci-fi", "TV-MA", 1);
        programs[1] = new Show("After Life", "Drama", "TV-MA", 3);
        programs[2] = new Movie("After We Fell", "Drama", "R", 98);
        programs[3] = new Show("The Witcher", "Drama", "TV-MA", 2);
        programs[4] = new Movie("Don't Look Up", "Drama", "R", 138);
        programs[5] = new Movie("The Alpinist", "Documentary", "PG-13", 92);
        programs[6] = new Movie("Miss Sloane", "Drama", "R", 131);
        programs[7] = new Show("Arcane - League of Legends", "Animation", "TV-14", 1);
        programs[8] = new Movie("The Girl with the Dragon Tattoo", "Drama", "R", 158);
        programs[9] = new Show("Arrested Development", "Comedy", "TV-MA", 5);

        do {
        //Intro
        System.out.println("Welcome to Kevin's movie program!! So much fun!!!");
        display();

        //Input Validation for choices. Is there a way to combine both range and integer check in one method?
        option = getInt(scnr);

        //Options
        if(option == 1) {
            System.out.println("You have selected: View Media List");
            printMedia(programs, 0);
        }
        else if(option == 2) {
            System.out.println("You have selected: View Movies");
            printMedia(programs, 1);
        }
        else if(option == 3) {
            System.out.println("You have selected: View Shows");
            printMedia(programs, 2);
        }
        else if(option == 4) {
            System.out.println("You have selected: Search Media by Genre");
            System.out.println("Enter a genre: (Drama, Comedy, Action, Anime, Documentary, Sci-Fi, Animation");
            String input = scnr.next();
            int count = findGenre(programs, input);
            System.out.println(count + " media found for the genre: " + input);

        }
        else if(option == 5) {
            System.out.println("You have selected: Sort Media by Rating");
            sortRating(programs);
        }
        else {
            System.out.println("Goodbye. Thank you for using my program.");
        }


        }while(option != 6);



    }


    //Options display Method. Prints the menu and does not take any parameters. 
    public static void display() {
        System.out.println("Select an operation: ");
        System.out.println("1: View Media List");
        System.out.println("2: View Movies");
        System.out.println("3: View Shows");
        System.out.println("4: Search media by genre");
        System.out.println("5: Sort Media by rating");
        System.out.println("6: Exit");
    }

    /**
     * String output method. This is where the media is displayed. 
     * @param list - Takes the Media arraylist in order to display
     * @param type - Takes the integer type to differentiate between all media, movies, and shows
     */
    public static void printMedia(Media[] list, int type) {
        if(type == 0) {
            System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<list.length; i++) {
                System.out.println(list[i]);
                System.out.println();
            }
        }
        else if(type == 1) {
            System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<list.length; i++) {
                if(list[i] instanceof Movie) {
                    System.out.println(list[i]);
                    System.out.println();
                }
                
            }
            
        }
        else if(type == 2) {
            System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<list.length; i++) {
                if(list[i] instanceof Show) {
                    System.out.println(list[i]);
                    System.out.println();
                }
                
            }

        }
    }
    
    //Find Genre Method 
    /**
     * Finds the shows or movies for a specific genre. The user inputs a genre. 
     * @param list - Takes the Media arraylist in order to locate genres
     * @param genre - This is user input for what genre they would like. Options include: Sci-fi, Drama, Documentary, Animation, and Comedy
     * @return - This returns the number of a specified drama is in the list. 
     */
    public static int findGenre(Media[] list, String genre) {
        int count = 0;
        System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
        for (int i = 0; i < list.length; i++) {
            if (genre.equals(list[i].getGenre())) {
                System.out.println(list[i]);
                count++;
            }
            
        }


        return count;
    }


    //Insertion Sort Method
    //Sorts the show by the rating like TV-MA or TV-14
    public static void sortRating(Media[] list) {

        for (int i=1; i<list.length; i++) {
            Media currentVal = list[i];
            int j = i;
            while ((j>0) && (currentVal.getRating().compareTo(list[j - 1].getRating()) < 0)){
                 list[j] = list[j - 1];
                 j--;
            }
            list[j] = currentVal;
         }

         System.out.printf("%-30s\t%-10s\t%-5s\t%s\n", "Title", "Genre", "Rating", "Duration/Seasons");
            for(int i=0; i<list.length; i++) {
                System.out.println(list[i]);
                System.out.println();
            }
       
    }
       

    // }

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
