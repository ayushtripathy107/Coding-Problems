class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        
        // Step 1: Apply gravity to each row independently
        for (int i = 0; i < m; i++) {
            int emptyCellIdx = n - 1; // Tracks the lowest available position for a stone
            
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    emptyCellIdx = j - 1; // Obstacle blocks further falling; reset boundary
                } else if (boxGrid[i][j] == '#') {
                    // Move stone to the lowest available empty cell
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyCellIdx] = '#';
                    emptyCellIdx--; // Next available cell moves left
                }
            }
        }
        
        // Step 2: Rotate the grid 90 degrees clockwise
        char[][] rotatedGrid = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedGrid[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        
        return rotatedGrid;
    }
}
