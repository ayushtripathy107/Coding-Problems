import heapq
from collections import defaultdict

class Solution(object):
    def minCost(self, n, edges):
        # Build adjacency list: adj[u] = [(v, weight, is_reverse)]
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((v, w, False)) # Normal edge
            adj[v].append((u, 2 * w, True)) # Reversible edge

        # Dijkstra's: (cost, node)
        pq = [(0, 0)]
        min_costs = {i: float('inf') for i in range(n)}
        min_costs[0] = 0
        
        while pq:
            curr_cost, u = heapq.heappop(pq)
            
            if u == n - 1:
                return curr_cost
            
            if curr_cost > min_costs[u]:
                continue
                
            for v, weight, is_reverse in adj[u]:
                new_cost = curr_cost + weight
                if new_cost < min_costs[v]:
                    min_costs[v] = new_cost
                    heapq.heappush(pq, (new_cost, v))
                    
        return min_costs[n-1] if min_costs[n-1] != float('inf') else -1
