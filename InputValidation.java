import java.util.*;
public class InputValidation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("This is where things shall be tested");
        getInt(scnr);


    }

    //Yurd
//     public static int getZeInt(Scanner scnr) {
//         boolean buggin = false;
//         int intValue = 0;
    
//         do {
//             if(!scnr.hasNextInt()) {
//                 System.out.println("You did not enter an integer value");
//                 scnr.nextLine();
//             }
//             else {
//                 intValue = scnr.nextInt();
//                 buggin = true;
//                 if((intValue < 2) || (intValue > 25)) {
//                     System.out.println("You did not enter a valid selection. Please input a number between 2 and 25 .");
//                     scnr.nextLine();

//                 }
//                 else {
//                     buggin = true;
//                 }
                
//             }

//         }while(!buggin);

//         return intValue;
//    }

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
