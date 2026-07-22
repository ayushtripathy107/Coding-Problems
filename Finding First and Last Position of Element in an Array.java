class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findBound(nums, target, true);  // Find first position
        result[1] = findBound(nums, target, false); // Find last position
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Potential answer found
                if (isFirst) {
                    right = mid - 1; // Keep searching left for first position
                } else {
                    left = mid + 1;  // Keep searching right for last position
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
