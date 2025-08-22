package Week_07.Java_Version.Three_Dimensional.Interface;

import Week_07.Java_Version.Three_Dimensional.Vector3D;

public interface Vector_Interface_3D {
    
    double GET(int index); // Get value at index

    void SET(int index, double value); // Set value at index and return old value

    double LENGTH(); // Magnitude of the vector

    Vector3D ADD(Vector3D otherVector); // Vector addition

    Vector3D SUB(Vector3D otherVector); // Vector subtraction

    Vector3D CROSSPRODUCT(Vector3D otherVector); // Cross product with another vector

    double DOTPRODUCT(Vector3D otherVector); // Dot product with another vector`

    @Override
    String toString(); // String representation of the vector

    @Override
    boolean equals(Object obj); // Check equality with another object

    
}
