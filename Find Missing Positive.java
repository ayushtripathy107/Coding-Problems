class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each number in its correct position (nums[i] should be at nums[i] - 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find the first index where the number is not correct
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all numbers 1 to n are in place, the missing is n + 1
        return n + 1;
    }
}
