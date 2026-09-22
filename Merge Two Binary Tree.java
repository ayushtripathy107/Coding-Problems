class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If one of the nodes is null, return the other node
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        
        // Merge the current overlapping nodes into root1
        root1.val += root2.val;
        
        // Recursively merge left and right subtrees
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}
