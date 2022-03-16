// import java.util.*;
// public class ALA3Test {
//     public static void main(String[] args) {
//         Number[] numbers = new Number[10];
//         Random r = new Random();
//         numbers[0] = r.nextInt(1000);
//         numbers[1] = r.nextInt(1000);
//         numbers[2] = r.nextLong();
//         numbers[3] = r.nextLong();
//         numbers[4] = r.nextFloat();
//         numbers[5] = r.nextFloat();
//         numbers[6] = r.nextDouble();
//         numbers[7] = r.nextDouble();
//         numbers[8] = newRational(r.nextInt(10), r.nextInt(10) + 1);
//         numbers[9] = newRational(r.nextInt(10), r.nextInt(10) + 1);

//         for(int i=0; i<numbers.length; i++) {
//             System.out.println(numbers[i] + "\t" + numbers[i].intValue() + "\t" + numbers[i].doubleValue());
//         }

//         Rational[] fractions = new Rational[8];
//         for(int i=0; i<fractions; i++) {
//             fractions[i] = new Rational(r.nextInt(10), r.nextInt(10) +1);
//         }

//         for(int i=0; i<fractions.length; i++) {
//             System.out.println(fractions[i]);
//         }

//         Rational s = fractions[0].add(fractions[1]);
//         Rational d = fractions[0].sub(fractions[3]);
//         Rational p = fractions[0].mult(fractions[5]);
//         Rational q = fractions[0].div(fractions[7]);

//         System.out.println(fractions[0] + "+" + fractions[1] + "= " + s);
//         System.out.println(fractions[2] + "-" + fractions[3] + "= " + d);
//         System.out.println(fractions[4] + "*" + fractions[5] + "= " + p);
//         System.out.println(fractions[6] + "/" + fractions[7] + "= " + q);

//         java.util.Arrays.sort(fractions);
//         for(int i=0; i<fractions.length; i++) {
//             System.out.println(fractions[i]);
//         }








//     }
    
// }
