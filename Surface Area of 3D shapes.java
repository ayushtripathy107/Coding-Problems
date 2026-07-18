class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;
        
        // Define direction vectors for checking 4 adjacent cells (Up, Down, Left, Right)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int v = grid[r][c];
                
                if (v > 0) {
                    // Add top and bottom faces
                    totalArea += 2;
                    
                    // Add all 4 side faces initially
                    totalArea += 4 * v;
                    
                    // Subtract overlapping faces from adjacent neighbors
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        
                        // Check if the neighbor is within grid boundaries
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            totalArea -= Math.min(v, grid[nr][nc]);
                        }
                    }
                }
            }
        }
        
        return totalArea;
    }
}
