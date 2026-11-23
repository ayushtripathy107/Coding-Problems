class Solution {
    public int subsetXORSum(int[] nums) {
        int orTotal = 0;
        for (int num : nums) {
            orTotal |= num;
        }
        return orTotal << (nums.length - 1);
    }
}
