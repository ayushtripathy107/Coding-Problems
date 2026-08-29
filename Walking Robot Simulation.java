import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: 0 = North, 1 = East, 2 = South, 3 = West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Store obstacles in a hash set for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int x = 0, y = 0; // Starting position
        int dir = 0;      // Starting direction (North)
        int maxDistSquare = 0;
        
        for (int cmd : commands) {
            if (cmd == -1) {
                // Turn right 90 degrees
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                // Turn left 90 degrees
                dir = (dir + 3) % 4;
            } else {
                // Move forward cmd units, one unit at a time
                for (int k = 0; k < cmd; k++) {
                    int nextX = x + dirs[dir][0];
                    int nextY = y + dirs[dir][1];
                    
                    // Check if the next step is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // Stop moving in this direction
                    }
                    
                    x = nextX;
                    y = nextY;
                    
                    // Track maximum squared distance
                    maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
                }
            }
        }
        
        return maxDistSquare;
    }
}
