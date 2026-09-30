class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int minVal = nums[0];
        int maxVal = nums[0];
        
        // Find the absolute minimum and maximum values in the array
        for (int num : nums) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }
        
        // Calculate the minimized difference
        int result = maxVal - minVal - 2 * k;
        
        // If the result is negative, return 0; otherwise, return the result
        return Math.max(0, result);
    }
}
