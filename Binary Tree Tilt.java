class Solution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        calculateSum(root);
        return totalTilt;
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the sum of left and right subtrees
        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);

        // Calculate current node's tilt and add it to totalTilt
        totalTilt += Math.abs(leftSum - rightSum);

        // Return the sum of the subtree rooted at this node
        return node.val + leftSum + rightSum;
    }
}
