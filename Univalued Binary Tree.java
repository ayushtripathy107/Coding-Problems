/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 1. Keep the exact method LeetCode expects
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // Start the recursive check using the root's value as the target
        return checkNodes(root, root.val);
    }

    // 2. Your helper method for recursion
    private boolean checkNodes(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        if (node.val != value) {
            return false;
        }
        return checkNodes(node.left, value) && checkNodes(node.right, value);
    }
}
