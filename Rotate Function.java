class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        
        // Compute the sum of all elements and the initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        
        int maxVal = f;
        
        // Iteratively compute F(k) from F(k-1) in O(1) time per step
        for (int k = 1; k < n; k++) {
            f = f + sum - n * nums[n - k];
            maxVal = Math.max(maxVal, f);
        }
        
        return maxVal;
    }
}
