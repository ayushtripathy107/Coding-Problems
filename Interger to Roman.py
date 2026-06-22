class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # Mapping of Roman symbols to their integer values in descending order
        # Includes subtractive cases as per the rules provided
        val_map = [
            (1000, "M"), (900, "CM"), (500, "D"), (400, "CD"),
            (100, "C"), (90, "XC"), (50, "L"), (40, "XL"),
            (10, "X"), (9, "IX"), (5, "V"), (4, "IV"),
            (1, "I")
        ]
        
        roman_num = ""
        
        for value, symbol in val_map:
            # While the remaining num is greater than or equal to the current value
            while num >= value:
                roman_num += symbol
                num -= value
        
        return roman_num
