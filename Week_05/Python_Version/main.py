from Class.Triangle import Triangle

if __name__ == "__main__":
    try:
        # Testing various constructors and methods

        # Default constructor (0 arguments)
        triangle_default = Triangle()
        
        print("Default Triangle:", triangle_default)
        print("Perimeter:", triangle_default.getPerimeter())
        print("Area:", triangle_default.getArea())
        print("Is Equilateral:", triangle_default.isEquilateral())
        print("Is Isosceles:", triangle_default.isIsosceles())
        print("Is Scalene:", triangle_default.isScalene())
        print("Is Right Angle:", triangle_default.isRightAngled())
        
        print()

        # Three-parameter constructor
        triangle1 = Triangle(3, 4, 5)
        
        print("Triangle 1:", triangle1)
        print("Perimeter:", triangle1.getPerimeter())
        print("Area:", triangle1.getArea())
        print("Is Equilateral:", triangle1.isEquilateral())
        print("Is Isosceles:", triangle1.isIsosceles())
        print("Is Scalene:", triangle1.isScalene())
        print("Is Right Angle:", triangle1.isRightAngled())
        
        print()

        # One-parameter constructor
        triangle2 = Triangle(5)

        print("Triangle 2:", triangle2)
        print("Perimeter:", triangle2.getPerimeter())
        print("Area:", triangle2.getArea())
        print("Is Equilateral:", triangle2.isEquilateral())
        print("Is Isosceles:", triangle2.isIsosceles())
        print("Is Scalene:", triangle2.isScalene())
        print("Is Right Angle:", triangle2.isRightAngled())
        
        print()

        # Testing the copy constructor
        triangle3 = Triangle(triangle1)
        
        print("Triangle 3 (copy of Triangle 1):", triangle3)
        print("Area of Triangle 3:", triangle3.getArea())
        print("Perimeter of Triangle 3:", triangle3.getPerimeter())
        print("Is Triangle 3 Right Angle:", triangle3.isRightAngled())
        print("Is Triangle 3 Equilateral:", triangle3.isEquilateral())
        print("Is Triangle 3 Isosceles:", triangle3.isIsosceles())
        print("Is Triangle 3 Scalene:", triangle3.isScalene())
        
        
        print()

        # Two-parameter constructor
        triangle4 = Triangle(3, 4)

        print("Triangle 4:", triangle4)
        print("Perimeter:", triangle4.getPerimeter())
        print("Area:", triangle4.getArea())
        print("Is Equilateral:", triangle4.isEquilateral())
        print("Is Isosceles:", triangle4.isIsosceles())
        print("Is Scalene:", triangle4.isScalene())
        print("Is Right Angle:", triangle4.isRightAngled())
        
        print()

        # validating triangle sides
        try:
            triangle_invalid = Triangle(1, 2, 3)
            print("Invalid Triangle:", triangle_invalid)
        except ValueError as e:
            
            print("Error:", e)

        # Testing the class method to get object count
        print("Object Count:", Triangle.get_object_count())

    except ValueError as e:
        print(e)
