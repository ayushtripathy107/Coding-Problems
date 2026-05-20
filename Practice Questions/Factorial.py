def calculate_factorial(n):
    result = 1
    
    # range(1, n + 1) includes the number 'n' itself
    for i in range(1, n + 1):
        result = result * i
        
    return result

# Example Usage:
print(calculate_factorial(5))  # Output: 120
print(calculate_factorial(4))  # Output: 24
