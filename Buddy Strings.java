class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Condition 1: Lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Condition 2: If the strings are already equal
        if (s.equals(goal)) {
            // We need at least one duplicate character to swap with itself
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        
        // Condition 3: If the strings are different, track the mismatched indices
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // More than 2 differences means we can't fix it with 1 swap
                    return false; 
                }
            }
        }
        
        // We must have exactly 2 mismatches, and they must be cross-equal
        return (second != -1 && 
                s.charAt(first) == goal.charAt(second) && 
                s.charAt(second) == goal.charAt(first));
    }
}
