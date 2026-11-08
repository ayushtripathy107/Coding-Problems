import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXExist = false;
            boolean isYExist = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                // Check if the current node is x or y
                if (current.val == x) isXExist = true;
                if (current.val == y) isYExist = true;
                
                // Check if current node is the common parent of x and y
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) || 
                        (current.left.val == y && current.right.val == x)) {
                        return false; // Same parent -> Siblings, not cousins
                    }
                }
                
                // Add children to the queue for the next level
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // If both are found at the current depth level, they are cousins
            if (isXExist && isYExist) return true;
            
            // If only one is found at this level, they can't be cousins (different depths)
            if (isXExist || isYExist) return false;
        }
        
        return false;
    }
}
