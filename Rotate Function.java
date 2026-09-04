class Solution(object):
    def maxRotateFunction(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        # Calculate the initial sum of the array elements
        total_sum = sum(nums)
        
        # Calculate F(0)
        current_f = sum(i * val for i, val in enumerate(nums))
        
        # Maintain the maximum value found so far
        max_f = current_f
        
        # Iteratively calculate F(1) to F(n-1) using the O(1) transition formula
        for k in range(1, n):
            current_f = current_f + total_sum - n * nums[n - k]
            if current_f > max_f:
                max_f = current_f
                
        return max_f
