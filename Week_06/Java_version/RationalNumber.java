package Week_06.Java_version;

public class RationalNumber {
    
    private int numerator;
    private int denominator;

    // default constructor
    public RationalNumber(){
        this.numerator = 0;
        this.denominator = 1;
    }

    // parameterized constructor
    public RationalNumber(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // copy constructor
    public RationalNumber(RationalNumber other){
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    // Getters
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Setters
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
    }

    // Method to add two rational numbers
    public RationalNumber add(RationalNumber other){
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    // Method to subtract two rational numbers
    public RationalNumber subtract(RationalNumber other){
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    // Method to multiply two rational numbers
    public RationalNumber multiply(RationalNumber other){
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    // Method to divide two rational numbers
    public RationalNumber divide(RationalNumber other){
        if(other.numerator == 0){
            throw new IllegalArgumentException("Cannot divide by a rational number with a numerator of zero.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    // Method to display the rational number
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Method to check equality of two rational numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RationalNumber other = (RationalNumber) obj;
        return this.numerator * other.denominator == this.denominator * other.numerator;
    } 

    // Method to simplify the rational number
    public void simplify(){
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
        if(this.denominator < 0){ // keep denominator positive
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Helper method to compute GCD wuthout recursion
    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    

   
}
