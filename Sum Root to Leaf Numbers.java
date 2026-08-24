class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, it doesn't contribute to the sum
        if (node == null) {
            return 0;
        }

        // Update the running number for the current path
        currentSum = currentSum * 10 + node.val;

        // Check if the current node is a leaf node
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively find the sum of left and right paths
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }
}
