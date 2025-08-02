class Triangle:

    object_count = 0 # STATIC variable to count the number of Triangle objects created

    def __init__(self, *args): 

        sides = [] # A temporary list to hold the three sides

       
        if len(args) == 0:
            # Default constructor
            sides = [1.0, 1.0, 1.0]
        
        elif len(args) == 1:
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