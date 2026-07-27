class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        
        // Count total uppercase letters
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }
        
        // Case 1: All letters are capitals (e.g., "USA")
        if (capitals == word.length()) {
            return true;
        }
        
        // Case 2: All letters are lowercase (e.g., "leetcode")
        if (capitals == 0) {
            return true;
        }
        
        // Case 3: Only the first letter is capital (e.g., "Google")
        if (capitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
