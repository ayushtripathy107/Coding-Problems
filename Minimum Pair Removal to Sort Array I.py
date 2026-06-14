class Solution(object):
    def minimumPairRemoval(self, nums):
        operations = 0
        
        while not all(nums[i] <= nums[i+1] for i in range(len(nums) - 1)):
            min_sum = float('inf')
            target_idx = -1
            
            # Find the leftmost pair with the minimum sum
            for i in range(len(nums) - 1):
                current_sum = nums[i] + nums[i+1]
                if current_sum < min_sum:
                    min_sum = current_sum
                    target_idx = i
            
            # Replace the pair with their sum
            nums = nums[:target_idx] + [min_sum] + nums[target_idx + 2:]
            operations += 1
            
        return operations
