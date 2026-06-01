class Solution(object):
    def minimumCost(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        # Sort costs from highest to lowest
        cost.sort(reverse=True)
        
        total_cost = 0
        
        # Iterate through the list
        for i in range(len(cost)):
            # Skip every 3rd candy (index 2, 5, 8...)
            if (i + 1) % 3 != 0:
                total_cost += cost[i]
                
        return total_cost
