class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            // Move the left pointer forward if it's not a letter
            if (!Character.isLetter(chars[left])) {
                left++;
            } 
            // Move the right pointer backward if it's not a letter
            else if (!Character.isLetter(chars[right])) {
                right--;
            } 
            // Both are letters, so swap them and move both pointers
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }
}
