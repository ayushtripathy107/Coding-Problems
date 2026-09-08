import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort both robots and factories by their positions
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = robot.size();
        int m = factory.length;
        
        // dp[i] represents the minimum total distance to repair the first i robots
        // Initialize with a large value representing infinity
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2); // Avoid overflow during addition
        dp[0] = 0; // 0 robots require 0 distance
        
        // Step 2: Iterate through each factory
        for (int j = 0; j < m; j++) {
            int factoryPos = factory[j][0];
            int factoryLimit = factory[j][1];
            
            // Iterate backwards to update the DP table using only 1D array space
            for (int i = n; i >= 1; i--) {
                long currentDistanceSum = 0;
                
                // Try assigning k robots (from i-1 down to 0) to the current factory j
                for (int k = 1; k <= factoryLimit && i - k >= 0; k++) {
                    currentDistanceSum += Math.abs((long) robot.get(i - k) - factoryPos);
                    
                    if (dp[i - k] != Long.MAX_VALUE / 2) {
                        dp[i] = Math.min(dp[i], dp[i - k] + currentDistanceSum);
                    }
                }
            }
        }
        
        return dp[n];
    }
}
