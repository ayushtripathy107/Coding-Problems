import math

class Solution(object):
    def sumFourDivisors(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total_sum = 0
        
        for num in nums:
            divisors = set()
            # Iterate up to the square root of the number
            for i in range(1, int(math.sqrt(num)) + 1):
                if num % i == 0:
                    divisors.add(i)
                    divisors.add(num // i)
                    # If we already have more than 4, stop early
                    if len(divisors) > 4:
                        break
            
            # Check if the number has exactly four divisors
            if len(divisors) == 4:
                total_sum += sum(divisors)
                
        return total_sum
        
