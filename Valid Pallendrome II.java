class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Try skipping the left character OR skipping the right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        
        return true;
    }
    
    // Helper function to check if a substring is a standard palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
