
/**
 * Kevin Dotel
 * 3/26/22
 * AirportSimulation.java
 */

import java.util.*;

public class AirportSimulation {
    public static void main(String[] args) {

        Queue<Integer> landing = new LinkedList<>();
        Queue<Integer> takeOff = new LinkedList<>();
        int time = 0;
        int simulationTime = 0;
        double landingRate = 0;
        double takeOffNum = 0;
        double takeOffRate = 0;
        int takeOffTime = 0;
        int landingTime = 0;
        //if runway = true its busy. if it equals false, it is free
        int runway = 0;
        int landingCounter = 0;
        int takeOffCounter = 0;
        double landingTimeCounter = 0;
        double takeOffTimeCounter = 0;
        double landingQueue = 0;
        double takeOffQueue = 0;
        int landingTotalTime = 0;
        int takeOffTotalTime = 0;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to Kevin's airport simulator program! yayyy so much fun!!!!");
        System.out.println("Enter the simulation parameters:");
        System.out.println("Simulation duration: ");
        simulationTime = scnr.nextInt();
        System.out.println("Takeoff time (minutes): ");
        takeOffTime = scnr.nextInt();
        System.out.println("Landing time (minutes): ");
        landingTime = scnr.nextInt();
        System.out.println("Landing rate (# per hour): ");
        landingRate = scnr.nextDouble();
        System.out.println("Takeoff rate (# per hour): ");
        takeOffRate = scnr.nextDouble();
        
        System.out.println("Simulation parameters: ");
        System.out.println("Simulation time: " + simulationTime);
        System.out.println("Landing rate: " + landingRate + " airplanes/hour");
        System.out.println("Landing time: " + landingTime + " minutes");
        System.out.println("Takeoff rate: " + takeOffRate + " airplanes/hour");
        System.out.println("Takeoff time: " + takeOffTime + " minutes");

        

        //Simulation Loop
        for(time = 0; time<simulationTime; time++) {

            // simulating arrival of landing requests
            double random = Math.random();
            double landingNum = random;
            //System.out.println(landingNum);
            if(landingNum < landingRate / 60) {
                landingTotalTime = time;
                landing.offer(landingTime);
                //landingTotalTime += landingTime;
                landingCounter++;
                landingTimeCounter += landingTotalTime - landingTime;
                landingQueue += landing.size();
                //System.out.println("This happened");
            }

            // simulating arrival of takeoff requests  
            takeOffNum = random;
            if(takeOffNum < takeOffRate / 60) {
                takeOffTotalTime = time;
                takeOff.offer(takeOffTime);
                //takeOffTotalTime += takeOffTime;
                takeOffCounter++;
                takeOffTimeCounter += takeOffTotalTime - takeOffTime;
                takeOffQueue += takeOff.size();
                //System.out.println("This also happened");
            }

            //Simulating the landing/takeoff operations
            if(runway == 0) {
                if(!landing.isEmpty()) {
                    //System.out.println("The landing time was: " + landing.poll());
                    landing.poll();
                    runway++;
                }
                else if(!takeOff.isEmpty()) {
                    //System.out.println("The takeoff time was: " + takeOff.poll());
                    takeOff.poll();
                    runway++;
                }
            }
            else {
                runway--;
            }
            
        }

        //Average Variables
        int landingAvg = (int)landingTimeCounter / landingCounter;
        int takeOffAvg = (int)takeOffTimeCounter / takeOffCounter;
        int landingWaitNum = (int)landingQueue / simulationTime;
        int takeOffWaitNum = (int)takeOffQueue / simulationTime;


        System.out.println("\nSimulation Output");
        System.out.println("Total number of Landing requests: " + landingCounter);
        System.out.println("Total number of Takeoff requests: " + takeOffCounter);

        System.out.println("\nAverage waiting time for landing airplanes is " + landingAvg + " minutes");
        System.out.println("Average number of waiting landing requests: " + landingWaitNum);

        System.out.println("\nAverage waiting time for takeoff airplanes is " + takeOffAvg + " minutes");
        System.out.println("Average number of waiting takeoff requests: " + takeOffWaitNum);

        System.out.println("\nNumber of landing requests remaining in the Queue (never served): " + runway);
        System.out.println("Number of Takeoff requests remaining in the Queue (never served): " + runway);
        
        
       
        
 

            
        
    

    }


}