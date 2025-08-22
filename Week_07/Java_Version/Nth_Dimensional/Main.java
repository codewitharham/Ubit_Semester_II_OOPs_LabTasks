package Week_07.Java_Version.Nth_Dimensional;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Demonstrating N-Dimensional Vector Class ---");

        // Section 1: Constructors and Basic Information
        System.out.println("\nSection 1: Constructors and Basic Information");
        // Create a 4-dimensional vector with all components initialized to zero.
        Vector v1 = new Vector(4);
        System.out.println("Created a 4D vector v1: " + v1);
        System.out.println("Dimension of v1: " + v1.getDimension());

        // Create a 2-dimensional vector using the varargs constructor.
        Vector v2 = new Vector(5.0, -1.5);
        System.out.println("Created a 2D vector v2: " + v2);
        System.out.println("Dimension of v2: " + v2.getDimension());

        // Create a copy of v2 to demonstrate the copy constructor.
        Vector v2_copy = new Vector(v2);
        System.out.println("Created a deep copy v2_copy: " + v2_copy);
        System.out.println("Is v2 equal to v2_copy? " + v2.equals(v2_copy));

        System.out.println("\n------------------------------------------------");

        // Section 2: Vector Arithmetic
        System.out.println("Section 2: Vector Arithmetic");
        Vector a = new Vector(1.0, 2.0, 3.0);
        Vector b = new Vector(4.0, 5.0, 6.0);

        // Addition
        Vector sum = a.ADD(b);
        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);
        System.out.println("a + b = " + sum);

        // Subtraction
        Vector difference = a.SUB(b);
        System.out.println("a - b = " + difference);

        System.out.println("\n------------------------------------------------");

        // Section 3: Vector Products and Length
        System.out.println("Section 3: Vector Products and Length");
        
        // Dot product
        double dotProduct = a.DOTPRODUCT(b);
        System.out.println("Dot product of a and b: " + dotProduct);
        
        // Cross product (only defined for 3D vectors)
        try {
            Vector crossProduct = a.CROSSPRODUCT(b);
            System.out.println("Cross product of a and b: " + crossProduct);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Length
        double length_a = a.LENGTH();
        System.out.println("Length of a: " + length_a);

        System.out.println("\n------------------------------------------------");

        // Section 4: Accessors and Mutators
        System.out.println("Section 4: Accessors and Mutators");
        Vector c = new Vector(10.0, 20.0, 30.0, 40.0);
        System.out.println("Vector c before modification: " + c);

        // Set a value at a specific index.
        c.SET(2, 99.9);
        System.out.println("Vector c after SET(2, 99.9): " + c);

        // Get a value at a specific index.
        double valueAtIndex1 = c.GET(1);
        System.out.println("Value at index 1 of c: " + valueAtIndex1);

        System.out.println("\n------------------------------------------------");

        // Section 5: Iteration and Cloning
        System.out.println("Section 5: Iteration and Cloning");
        System.out.print("Iterating through vector a: ");
        for (Double value : a) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Clone vector a
        try {
            Vector cloned_a = (Vector) a.clone();
            System.out.println("Cloned vector a: " + cloned_a);
            System.out.println("Is cloned_a equal to a? " + cloned_a.equals(a));
            // Modify the clone to show it's a deep copy.
            cloned_a.SET(0, -100.0);
            System.out.println("Modified cloned_a: " + cloned_a);
            System.out.println("Original vector a is unchanged: " + a);
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed: " + e.getMessage());
        }
        
        System.out.println("\n------------------------------------------------");
        
        // Section 6: Exception Handling for Mismatched Dimensions
        System.out.println("Section 6: Exception Handling for Mismatched Dimensions");
        Vector d = new Vector(1.0, 2.0); // 2D vector
        Vector e = new Vector(1.0, 2.0, 3.0); // 3D vector

        try {
            // This will throw an exception because the dimensions don't match.
            d.ADD(e);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught an exception when adding mismatched vectors: " + ex.getMessage());
        }
        
        try {
            // This will also throw an exception for the same reason.
            e.DOTPRODUCT(d);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught an exception for dot product with mismatched vectors: " + ex.getMessage());
        }

        try {
            // This will throw an exception because the cross product is only defined for 3D vectors.
            d.CROSSPRODUCT(d);
        } catch (UnsupportedOperationException ex) {
            System.out.println("Caught an exception for cross product on a 2D vector: " + ex.getMessage());
        }
    }
}
