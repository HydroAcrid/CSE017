/**
 * ALA_6
 * test.java
 * Kevin Dotel
 * 3/16/22
 */

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.*;


public class test {
    //part 1 
    public static void main(String[] args) {
        Stack<Integer> postfixStack = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        String answer;

        do {
            try {
        System.out.println("Enter a postfix expression: ");
        String postfix = keyboard.nextLine();
        String[] tokens = postfix.split(" ");
        for(int i = 0; i<tokens.length; i++) {
            if(tokens[i].matches("\\d{1,}")) { //operand
                postfixStack.push(Integer.parseInt(tokens[i]));
            }
            else {
                int op1 = postfixStack.pop();
                int op2 = postfixStack.pop();
                switch(tokens[i]) {
                    case "+":
                        postfixStack.push(op2 + op1);
                    break;
                    case "-":
                        postfixStack.push(op2 - op1);
                    break;
                    case "*":
                        postfixStack.push(op2 * op1);
                    break;
                    case "/":
                        postfixStack.push(op2 / op1);
                    break;
                    default:
                        System.out.println("Invalid operation.");
                }
            }
        }

        int result = postfixStack.pop();
        if(postfixStack.isEmpty()) {
            System.out.println("Result: " + result);
        }
        else {
            System.out.println("Malformed expression");
        }
    }catch(EmptyStackException e) {
        System.out.println("Malformed expression");
    }
        System.out.println("Do you want to evaluate another expression?");
        answer = keyboard.nextLine();
        postfixStack.clear();

    } while(answer.equals("y"));

    //part 2: PriorityQueue
    PriorityQueue<Job> printerQueue = new PriorityQueue<>();
    readJobs(printerQueue, "jobs.txt");
    long PrinterSpeed = 10000;
    long totalSize = 0;
    while(!printerQueue.isEmpty()) {
        Job job = printerQueue.poll();
        String time = calcTime(job.getSize(), PrinterSpeed);
        System.out.printf("%s\t\t%-10s\n", job.toString(), time); 
        totalSize += job.getSize();
    }
    System.out.println("Total Printing Time: " + calcTime(totalSize, PrinterSpeed));

    }

    /**
     * Calculates the time necessary to complete the task
     * @param size - size of the number
     * @param speed - speed at which number is calculated
     * @return - returns the time it took
     */
    public static String calcTime(long size, long speed) {
        long time = size / speed; //printing time in seconds 
        int days = 0, hours = 0, minutes = 0, seconds = 0;
        String out = "";
        if(time > 86400) {
            //days
            days = (int) (time/86400);
            time = (int) (time%86400);
            if(days < 10)
                out += "0" + days + ":";
            else 
                out += days + ":";
        }
        else 
            out += "00:";
            if(time > 3600) {
                //hours
                hours = (int) (time/3600);
                time = (int) (time%3600);
                if(hours < 10)
                    out += "0" + hours + ":";
                else 
                    out += hours + ":";
            }
            else 
                out += "00:";
            if(time > 60) {
                //minutes 
                minutes = (int) (time/60);
                time = (int)time % 60;
                if(minutes < 10)
                    out += "0" + minutes + ":";
                else 
                    out += minutes + ":";
            }
            else
                out += "00:";
                seconds = (int) Math.round(time);
                if(seconds < 10)
                    out += "0" + seconds;
                else 
                    out += seconds;

                return out;
    }

    /**
     * Opens jobs.txt file and reads it 
     * @param pq - list of jobs 
     * @param fileName - Jobs.txt file
     */
    public static void readJobs(PriorityQueue<Job> pq, String fileName) {
        File file = new File(fileName);
        Scanner readFile = null;
        try {
            readFile = new Scanner(file);

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(readFile.hasNext()) {
            int id = readFile.nextInt();
            int group = readFile.nextInt();
            long size = readFile.nextLong();
            Job job = new Job(id, group, size);
            pq.offer(job);
        }
        readFile.close();
    }
}