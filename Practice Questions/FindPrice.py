def get_price(item_name):
    grocery_store = {
        "apple": 0.99,
        "banana": 0.59,
        "milk": 2.49,
        "bread": 1.99
    }
    
    # .get() takes the key to search, and a default value if not found
    return grocery_store.get(item_name.lower(), "Not in stock")

# Example Usage:
print(get_price("banana"))  # Output: 0.59
print(get_price("cookie"))  # Output: Not in stock
