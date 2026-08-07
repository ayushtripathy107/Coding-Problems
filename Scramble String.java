import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization table to store results of previously checked string pairs
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base Case 1: Strings are identical
        if (s1.equals(s2)) {
            return true;
        }

        // Base Case 2: Lengths are different or character counts don't match
        if (s1.length() != s2.length() || !hasSameCharacters(s1, s2)) {
            return false;
        }

        // Check if this pair has already been computed
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try splitting the string at every possible index i
        for (int i = 1; i < n; i++) {
            // Case 1: No swap at the current root level
            boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) 
                          && isScramble(s1.substring(i), s2.substring(i));
            
            if (noSwap) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Substrings are swapped at the current root level
            boolean swap = isScramble(s1.substring(0, i), s2.substring(n - i)) 
                        && isScramble(s1.substring(i), s2.substring(0, n - i));
            
            if (swap) {
                memo.put(key, true);
                return true;
            }
        }

        // If no split configuration works, cache and return false
        memo.put(key, false);
        return false;
    }

    // Helper method to quickly filter out strings with different character frequencies
    private boolean hasSameCharacters(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
