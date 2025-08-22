import math
import copy

class Vector:
    """
    Represents a mathematical n-dimensional vector.

    This class provides methods for common vector operations such as addition,
    subtraction, dot product, cross product, magnitude, and normalization.
    """

    def __init__(self, *args) -> None:
        """
        Initializes a new Vector object.

        This single constructor handles multiple initialization patterns:
        - Vector(dimension): Creates a zero vector of the given dimension.
        - Vector(value1, value2, ...): Creates a vector from a variable number of arguments.
        - Vector([value1, value2, ...]): Creates a vector from a list or tuple.
        - Vector(other_vector): Creates a deep copy of another vector.
        """
        self.vector_data = []

        if len(args) == 0:
            # Default constructor: Creates a 0D vector.
            pass
        elif len(args) == 1:
            arg = args[0]
            if isinstance(arg, int):
                # Creates a zero vector of a specific dimension.
                if arg < 0:
                    raise ValueError("Dimension cannot be negative.")
                self.vector_data = [0.0] * arg
            elif isinstance(arg, (list, tuple)):
                # Creates a vector from a list or tuple.
                self.vector_data = [float(x) for x in arg]
            elif isinstance(arg, Vector):
                # Copy constructor: Creates a deep copy of another Vector.
                self.vector_data = copy.deepcopy(arg.vector_data)
            else:
                # Creates a vector of a single value.
                self.vector_data = [float(arg)]
        else:
            # Creates a vector from a variable number of arguments.
            self.vector_data = [float(x) for x in args]

    def get_dimension(self) -> int:
        """
        Returns the number of dimensions of the vector.
        """
        return len(self.vector_data)

    def get(self, index: int) -> float:
        """
        Gets the component at a specified index.
        """
        if index < 0 or index >= len(self.vector_data):
            raise IndexError(f"Index {index} is out of bounds for vector of dimension {self.get_dimension()}.")
        return self.vector_data[index]

    def set(self, index: int, value: float) -> None:
        """
        Sets the component at a specified index to a new value.
        """
        if index < 0 or index >= len(self.vector_data):
            raise IndexError(f"Index {index} is out of bounds for vector of dimension {self.get_dimension()}.")
        self.vector_data[index] = value

    def magnitude(self) -> float:
        """
        Calculates the magnitude (length) of the vector.
        """
        sum_of_squares = sum(x ** 2 for x in self.vector_data)
        return math.sqrt(sum_of_squares)

    def dot_product(self, other_vector: 'Vector') -> float:
        """
        Calculates the dot product of two vectors.
        """
        if self.get_dimension() != other_vector.get_dimension():
            raise ValueError("Vectors must have the same dimension for dot product.")

        dot_product = sum(a * b for a, b in zip(self.vector_data, other_vector.vector_data))
        return dot_product

    def cross_product(self, other_vector: 'Vector') -> 'Vector':
        """
        Calculates the cross product of two 3-dimensional vectors.
        """
        if self.get_dimension() != 3 or other_vector.get_dimension() != 3:
            raise TypeError("Cross product is only defined for 3-dimensional vectors.")

        x1, y1, z1 = self.vector_data
        x2, y2, z2 = other_vector.vector_data

        new_x = y1 * z2 - z1 * y2
        new_y = z1 * x2 - x1 * z2
        new_z = x1 * y2 - y1 * x2

        return Vector(new_x, new_y, new_z)

    def normalize(self) -> 'Vector':
        """
        Returns a new vector that is the normalized version (unit vector) of the original.
        """
        magnitude = self.magnitude()
        if magnitude == 0:
            raise ValueError("Cannot normalize a zero vector.")
        
        return self * (1.0 / magnitude)

    def copy(self) -> 'Vector':
        """
        Returns a deep copy of the vector.
        """
        return Vector(self)

    # Dunder methods for Python operator overloading and features

    def __str__(self) -> str:
        """
        Returns a string representation of the vector.
        Example: "Vector(1.0, 2.0, 3.0)"
        """
        return f"Vector({', '.join(str(x) for x in self.vector_data)})"

    def __repr__(self) -> str:
        """
        Returns a developer-friendly string representation.
        """
        return self.__str__()

    def __add__(self, other_vector: 'Vector') -> 'Vector':
        """
        Overloads the '+' operator for vector addition.
        """
        if self.get_dimension() != other_vector.get_dimension():
            raise ValueError("Vectors must have the same dimension for addition.")

        result_data = [a + b for a, b in zip(self.vector_data, other_vector.vector_data)]
        return Vector(result_data)

    def __sub__(self, other_vector: 'Vector') -> 'Vector':
        """
        Overloads the '-' operator for vector subtraction.
        """
        if self.get_dimension() != other_vector.get_dimension():
            raise ValueError("Vectors must have the same dimension for subtraction.")

        result_data = [a - b for a, b in zip(self.vector_data, other_vector.vector_data)]
        return Vector(result_data)

    def __mul__(self, scalar: float) -> 'Vector':
        """
        Overloads the '*' operator for scalar multiplication.
        """
        result_data = [x * scalar for x in self.vector_data]
        return Vector(result_data)

    def __rmul__(self, scalar: float) -> 'Vector':
        """
        Handles scalar multiplication when the scalar is on the left.
        Example: 5 * my_vector
        """
        return self.__mul__(scalar)

    def __truediv__(self, scalar: float) -> 'Vector':
        """
        Overloads the '/' operator for scalar division.
        """
        if scalar == 0:
            raise ZeroDivisionError("Cannot divide a vector by zero.")
        result_data = [x / scalar for x in self.vector_data]
        return Vector(result_data)

    def __getitem__(self, index: int) -> float:
        """
        Enables accessing vector components using bracket notation (e.g., my_vector[0]).
        """
        return self.get(index)

    def __setitem__(self, index: int, value: float) -> None:
        """
        Enables setting vector components using bracket notation (e.g., my_vector[0] = 5).
        """
        self.set(index, value)

    def __iter__(self):
        """
        Enables iterating over the vector components.
        """
        return iter(self.vector_data)

    def __eq__(self, other: object) -> bool:
        """
        Overloads the '==' operator for vector equality comparison.
        Compares vectors for equality using a tolerance for floating-point numbers.
        """
        if not isinstance(other, Vector):
            return NotImplemented

        if self.get_dimension() != other.get_dimension():
            return False

        for a, b in zip(self.vector_data, other.vector_data):
            if not math.isclose(a, b):
                return False
        return True

    def __len__(self) -> int:
        """
        Returns the number of dimensions.
        """
        return self.get_dimension()