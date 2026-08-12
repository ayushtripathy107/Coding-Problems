import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Start from the second to last row and move upwards
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            
            for (int j = 0; j < currentRow.size(); j++) {
                // Find the minimum of the two adjacent numbers underneath
                int minPath = Math.min(nextRow.get(j), nextRow.get(j + 1));
                // Update the current position with the accumulated sum
                currentRow.set(j, currentRow.get(j) + minPath);
            }
        }
        
        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }
}
