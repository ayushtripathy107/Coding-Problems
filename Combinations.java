import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the combination has k elements, add it to the final result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: only loop if there are enough elements left to reach size k
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i); // Choose the element
            backtrack(i + 1, n, k, current, result); // Recurse with the next elements
            current.remove(current.size() - 1); // Backtrack (undo the choice)
        }
    }
}
