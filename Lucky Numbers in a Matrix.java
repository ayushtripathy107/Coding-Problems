import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: Find the minimum element in each row
        int[] minRow = new int[m];
        for (int i = 0; i < m; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            minRow[i] = minVal;
        }
        
        // Step 2: Find the maximum element in each column
        int[] maxCol = new int[n];
        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
            maxCol[j] = maxVal;
        }
        
        // Step 3: Check which elements meet both conditions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}
