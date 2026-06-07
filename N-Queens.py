class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        res = []
        board = [["."] * n for _ in range(n)]
        
        # Sets to keep track of columns and diagonals already occupied
        cols = set()
        posDiag = set() # (r + c)
        negDiag = set() # (r - c)
        
        def backtrack(r):
            if r == n:
                # Found a valid configuration, format and add to results
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            
            for c in range(n):
                if c in cols or (r + c) in posDiag or (r - c) in negDiag:
                    continue
                
                # Place queen
                cols.add(c)
                posDiag.add(r + c)
                negDiag.add(r - c)
                board[r][c] = "Q"
                
                # Move to next row
                backtrack(r + 1)
                
                # Backtrack: remove queen
                cols.remove(c)
                posDiag.remove(r + c)
                negDiag.remove(r - c)
                board[r][c] = "."
                
        backtrack(0)
        return res
