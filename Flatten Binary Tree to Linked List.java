class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        
        while (current != null) {
            // If a left child exists, find the rightmost node in that left subtree
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Connect the rightmost node of the left subtree to the current right child
                predecessor.right = current.right;
                
                // Move the entire left subtree to the right side
                current.right = current.left;
                current.left = null; // Set left child to null as required
            }
            
            // Move down the flattened right side
            current = current.right;
        }
    }
}
