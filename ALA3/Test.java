/**
 * Kevin Dotel 
 * 2/17/2022
 */


package ALA3;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        
        //Variables
        Number [] numbers = new Number[10];
        Random rand = new Random();

        numbers[0] = rand.nextInt(1000);
        numbers[1] = rand.nextInt(1000);
        numbers[2] = rand.nextLong();
        numbers[3] = rand.nextLong();
        numbers[4] =rand.nextFloat();
        numbers[5] = rand.nextFloat();
        numbers[6] = rand.nextDouble();
        numbers[7] = rand.nextDouble();
        numbers[8] = new Rational(rand.nextInt(10), rand.nextInt(10) + 1);
        numbers[9] = new Rational(rand.nextInt(10), rand.nextInt(10) + 1);

        //prints out numbers
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i] + "\t" + numbers[i].intValue() + 
            "\t" + numbers[i].doubleValue());
        }
    }
    
}
