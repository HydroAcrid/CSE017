import java.util.*;


public class RomanNum {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String romanNum;
        System.out.println("This is the number to roman numeral calculator");
        System.out.println("Enter an option: ");
        display();
        
        //Option display
        int option = getInt(scnr);

        switch(option) {
            case 1:
                System.out.println("You have chosen: Option 1");
                System.out.println("Input a number:");

                int numInput = 0;
                try {
                    numInput = scnr.nextInt();
                    if(numInput < 0) throw new Exception();
                } catch(Exception e) {
                    System.out.println("Invalid number");
                    break;
                }

                if(numInput == 1) {
                    System.out.print("I");
                }
                else if(numInput == 2) {
                    System.out.print("II");
                }
                else if(numInput == 3) {
                    System.out.print("III");
                }



            break;
            case 2:
                System.out.println("You have chosen: Option 2");
            break;

            case 3:
                System.out.println("You have chosen: Option 3");
            break;
        }
    }

    public static void display() {
        System.out.println("1: Convert Number to Roman Numeral ");
        System.out.println("2: Conver Roman Numeral to Number ");
        System.out.println("3: Exit the Program");
    }

    public static int getInt(Scanner scnr) {
        int input = 0;
        try {
            input = scnr.nextInt();
            if(input < 1 || input > 3) throw new Exception();
        } catch(Exception e) {
            System.out.println("Invalid. Please input an option.");
            display();
            scnr.nextLine();
            getInt(scnr);
        }
        return input;
    }


    
}


