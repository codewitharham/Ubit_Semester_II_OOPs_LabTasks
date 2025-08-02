class Triangle:

    object_count = 0 # STATIC variable to count the number of Triangle objects created

    def __init__(self, *args): 

        sides = [] # A temporary list to hold the three sides

       
        if len(args) == 0:
            # Default constructor
            sides = [1.0, 1.0, 1.0]
        
        elif len(args) == 1:

            # Check for copy constructor
            if isinstance(args[0], Triangle):
                other = args[0]
                sides = [other.__side1, other.__side2, other.__side3]

            else:
                # One-parameter constructor
                if args[0] <= 0:
                    raise ValueError("Sides must be positive numbers.")
            
                sides = [args[0], args[0], args[0]]
            
        
        elif len(args) == 2:
            # Two-parameter constructor
            if ((args[0] <= 0) or (args[1] <= 0)):
                raise ValueError("Sides must be positive numbers.")
            
            sides = [args[0], args[0], args[1]]
        
        elif len(args) == 3:
            # Three-parameter constructor
            if (args[0] <= 0 or args[1] <= 0 or args[2] <= 0):
                raise ValueError("Sides must be positive numbers.")
            
            sides = list(args)
        
        else:
            raise ValueError("Triangle constructor requires 0, 1, 2, or 3 arguments.")
         
        
            
        # Triangle Inequality Theorem
        sorted_sides = sorted(sides)
        if sorted_sides[0] + sorted_sides[1] <= sorted_sides[2]:
            raise ValueError("The sum of any two sides must be greater than the third side.")
            
        # assignment to instance variables
        self.__side1 = sorted_sides[0]
        self.__side2 = sorted_sides[1]
        self.__side3 = sorted_sides[2]

        # Increment the object count for each successful creation
        Triangle.object_count += 1


    def __str__(self):
        return "Triangle { side1: " + str(self.__side1) + ", side2: " + str(self.__side2) + ", side3: " + str(self.__side3) + " }  "
    
    
    @property
    def side1(self):
        return self.__side1
    
    @property
    def side2(self):
        return self.__side2
    
    @property
    def side3(self):
        return self.__side3
    
    @classmethod
    def get_object_count(cls):
        return cls.object_count
    
    def validate_triangle(self):
        """Validates the triangle using the Triangle Inequality Theorem."""
        sorted_sides = sorted([self.__side1, self.__side2, self.__side3])
        if sorted_sides[0] + sorted_sides[1] <= sorted_sides[2]:
            raise ValueError("The sum of any two sides must be greater than the third side.")

    @side1.setter
    def side1(self, value):
        if value <= 0:
            raise ValueError("Side must be a positive number.")
        self.__side1 = value
        self.validate_triangle()

    @side2.setter
    def side2(self, value):
        if value <= 0:
            raise ValueError("Side must be a positive number.")
        self.__side2 = value
        self.validate_triangle()

    @side3.setter
    def side3(self, value):
        if value <= 0:
            raise ValueError("Side must be a positive number.")
        self.__side3 = value
        self.validate_triangle()

    def getPerimeter(self):
        return self.__side1 + self.__side2 + self.__side3
    
    def getArea(self):
        
        # Using Heron's formula to calculate the area of the triangle
        # Area = sqrt(s * (s - a) * (s - b) * (s - c))
        # where s is the semi-perimeter: s = (a + b + c)  / 2

        s = self.getPerimeter() / 2
        area = (s * (s - self.__side1) * (s - self.__side2) * (s - self.__side3)) ** 0.5
        return area
    

    def isEquilateral(self):

        return (self.__side1 == self.__side2) and (self.__side2 == self.__side3) and (self.__side1 == self.__side3)
    
    def isIsosceles(self):
        if self.isEquilateral():
            return False
        return (self.__side1 == self.__side2) or (self.__side2 == self.__side3) or (self.__side1 == self.__side3)
    
    def isScalene(self):
        return not (self.isEquilateral() or self.isIsosceles())
    
    def isRightAngled(self):
        # Check if the triangle is right-angled using the Pythagorean theorem
        sides = sorted([self.__side1, self.__side2, self.__side3])
        
        result = ( sides[0]**2 + sides[1]**2 == sides[2]**2 )

        return result
    
    
        