class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        if (n == 0) return 0;
        
        // Try to find the shortest matching prefix and suffix
        for (int i = 1; i <= n / 2; i++) {
            if (text.substring(0, i).equals(text.substring(n - i))) {
                // If matched, add 2 to the count (1 for prefix, 1 for suffix)
                // and recursively solve for the remaining center substring
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        
        // If no matching prefix/suffix is found, the whole remaining text is 1 chunk
        return 1;
    }
}
