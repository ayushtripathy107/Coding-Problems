class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 1. Remove duplicates using a set
        unique_nums = sorted(list(set(nums)), reverse=True)
        
        # 2. Check if the third maximum exists
        if len(unique_nums) >= 3:
            return unique_nums[2]
        
        # 3. Otherwise, return the maximum
        return unique_nums[0]
