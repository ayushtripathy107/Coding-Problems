class Solution(object):
    def zigZagArrays(self, n, l, r):
        """
        :type n: int
        :type l: int
        :type r: int
        :type rtype: int
        """
        MOD = 10**9 + 7
        m = r - l + 1
        
        # Base case: for length 1, each value can start a sequence 
        # that either goes up (dp1) or goes down (dp0).
        dp0 = [1] * m
        dp1 = [1] * m
        
        for _ in range(2, n + 1):
            next_dp0 = [0] * m
            next_dp1 = [0] * m
            
            # To fill next_dp1[y], we need sum(dp0[x]) for x < y (Prefix Sum)
            current_sum = 0
            for y in range(m):
                next_dp1[y] = current_sum
                current_sum = (current_sum + dp0[y]) % MOD
                
            # To fill next_dp0[y], we need sum(dp1[x]) for x > y (Suffix Sum)
            current_sum = 0
            for y in range(m - 1, -1, -1):
                next_dp0[y] = current_sum
                current_sum = (current_sum + dp1[y]) % MOD
                
            dp0 = next_dp0
            dp1 = next_dp1
            
        # Total valid sequences is the sum of all configurations at length n
        return (sum(dp0) + sum(dp1)) % MOD
