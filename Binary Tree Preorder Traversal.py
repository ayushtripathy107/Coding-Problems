class Solution(object):
    def preorderTraversal(self, root):
        res = []
        def helper(node):
            if not node:
                return
            res.append(node.val)  # Root
            helper(node.left)     # Left
            helper(node.right)    # Right
        
        helper(root)
        return res
