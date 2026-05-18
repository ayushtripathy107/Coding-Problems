def count_vowels(text):
    count = 0
    vowels = "aeiou"
    
    for char in text:
        # Convert to lowercase to handle capital letters
        if char.lower() in vowels:
            count += 1
            
    return count
