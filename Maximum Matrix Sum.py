class Solution(object):
    def maxMatrixSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        total_sum = 0
        min_abs_val = float('inf')
        negative_count = 0
        
        for row in matrix:
            for val in row:
                total_sum += abs(val)
                if val < 0:
                    negative_count += 1
                if abs(val) < min_abs_val:
                    min_abs_val = abs(val)
        
        # If count of negatives is odd, subtract twice the smallest element
        # (Once to remove it from the total_sum, once to make it negative)
        if negative_count % 2 == 1:
            return total_sum - 2 * min_abs_val
            
        return total_sum
