def remove_negatives(numbers):
    positives = []
    
    for num in numbers:
        if num >= 0:
            positives.append(num)
            
    return positives

# Example Usage:
mixed_list = [10, -5, 3, -1, 0, 7]
print(remove_negatives(mixed_list))  # Output: [10, 3, 0, 7]
