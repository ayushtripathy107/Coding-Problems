class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if the character is an uppercase letter
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Add 32 to convert it to lowercase
                chars[i] = (char) (chars[i] + 32);
            }
        }
        
        return new String(chars);
    }
}
