def is_armstrong(num):
    # Convert to string to find the number of digits (order)
    order = len(str(num))
    
    # Initialize sum and temporary variable
    temp_sum = 0
    temp_num = num
    
    while temp_num > 0:
        # Extract the last digit
        digit = temp_num % 10
        # Raise digit to the power of order and add to sum
        temp_sum += digit ** order
        # Remove the last digit
        temp_num //= 10
        
    return temp_sum == num

# Test the function
number = int(input("Enter a number: "))
if is_armstrong(number):
    print(f"{number} is an Armstrong number")
else:
    print(f"{number} is not an Armstrong number")
