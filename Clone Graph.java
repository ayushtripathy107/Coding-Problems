import java.util.*;

public class Solution {
    // Hash map to store the mapping from original node to cloned node
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node is already cloned, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the current node (do not copy neighbors yet)
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // Map the original node to its clone
        visited.put(node, cloneNode);

        // Iterate through the neighbors and recursively clone them
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
