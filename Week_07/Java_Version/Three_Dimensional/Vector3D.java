package Week_07.Java_Version.Three_Dimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import Week_07.Java_Version.Three_Dimensional.Interface.Vector_Interface_3D;

public class Vector3D implements Vector_Interface_3D, Iterable<Double>, Cloneable {

    private ArrayList<Double> vectorList;

    public Vector3D(double x, double y, double z) {
        this.vectorList = new ArrayList<>(Arrays.asList(x, y, z));
    }

    public Vector3D() {
        this(0.0, 0.0, 0.0);
    }

    public Vector3D(double value) {
        this(value, value, value);
    }

    public Vector3D(Vector3D other) {
        this.vectorList = new ArrayList<>(other.vectorList);
    }

    @Override
    public void SET(int index, double value) {
        if (index >= 0 && index < vectorList.size()) {
            vectorList.set(index, value);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for vector.");
        }
    }

    @Override
    public double LENGTH() {
        double x = vectorList.get(0);
        double y = vectorList.get(1);
        double z = vectorList.get(2);
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double GET(int index) {
        if (index >= 0 && index < vectorList.size()) {
            return vectorList.get(index);
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for vector.");
    }

   

    @Override
    public Vector3D ADD(Vector3D otherVector) {
        double newX = this.vectorList.get(0) + otherVector.vectorList.get(0);
        double newY = this.vectorList.get(1) + otherVector.vectorList.get(1);
        double newZ = this.vectorList.get(2) + otherVector.vectorList.get(2);
        return new Vector3D(newX, newY, newZ);
    }

    @Override
    public Vector3D SUB(Vector3D otherVector) {
        double newX = this.vectorList.get(0) - otherVector.vectorList.get(0);
        double newY = this.vectorList.get(1) - otherVector.vectorList.get(1);
        double newZ = this.vectorList.get(2) - otherVector.vectorList.get(2);
        return new Vector3D(newX, newY, newZ);
    }

    @Override
    public Vector3D CROSSPRODUCT(Vector3D otherVector) {
        double x1 = this.vectorList.get(0);
        double y1 = this.vectorList.get(1);
        double z1 = this.vectorList.get(2);
        double x2 = otherVector.vectorList.get(0);
        double y2 = otherVector.vectorList.get(1);
        double z2 = otherVector.vectorList.get(2);

        double newX = y1 * z2 - z1 * y2;
        double newY = z1 * x2 - x1 * z2;
        double newZ = x1 * y2 - y1 * x2;

        return new Vector3D(newX, newY, newZ);
    }

    @Override
    public double DOTPRODUCT(Vector3D otherVector) {
        double x1 = this.vectorList.get(0);
        double y1 = this.vectorList.get(1);
        double z1 = this.vectorList.get(2);
        double x2 = otherVector.vectorList.get(0);
        double y2 = otherVector.vectorList.get(1);
        double z2 = otherVector.vectorList.get(2);
        
        double newX = x1 * x2;
        double newY = y1 * y2;
        double newZ = z1 * z2;

        return (newX + newY + newZ);

    }


    @Override
    public Iterator<Double> iterator() {
        return vectorList.iterator();
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        Vector3D cloned = (Vector3D) super.clone(); // Shallow copy
        cloned.vectorList = new ArrayList<>(this.vectorList); // Deep copy of the list
        return cloned;
    }
    


    @Override
    public String toString() {
        return "Vector(" + vectorList.get(0) + ", " + vectorList.get(1) + ", " + vectorList.get(2) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vector3D other = (Vector3D) obj;
        double epsilon = 1e-9; // Tolerance for floating-point comparison
        return Math.abs(this.vectorList.get(0) - other.vectorList.get(0)) < epsilon && // Compare x-coordinates
               Math.abs(this.vectorList.get(1) - other.vectorList.get(1)) < epsilon && // Compare y-coordinates
               Math.abs(this.vectorList.get(2) - other.vectorList.get(2)) < epsilon; // Compare z-coordinates
               //  If all coordinates are approximately equal, the vectors are considered equal
               // This accounts for potential floating-point precision issues
               // For example, 0.1 + 0.2 might not exactly equal 0.3 due to how floating-point numbers are represented in memory
               // Using a small epsilon value allows us to treat values that are very close as equal
               // This is especially important in applications like graphics or physics simulations where precision is crucial
               // However, the choice of epsilon should be made based on the specific requirements of the application
               // A smaller epsilon means stricter equality, while a larger epsilon allows for more tolerance
               // In this case, 1e-9 is a common choice for many applications
    }
}