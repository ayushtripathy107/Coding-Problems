import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Collect leaf values for both trees
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        // Compare the two sequences
        return leaves1.equals(leaves2);
    }
    
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        
        // Check if the node is a leaf
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        
        // Recursively traverse left and right subtrees
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}
