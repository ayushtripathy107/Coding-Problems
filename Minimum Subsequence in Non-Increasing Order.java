import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        Arrays.sort(nums);
        
        List<Integer> result = new ArrayList<>();
        int currentSum = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.add(nums[i]);
            
            if (currentSum > totalSum - currentSum) {
                break;
            }
        }
        
        return result;
    }
}
