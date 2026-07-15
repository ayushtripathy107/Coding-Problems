import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        // Track character frequencies
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        // Calculate length based on pairs
        for (int count : counts.values()) {
            length += (count / 2) * 2; // Add the largest even part
            if (count % 2 != 0) {
                hasOdd = true; // Flag that an odd character exists
            }
        }
        
        // If an odd frequency character exists, place one in the middle
        if (hasOdd) {
            length += 1;
        }
        
        return length;
    }
}
