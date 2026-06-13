class Solution(object):
    def divide(self, dividend, divisor):
        # 1. Handle overflow for 32-bit signed integers
        MAX_INT = 2**31 - 1
        MIN_INT = -2**31
        
        if dividend == MIN_INT and divisor == -1:
            return MAX_INT
        
        # 2. Determine the sign of the result
        negative = (dividend < 0) != (divisor < 0)
        
        # 3. Work with absolute values
        dividend, divisor = abs(dividend), abs(divisor)
        quotient = 0
        
        # 4. Use bit shifting to subtract multiples of divisor
        while dividend >= divisor:
            temp_divisor, multiple = divisor, 1
            # Double the divisor until it's larger than the dividend
            while dividend >= (temp_divisor << 1):
                temp_divisor <<= 1
                multiple <<= 1
            
            # Subtract the largest found multiple
            dividend -= temp_divisor
            quotient += multiple
            
        return -quotient if negative else quotient
