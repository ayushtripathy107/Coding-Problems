class Solution(object):
    def isMatch(self, s, p):
        # Memoization table
        memo = {}

        def dp(i, j):
            if (i, j) in memo:
                return memo[(i, j)]
            
            # Base case: if we reached the end of the pattern
            if j == len(p):
                return i == len(s)

            # Check if current characters match
            first_match = i < len(s) and p[j] in {s[i], '.'}

            # Handle '*' wildcard
            if j + 1 < len(p) and p[j+1] == '*':
                # Case 1: '*' matches 0 of the preceding element
                # Case 2: '*' matches 1 or more (if first_match is true)
                res = dp(i, j + 2) or (first_match and dp(i + 1, j))
            else:
                # Standard matching
                res = first_match and dp(i + 1, j + 1)

            memo[(i, j)] = res
            return res

        return dp(0, 0)
