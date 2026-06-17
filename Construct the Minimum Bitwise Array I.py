class Solution(object):
    def minBitwiseArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for n in nums:
            # If the prime is 2, no x exists such that x | (x + 1) = 2.
            # (Because x | (x + 1) is always odd for x >= 0).
            if n == 2:
                ans.append(-1)
                continue
            
            # For other odd primes, we find the lowest unset bit in n.
            # To minimize x such that x | (x + 1) = n, we change the
            # rightmost contiguous sequence of '1's into '0' for only the
            # last bit of that sequence.
            # Example: 13 (1101) -> 12 (1100). 12 | 13 = 13.
            # Example: 7 (111) -> 3 (011). 3 | 4 = 7.
            
            for i in range(31):
                # Check if the i-th bit is 0
                if not (n & (1 << i)):
                    # The bit we want to flip is the one before the first 0 (i-1)
                    ans.append(n ^ (1 << (i - 1)))
                    break
        return ans
