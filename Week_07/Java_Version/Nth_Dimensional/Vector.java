package Week_07.Java_Version.Nth_Dimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import Week_07.Java_Version.Nth_Dimensional.Interface.Vector_Interface;

public class Vector implements Vector_Interface, Iterable<Double>, Cloneable {

    // Using a List to represent an n-dimensional vector.
    // This allows the vector to have any number of components (n),
    // unlike a fixed-size array which would be limited to 3 dimensions.
    private List<Double> vectorData;

    // A constructor for creating a vector of a specific dimension,
    // initialized with all components set to zero.
    public Vector(int dimension) {
        if (dimension < 0) {
            throw new IllegalArgumentException("Dimension cannot be negative.");
        }
        this.vectorData = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            this.vectorData.add(0.0);
        }
    }

    // Constructor to initialize a vector from an array of doubles.
    // This provides a flexible way to create vectors of various dimensions.
    public Vector(double... data) {
        this.vectorData = new ArrayList<>();
        for (double value : data) {
            this.vectorData.add(value);
        }
    }

    // A copy constructor for creating a new Vector object
    // that is a deep copy of another Vector. This prevents
    // accidental modification of the original vector.
    public Vector(Vector other) {
        this.vectorData = new ArrayList<>(other.vectorData);
    }

    // Returns the number of dimensions of the vector.
    public int getDimension() {
        return vectorData.size();
    }

    @Override
    public double GET(int index) {
        if (index < 0 || index >= vectorData.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for vector of dimension " + getDimension() + ".");
        }
        return vectorData.get(index);
    }

    @Override
    public void SET(int index, double value) {
        if (index < 0 || index >= vectorData.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for vector of dimension " + getDimension() + ".");
        }
        vectorData.set(index, value);
    }

    @Override
    public double LENGTH() {
        double sumOfSquares = 0.0;
        // The length is calculated using the generalized Pythagorean theorem:
        // sum of the squares of all components.
        for (double component : vectorData) {
            sumOfSquares += component * component;
        }
        return Math.sqrt(sumOfSquares);
    }

    @Override
    public Vector ADD(Vector otherVector) {
        // We must ensure that both vectors have the same number of dimensions
        // to perform a valid addition.
        if (this.getDimension() != otherVector.getDimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension to be added.");
        }

        Vector result = new Vector(this.getDimension());
        for (int i = 0; i < this.getDimension(); i++) {
            result.SET(i, this.GET(i) + otherVector.GET(i));
        }
        return result;
    }

    @Override
    public Vector SUB(Vector otherVector) {
        // Similar to addition, subtraction also requires that both vectors
        // have the same number of dimensions.
        if (this.getDimension() != otherVector.getDimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension to be subtracted.");
        }

        Vector result = new Vector(this.getDimension());
        for (int i = 0; i < this.getDimension(); i++) {
            result.SET(i, this.GET(i) - otherVector.GET(i));
        }
        return result;
    }

    @Override
    public Vector CROSSPRODUCT(Vector otherVector) {
        // The cross product is only defined for 3-dimensional vectors.
        if (this.getDimension() != 3 || otherVector.getDimension() != 3) {
            throw new UnsupportedOperationException("Cross product is only defined for 3-dimensional vectors.");
        }

        double x1 = this.GET(0), y1 = this.GET(1), z1 = this.GET(2);
        double x2 = otherVector.GET(0), y2 = otherVector.GET(1), z2 = otherVector.GET(2);

        double newX = y1 * z2 - z1 * y2;
        double newY = z1 * x2 - x1 * z2;
        double newZ = x1 * y2 - y1 * x2;

        return new Vector(newX, newY, newZ);
    }

    @Override
    public double DOTPRODUCT(Vector otherVector) {
        if (this.getDimension() != otherVector.getDimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension for dot product.");
        }

        double dotProduct = 0.0;
        // The dot product is the sum of the products of corresponding components.
        // This loop works for any number of dimensions.
        for (int i = 0; i < this.getDimension(); i++) {
            dotProduct += this.GET(i) * otherVector.GET(i);
        }
        return dotProduct;
    }

    // A method to scale a vector by a scalar value.
    public Vector scale(double scalar) {
        Vector scaledVector = new Vector(this.getDimension());
        for (int i = 0; i < this.getDimension(); i++) {
            scaledVector.SET(i, this.GET(i) * scalar);
        }
        return scaledVector;
    }

    // This method returns a new vector that is the normalized version (unit vector)
    // of the original.
    public Vector normalize() {
        double length = this.LENGTH();
        if (length == 0) {
            // A zero vector cannot be normalized.
            throw new UnsupportedOperationException("Cannot normalize a zero vector.");
        }
        return this.scale(1.0 / length);
    }

    @Override
    public Iterator<Double> iterator() {
        return vectorData.iterator();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // The `super.clone()` performs a shallow copy.
        Vector cloned = (Vector) super.clone();
        // We then perform a deep copy of the `vectorData` list
        // to ensure the new vector is independent of the original.
        cloned.vectorData = new ArrayList<>(this.vectorData);
        return cloned;
    }

    @Override
    public String toString() {
        return "Vector(" + vectorData.toString().substring(1, vectorData.toString().length() - 1) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vector other = (Vector) obj;
        
        // Vectors of different dimensions cannot be equal.
        if (this.getDimension() != other.getDimension()) {
            return false;
        }

        // Using a tolerance (epsilon) is essential for comparing floating-point numbers.
        double epsilon = 1e-9;
        for (int i = 0; i < this.getDimension(); i++) {
            if (Math.abs(this.GET(i) - other.GET(i)) > epsilon) {
                return false;
            }
        }
        return true;
    }
}