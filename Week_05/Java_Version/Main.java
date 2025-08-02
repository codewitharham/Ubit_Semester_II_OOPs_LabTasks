package Week_05.Java_Version;

public class Main {
    // Main method to test the Triangle class
    public static void main(String[] args) { 
        try {
            
            // Testing various constructors

            // Default constructor
            Triangle triangleDefault = new Triangle();
            
            System.out.println("Default Triangle: " + triangleDefault);
            System.out.println("Perimeter: " + triangleDefault.getPerimeter());
            System.out.println("Area: " + triangleDefault.getArea());
            System.out.println("Is Equilateral: " + triangleDefault.isEquilateral());
            System.out.println("Is Isosceles: " + triangleDefault.isIsosceles());
            System.out.println("Is Scalene: " + triangleDefault.isScalene());
            System.out.println("Is Right Angle: " + triangleDefault.isRightAngle());
           
            
            
            System.out.println();

          
            Triangle triangle1 = new Triangle(3, 4, 5);
            
            System.out.println("Triangle 1: " + triangle1);
            System.out.println("Perimeter: " + triangle1.getPerimeter());
            System.out.println("Area: " + triangle1.getArea());
            System.out.println("Is Equilateral: " + triangle1.isEquilateral());
            System.out.println("Is Isosceles: " + triangle1.isIsosceles());
            System.out.println("Is Scalene: " + triangle1.isScalene());
            System.out.println("Is Right Angle: " + triangle1.isRightAngle());
           
            System.out.println();

            // Constructor with one side
            Triangle triangle2 = new Triangle(5);

            System.out.println("Triangle 2 (one side): " + triangle2);
            System.out.println("Perimeter: " + triangle2.getPerimeter());
            System.out.println("Area: " + triangle2.getArea());
            System.out.println("Is Equilateral: " + triangle2.isEquilateral());
            System.out.println("Is Isosceles: " + triangle2.isIsosceles());
            System.out.println("Is Scalene: " + triangle2.isScalene());
            System.out.println("Is Right Angle: " + triangle2.isRightAngle());
            
            System.out.println();

         
            // Testing the copy constructor
            Triangle triangle3 = new Triangle(triangle1);
            
            System.out.println("Triangle 3 (copy of Triangle 1): " + triangle3);
            System.out.println("Area of Triangle 3: " + triangle3.getArea());
            System.out.println("Perimeter of Triangle 3: " + triangle3.getPerimeter());
            System.out.println("Is Triangle 3 Right Angle: " + triangle3.isRightAngle());
            System.out.println("Is Triangle 3 Equilateral: " + triangle3.isEquilateral());
            System.out.println("Is Triangle 3 Isosceles: " + triangle3.isIsosceles());
            System.out.println("Is Triangle 3 Scalene: " + triangle3.isScalene());
            System.out.println("Is Triangle 3 Right Angle: " + triangle3.isRightAngle());
            

            System.out.println();


            // Constructor with two sides
            Triangle triangle4 = new Triangle(3, 4);

            System.out.println("Triangle 4 (two sides): " + triangle4);
            System.out.println("Perimeter: " + triangle4.getPerimeter());
            System.out.println("Area: " + triangle4.getArea());
            System.out.println("Is Equilateral: " + triangle4.isEquilateral());
            System.out.println("Is Isosceles: " + triangle4.isIsosceles());
            System.out.println("Is Scalene: " + triangle4.isScalene());
            System.out.println("Is Right Angle: " + triangle4.isRightAngle());
            
            System.out.println();
            

            // Testing the static method to get object count
            System.out.println("Object Count: " + Triangle.getObjectCount());

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
