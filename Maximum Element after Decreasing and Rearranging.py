class Solution(object):
    def maximumElementAfterDecrementingAndRearranging(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        # Step 1: Sort the array to make it easier to satisfy the difference condition
        arr.sort()
        
        # Step 2: The first element must be 1
        arr[0] = 1
        
        # Step 3: Iterate and ensure no adjacent elements have a difference > 1
        for i in range(1, len(arr)):
            # The current element can be at most 1 greater than the previous one
            if arr[i] > arr[i - 1] + 1:
                arr[i] = arr[i - 1] + 1
        
        # Step 4: The last element will be the maximum possible value
        return arr[-1]
