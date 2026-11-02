import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        
        int degree = 0;
        
        // Step 1: Populate frequencies and boundaries
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, count.get(num));
        }
        
        int minLength = nums.length;
        
        // Step 2: Find the minimum length among elements with the maximum degree
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = last.get(num) - first.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }
        
        return minLength;
    }
}
