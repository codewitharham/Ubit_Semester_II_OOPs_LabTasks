from Class.Vector import Vector

# Example Usage:
if __name__ == '__main__':
    print("--- Demonstrating Python Vector Class ---")
    
    # Constructors
    v_zero = Vector(4)
    print(f"Zero Vector (4D): {v_zero}")

    v_from_list = Vector([1.0, 2.0, 3.0])
    print(f"Vector from list: {v_from_list}")

    v_from_args = Vector(4.0, 5.0, 6.0)
    print(f"Vector from args: {v_from_args}")

    v_copy = v_from_args.copy()
    print(f"Vector copy: {v_copy}")

    # Vector Operations
    v1 = Vector(1, 2, 3)
    v2 = Vector(4, 5, 6)

    v_sum = v1 + v2
    print(f"Sum: {v1} + {v2} = {v_sum}")

    v_diff = v1 - v2
    print(f"Difference: {v1} - {v2} = {v_diff}")

    v_scaled = v1 * 2.5
    print(f"Scaled by 2.5: {v1} * 2.5 = {v_scaled}")
    
    v_dot = v1.dot_product(v2)
    print(f"Dot Product: {v1}.dot({v2}) = {v_dot}")

    v_mag = v1.magnitude()
    print(f"Magnitude: |{v1}| = {v_mag}")

    v_norm = v1.normalize()
    print(f"Normalized: {v_norm}")
    print(f"Magnitude of normalized vector: {v_norm.magnitude()}")
    
    # Cross Product (3D only)
    v3 = Vector(1, 0, 0)
    v4 = Vector(0, 1, 0)
    v_cross = v3.cross_product(v4)
    print(f"Cross Product: {v3} x {v4} = {v_cross}")
    
    # Equality check
    v_equal = Vector(1.0000000001, 2, 3)
    v_original = Vector(1, 2, 3)
    print(f"Is {v_equal} == {v_original}? {v_equal == v_original}")
    
    # Exception handling
    try:
        v_sum_error = v_from_list + v_zero
    except ValueError as e:
        print(f"Caught expected error: {e}")
