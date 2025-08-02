package  Week_05.Java_Version;
// Triangle class to represent a triangle with various properties and methods
public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    private static int objectCount = 0;

    public Triangle() {
        this(1.0, 1.0, 1.0); 
     
    }

    public Triangle(double side) {
        this(side, side, side); 
        
    }

    public Triangle(double x, double y) {
        this(x, x, y);
     
    }   
    
    
    public Triangle(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Sides must be greater than zero.");
            
        }
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        objectCount++;
    }

    public Triangle(Triangle other) {
        this.side1 = other.side1;
        this.side2 = other.side2;
        this.side3 = other.side3;
        objectCount++;
    }




    public static int getObjectCount() {
        return objectCount;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setSides(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean isEquilateral() {
        if( (side1 == side2) && (side2 == side3) ) {
            return true;
        }
        return false;
    }
    
    public boolean isRightAngle() {
       // A triangle is a right-angled triangle if and only if the square of the longest side (hypotenuse) 
       // is equal to the sum of the squares of the other two sides. 
       // This is known as the Pythagorean theorem (a² + b² = c²).
       
       // Sort the sides to easily identify the hypotenuse
        
       double[] sides = {side1, side2, side3};
       java.util.Arrays.sort(sides); 
       
       double a = sides[0];
       double b = sides[1];
       double c = sides[2];
       
       return ( ( (c * c) == ( (a * a) + (b * b) ) ) );

    }

    public boolean isScalene() {
        return (side1 != side2 && side2 != side3 && side1 != side3);
    }


    public boolean isIsosceles() {
        // Isosceles means exactly two sides are equal, not three
        if (isEquilateral()) {
            return false;
        }
        return (side1 == side2 || side2 == side3 || side1 == side3);
    }
 
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {

        // Using Heron's formula to calculate the area of the triangle
        // Area = sqrt(s * (s - a) * (s - b) * (s - c))
        // where s is the semi-perimeter: s = (a + b + c)  / 2

        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

}