import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use a set to track seen numbers with their context strings
        Set<String> seen = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];
                
                // Skip empty cells
                if (number != '.') {
                    // Formulate unique identifier strings for rows, columns, and sub-boxes
                    String rowKey = number + " in row " + r;
                    String colKey = number + " in col " + c;
                    String boxKey = number + " in box " + (r / 3) + "-" + (c / 3);
                    
                    // If any key already exists in the set, the board is invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
