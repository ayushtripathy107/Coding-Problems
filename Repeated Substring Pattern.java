class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Concatenate s with itself
        String doubled = s + s;
        
        // Remove the first and last characters, then check if s is a substring
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
