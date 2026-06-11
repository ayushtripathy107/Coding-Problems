class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            # This operation clears the least significant set bit
            n &= (n - 1)
            count += 1
        return count
