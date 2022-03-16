import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class Carlot {
    public static void main(String[]args){
        Vehicle[] lot = new Vehicle[20];
        int count = 0;
        Scanner userIn = new Scanner(System.in);
        count = readVehicles(lot, "vehicles.txt");
        int userChoice = 1;
        String[] list = new String[8];


        //Reads Text file
        try {
        File myFile = new File("vehicles.txt");
        Scanner fileReader = new Scanner(myFile);

        while(fileReader.hasNextLine()) {
            list = fileReader.nextLine().split(";");
            if(list[0].equals("A")) {
                lot[count] = new Automobile(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]), list[7]);
                count++;
            }
            else if(list[0].equals("M")) {
                lot[count] = new Motorcycle(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]));
                count++;
            }
            else if(list[0].equals("T")) {
                lot[count] = new Truck(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]));
                count++;
            }

        }
        fileReader.close();
        

        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        // System.out.println("this is what the file looks like:");
        // System.out.println(Arrays.toString(lot));

        
        do{
            printMenu();
            userChoice = userIn.nextInt();
            switch(userChoice){
               case 1: printVehicles(lot, count); 
                       break;
               case 2: 
                       System.out.println("Enter a VIN to search for");
                       String vin = userIn.next(); 
                       boolean checkSpot = checkVIN(vin);
                    //    if(checkSpot == false) {
                    //        System.out.println("Invalid input");
                    //        break;
                    //    }
                        findVin(vin, lot, count);
                       try {
                          if (checkVIN(vin)) {
                        	  Vehicle v = findVin(vin, lot, count); 
                        	  if(v != null) {
                        		System.out.println("\nVehicle not found: ");
                                
                        	  }else {
                        		 System.out.println("\nVehicle found: ");
                        	  }
                          }
                        }
                        catch(InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: Arrays.sort(lot, 0, count);
                        compareTo(lot, count);
                        printVehicles(lot, count); 
                        break;
                case 4: System.out.println("Goodbye");
                        break;
                default: System.out.println("Invalid operation");
           }
            
        } while (userChoice != 4);
        
        userIn.close();
    }

    public static void compareTo(Vehicle[] lot, int count) {
        for (int i=1; i<count; i++) {
            Vehicle currentVal = lot[i];
            int j = i;
            while ((j>0) && (currentVal.getYear() > (lot[j - 1].getYear()))) {
                 lot[j] = lot[j - 1];
                 j--;
            }
            lot[j] = currentVal;
         }

    }

    public static Vehicle findVin(String vin, Vehicle[] list, int count){
        for(int i = 0; i<count; i++ ){
            if(vin.equals(list[i].getVin())){
                System.out.println(list[i]);
                //return (Vehicle)(list[i].clone());
                
             }
        }
        return null;
    }

    public static void printMenu(){
        System.out.println("Select an Operation");
        System.out.println("1. View Vehicles");
        System.out.println("2. Search by VIN ");
        System.out.println("3. Sort Vehicles by Year");
        System.out.println("4. Exit"); 

    }

    public static boolean checkVIN(String vin) {
        boolean matches = false;
        try {
        String regexPattern = "[0-9A-Z]{17}";
        matches = Pattern.matches(regexPattern, vin);        
        if(matches = false) throw new InputMismatchException(); 
        } catch (InputMismatchException e){
            System.out.println("Incorrect output. Must be all Capital letters and nunbers");
            return false;
        }
        return false;
    }

    public static int readVehicles(Vehicle[]list, String filename){
        String[] park = new String[9];
        int count = 0;
        try {
            File myFile = new File("vehicles.txt");
            Scanner fileReader = new Scanner(myFile);

            // while(fileReader.hasNextLine()) {
            //     park = fileReader.nextLine().split(";");
            //     if(park[0].equals("A")) {
            //         list[count] = new Automobile(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]), list[7]);
            //         count++;
            //     }
            //     else if(park[0].equals("M")) {
            //         list[count] = new Motorcycle(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]));
            //         count++;
            //     }
            //     else if(park[0].equals("T")) {
            //         list[count] = new Truck(list[1], list[3], list[4], Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[6]));
            //         count++;
            //     }
    
            // }
            // fileReader.close();
            
    
            }
            catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            //System.out.println("this is what the file looks like:");
            //System.out.println(Arrays.toString(lot));
        return 0;
    }

    public static void printVehicles(Vehicle[]list, int count){
    	System.out.printf("%-17s\t%-5s\t%-10s\t%-10s\t%-5s\t%-20s\t%s\n", 
    			"VIN", "Year", "Make", "Model", "Seats", "Doors/Wheels/Tow Capacity", "Type");
        for(int i=0; i<count; i++){
            System.out.println(list[i]);
        }
    }




}
