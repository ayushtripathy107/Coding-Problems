class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Map character to its index according to the custom alphabet order
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        
        // Check every adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSorted(String word1, String word2, int[] charOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);
        
        for (int i = 0; i < minLen; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            
            if (c1 != c2) {
                // If characters differ, the first must come before the second
                return charOrder[c1 - 'a'] < charOrder[c2 - 'a'];
            }
        }
        
        // If all compared characters are identical, the shorter word must come first
        return len1 <= len2;
    }
}
