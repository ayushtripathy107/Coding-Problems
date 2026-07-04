from collections import deque, defaultdict

class Solution(object):
    def minScore(self, n, roads):
        # 1. Build the adjacency list
        adj = defaultdict(list)
        for u, v, w in roads:
            adj[u].append((v, w))
            adj[v].append((u, w))
            
        # 2. BFS to find the minimum edge in the connected component
        min_score = float('inf')
        visited = {1}
        queue = deque([1])
        
        while queue:
            node = queue.popleft()
            for neighbor, weight in adj[node]:
                # Update min_score with every edge encountered in the component
                min_score = min(min_score, weight)
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
                    
        return min_score
