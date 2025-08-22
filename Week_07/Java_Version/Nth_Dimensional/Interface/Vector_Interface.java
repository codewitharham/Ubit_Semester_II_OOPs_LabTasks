package Week_07.Java_Version.Nth_Dimensional.Interface;

import Week_07.Java_Version.Nth_Dimensional.Vector;

public interface Vector_Interface {

    double GET(int index); // Get value at index

    void SET(int index, double value); // Set value at index and return old value

    double LENGTH(); // Magnitude of the vector

    Vector ADD(Vector otherVector); // Vector addition

    Vector SUB(Vector otherVector); // Vector subtraction

    Vector CROSSPRODUCT(Vector otherVector); // Cross product with another vector

    double DOTPRODUCT(Vector otherVector); // Dot product with another vector`

    @Override
    String toString(); // String representation of the vector

    @Override
    boolean equals(Object obj); // Check equality with another object
    
}
