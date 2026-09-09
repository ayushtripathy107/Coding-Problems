import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Maps each street type (1-6) to its two allowed directional movements:
    // Directions: 0 = Up, 1 = Down, 2 = Left, 3 = Right
    private final int[][][] transitions = {
        {}, // 0 (unused)
        {{0, -1}, {0, 1}},  // Street 1: Left, Right
        {{-1, 0}, {1, 0}},  // Street 2: Upper, Lower
        {{0, -1}, {1, 0}},  // Street 3: Left, Lower
        {{0, 1},  {1, 0}},  // Street 4: Right, Lower
        {{0, -1}, {-1, 0}}, // Street 5: Left, Upper
        {{0, 1},  {-1, 0}}  // Street 6: Right, Upper
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // BFS structures
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            // If we reached the bottom-right corner, a valid path exists
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            int streetType = grid[r][c];
            
            // Explore both allowed directions for the current street type
            for (int[] dir : transitions[streetType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // 1. Check boundary conditions
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }
                
                // 2. Verify compatibility: Does the neighbor connect back to the current cell?
                if (canConnect(nr, nc, r, c, grid)) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }
    
    // Checks if the neighbor street type can connect back to the current street cell
    private boolean canConnect(int nr, int nc, int r, int c, int[][] grid) {
        int nextStreet = grid[nr][nc];
        for (int[] dir : transitions[nextStreet]) {
            if (nr + dir[0] == r && nc + dir[1] == c) {
                return true;
            }
        }
        return false;
    }
}
