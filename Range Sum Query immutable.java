class NumArray {
    // Array to store the running prefix sums
    private int[] prefixSums;

    public NumArray(int[] nums) {
        // Size is n + 1 to simplify range subtraction logic
        prefixSums = new int[nums.length + 1];
        
        // Build the prefix sum array
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // O(1) retrieval using the precomputed sums
        return prefixSums[right + 1] - prefixSums[left];
    }
}
