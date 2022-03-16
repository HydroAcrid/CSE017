/**
 * Kevin Dotel
 * 2/17/2022 
 */
package ALA3;
public class Rational extends Number implements Comparable<Rational>, Cloneable {

    private int numerator;
    private int denominator;

    /**
     * Constructor 
     */
    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * 
     * @param n - numerator input 
     * @param d - denominator input
     */
    public Rational(int n, int d) {
        numerator = n;
        denominator = d;
    }

    //Return numerator
    public int getNumerator() {
        return numerator;
    }

    //Return denominator 
    public int getDenominator() {
        return denominator;
    }

    //Sets the numerator 
    public void setNumerator(int n) {
        numerator = n;
    }

    //Sets the denominator 
    public void setDenominator(int d) {
        denominator = d;
    }
    
    //Outputs the string  
    public String toString() {
        if(numerator == 0) {
            return "0";
        }
        if(denominator == 1) {
            return numerator + "";
        }
        if(numerator == denominator) {
            return 1 + "";
        }
        if(denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        return numerator + "/" + denominator;
    }

    /**
     * 
     * @param r - integer input 
     * @return - returns input after adding 
     */
    public Rational add(Rational r) {
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.denominator + this.denominator * r.numerator;
        Rational sum = new Rational(n,d);
        sum.reduce();
        return sum;
    }

     /**
     * 
     * @param r - integer input 
     * @return - returns input after subtracting 
     */
    public Rational sub(Rational r) {
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.denominator - this.denominator * r.numerator;
        Rational diff = new Rational(n,d);
        diff.reduce();
        return diff;
    }

     /**
     * 
     * @param r - integer input 
     * @return - returns input after multiplying 
     */
    public Rational mult(Rational r) {
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.numerator; 
        Rational prod = new Rational(n,d);
        prod.reduce();
        return prod;
    }

     /**
     * 
     * @param r - integer input 
     * @return - returns input after dividing 
     */
    public Rational div(Rational r) {
        int d = this.denominator * r.numerator;
        int n = this.numerator * r.denominator; 
        Rational quot = new Rational(n,d);
        quot.reduce();
        return quot;
    }

    //reduces the value 
    private void reduce() {
        int g = gcd();
        numerator /= g;
        denominator /= g;
    }

    //finds the greatest common denominator
    private int gcd() {
        int g = 1;
        for(int i=2; i<numerator || i<denominator; i++) {
            if(numerator%i == 0 && denominator%i == 0) {
                g=i;
            }
        }
        return g;
    }

    public int intValue() {
        return numerator/denominator;
    }

    public float floatValue() {
        return (float)numerator/denominator;
    }

    public long longValue() {
        return (long)numerator/denominator;
    }

    public double doubleValue() {
        return (double)numerator/denominator;
    }

    //compares the variables 
    public int compareTo(Rational r) {
        if(doubleValue() == r.doubleValue()) {
            return 0;
        }
        else if(doubleValue() > r.doubleValue()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public Object clone() {
        return new Rational(numerator, denominator); 
    }
}
