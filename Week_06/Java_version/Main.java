package Week_06.Java_version;


public class Main {

    public static void main(String[] args) {
        RationalNumber r1 = new RationalNumber(1, 2); // 1/2
        RationalNumber r2 = new RationalNumber(3, 4); // 3/4

        

        RationalNumber sum = r1.add(r2);
        RationalNumber difference = r1.subtract(r2);
        RationalNumber product = r1.multiply(r2);
        RationalNumber quotient = r1.divide(r2);    



        System.out.println("Rational Number 1: " + r1.getNumerator() + "/" + r1.getDenominator());
        System.out.println("Rational Number 2: " + r2.getNumerator() + "/" + r2.getDenominator());
        System.out.println("Sum: " + sum.getNumerator() + "/" + sum.getDenominator());
        System.out.println("Difference: " + difference.getNumerator() + "/" + difference.getDenominator());
        System.out.println("Product: " + product.getNumerator() + "/" + product.getDenominator());
        System.out.println("Quotient: " + quotient.getNumerator() + "/" + quotient.getDenominator());

        // Testing copy constructor
        RationalNumber r3 = new RationalNumber(r1); 
        System.out.println("Copied Rational Number: " + r3.getNumerator() + "/" + r3.getDenominator());
        
        // Testing default constructor
        RationalNumber r4 = new RationalNumber();
        System.out.println("Default Rational Number: " + r4.getNumerator() + "/" + r4.getDenominator());
        
        // Testing setters
        r4.setNumerator(5);
        r4.setDenominator(6);
        System.out.println("Updated Rational Number: " + r4.getNumerator() + "/" + r4.getDenominator());
      

        // Testing exception for zero denominator
        try {
            RationalNumber r5 = new RationalNumber(1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            r1.setDenominator(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        

    }   
    
}