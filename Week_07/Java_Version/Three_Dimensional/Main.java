package Week_07.Java_Version.Three_Dimensional;

public class Main {
    public static void main(String[] args) {

        // Example usage of the Vector class
        Vector3D vector1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D vector2 = new Vector3D(4.0, 5.0, 6.0);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Vector 2: " + vector2);

        // Vector addition
        Vector3D sum = vector1.ADD(vector2);
        System.out.println("Sum: " + sum);

        // Vector subtraction
        Vector3D difference = vector1.SUB(vector2);
        System.out.println("Difference: " + difference);

        // Vector length
        double length1 = vector1.LENGTH();
        System.out.println("Length of Vector 1: " + length1);
        
        double length2 = vector2.LENGTH();
        System.out.println("Length of Vector 2: " + length2);
    
        // Cross product
        Vector3D crossProduct = vector1.CROSSPRODUCT(vector2);
        System.out.println("Cross Product: " + crossProduct);

        // Dot product
        double dotProduct = vector1.DOTPRODUCT(vector2);
        System.out.println("Dot Product: " + dotProduct);

        // Cloning vector1
        Vector3D clonedVector = null;
        try {
            clonedVector = (Vector3D) vector1.clone();
            System.out.println("Cloned Vector 1: " + clonedVector);
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed for vector1.");
        }

        System.out.println();

        // Cloning vector2
        Vector3D clonedVector2 = null;
        try {
            clonedVector2 = (Vector3D) vector2.clone();
            System.out.println("Cloned Vector 2: " + clonedVector2);
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed for vector2.");
        }

        System.out.println();

        // Iterating through vector1
        System.out.print("Iterating through Vector 1: ");
        for (Double value : vector1) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Iterating through vector2
        System.out.print("Iterating through Vector 2: ");
        for (Double value : vector2) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Setting a value in vector1
        vector1.SET(0, 10.0);
        System.out.println("Vector 1 after setting index 0 to 10.0: " + vector1);

        // Setting a value in vector2
        vector2.SET(1, 20.0);
        System.out.println("Vector 2 after setting index 1 to 20.0: " + vector2);

        // Setting a value in Clone vector
        if (clonedVector != null) {
            clonedVector.SET(2, 30.0);
            System.out.println("Cloned Vector 1 after setting index 2 to 30.0: " + clonedVector);
        }

        // Setting a value in Clone vector2
        if (clonedVector2 != null) { 
            clonedVector2.SET(0, 40.0);
            System.out.println("Cloned Vector 2 after setting index 0 to 40.0: " + clonedVector2);
        }

        System.out.println();
        

        // Getting a value from vector1
        double valueAtIndex1 = vector1.GET(1);
        System.out.println("Value at index 1 of Vector 1: " + valueAtIndex1);

        // Checking equality
        boolean isEqual = vector1.equals(vector2);
        System.out.println("Vector 1 equals Vector 2: " + isEqual);

        // String representation
        System.out.println("String representation of Vector 1: " + vector1.toString());
        System.out.println("String representation of Vector 2: " + vector2.toString());
    }
}