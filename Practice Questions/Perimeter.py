# --- Square ---
s = float(input("Enter the side length of the square: "))
perimeter_square = 4 * s
print(f"The perimeter of the square is: {perimeter_square}\n")

# --- Rectangle ---
l = float(input("Enter the length of the rectangle: "))
w = float(input("Enter the width of the rectangle: "))
perimeter_rectangle = 2 * (l + w)
print(f"The perimeter of the rectangle is: {perimeter_rectangle}\n")

# --- Triangle ---
a = float(input("Enter the length of the first side of the triangle: "))
b = float(input("Enter the length of the second side of the triangle: "))
c = float(input("Enter the length of the third side of the triangle: "))
perimeter_triangle = a + b + c
print(f"The perimeter of the triangle is: {perimeter_triangle}")
