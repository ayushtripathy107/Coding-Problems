class Solution(object):
    def largestMagicSquare(self, grid):
        m, n = len(grid), len(grid[0])
        
        # Precompute prefix sums for rows and columns
        rows = [[0] * (n + 1) for _ in range(m)]
        cols = [[0] * (n) for _ in range(m + 1)]
        
        for r in range(m):
            for c in range(n):
                rows[r][c+1] = rows[r][c] + grid[r][c]
                cols[r+1][c] = cols[r][c] + grid[r][c]

        def is_magic(r, c, k):
            # Target sum from the first row
            target = rows[r][c+k] - rows[r][c]
            
            # Check rows
            for i in range(r + 1, r + k):
                if rows[i][c+k] - rows[i][c] != target:
                    return False
            
            # Check columns
            for j in range(c, c + k):
                if cols[r+k][j] - cols[r][j] != target:
                    return False
            
            # Check diagonals
            d1 = d2 = 0
            for i in range(k):
                d1 += grid[r+i][c+i]
                d2 += grid[r+i][c+k-1-i]
            
            return d1 == target and d2 == target

        # Try largest possible size k first
        for k in range(min(m, n), 1, -1):
            for r in range(m - k + 1):
                for c in range(n - k + 1):
                    if is_magic(r, c, k):
                        return k
        
        return 1
