class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Traverse every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is not visited, start a DFS
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, char target) {
        // Base case: Out of bounds or character mismatch
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != target) {
            return false;
        }
        
        // If already visited and not the parent, a cycle of length >= 4 is detected
        if (visited[r][c]) {
            return true;
        }
        
        // Mark current cell as visited
        visited[r][c] = true;
        
        // Define 4 directions: down, up, right, left
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            // Skip moving backward directly to the immediate parent cell
            if (nr == pr && nc == pc) {
                continue;
            }
            
            // Recursively search neighboring cells
            if (dfs(grid, visited, nr, nc, r, c, target)) {
                return true;
            }
        }
        
        return false;
    }
}
