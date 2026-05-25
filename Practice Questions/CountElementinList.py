def count_occurrences(my_list, target):
    count = 0
    for item in my_list:
        if item == target:
            count += 1
    return count

# Example Usage:
animals = ["cat", "dog", "cat", "bird", "cat"]
print(count_occurrences(animals, "cat"))  # Output: 3
