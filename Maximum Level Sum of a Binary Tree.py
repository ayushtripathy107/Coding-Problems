from collections import deque

class Solution(object):
    def maxLevelSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        if not root:
            return 0
        
        max_sum = float('-inf')
        max_level = 1
        current_level = 1
        
        queue = deque([root])
        
        while queue:
            level_sum = 0
            # Number of nodes at the current level
            level_size = len(queue)
            
            for _ in range(level_size):
                node = queue.popleft()
                level_sum += node.val
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            # Update max_sum and record the level
            if level_sum > max_sum:
                max_sum = level_sum
                max_level = current_level
            
            current_level += 1
            
        return max_level
