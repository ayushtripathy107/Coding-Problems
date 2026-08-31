import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        
        // Step 1: Map each value to a list of its indices
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // Step 2: Process each query
        for (int queryIndex : queries) {
            int targetVal = nums[queryIndex];
            List<Integer> indices = valToIndices.get(targetVal);
            
            // If the element appears only once, no other matching element exists
            if (indices == null || indices.size() <= 1) {
                answer.add(-1);
                continue;
            }
            
            // Step 3: Find the position of queryIndex in the sorted list
            int idxInList = Collections.binarySearch(indices, queryIndex);
            int m = indices.size();
            int minDistance = Integer.MAX_VALUE;
            
            // Step 4: Check circular neighbors in the list
            // Left neighbor (wrap around to the end if current is the first element)
            int leftIdx = indices.get((idxInList - 1 + m) % m);
            int leftDist = Math.abs(queryIndex - leftIdx);
            minDistance = Math.min(minDistance, Math.min(leftDist, n - leftDist));
            
            // Right neighbor (wrap around to the beginning if current is the last element)
            int rightIdx = indices.get((idxInList + 1) % m);
            int rightDist = Math.abs(queryIndex - rightIdx);
            minDistance = Math.min(minDistance, Math.min(rightDist, n - rightDist));
            
            answer.add(minDistance);
        }
        
        return answer;
    }
}
