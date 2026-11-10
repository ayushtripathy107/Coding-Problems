import java.util.ArrayList;
import java.util.List;

class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        
        // Convert the List to a primitive int array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inOrder(node.left);

        // Process current node
        if (currentCount == 0) {
            currentVal = node.val;
            currentCount = 1;
        } else if (node.val == currentVal) {
            currentCount++;
        } else {
            currentVal = node.val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        // Traverse right subtree
        inOrder(node.right);
    }
}
