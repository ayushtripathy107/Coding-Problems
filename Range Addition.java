class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // Iterate through all operations to find the minimum dimensions
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        
        // The product of the minimum row and column gives the overlap area
        return m * n;
    }
}
