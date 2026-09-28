class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        
        // Loop through the string jumping by 2k steps
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            // Reverse the first k characters, or fewer if we run out of string
            int end = Math.min(i + k - 1, chars.length - 1);
            
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        
        return new String(chars);
    }
}
