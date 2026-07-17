class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }
        
        // Recursively get the string for n - 1
        String prev = countAndSay(n - 1);
        
        // Build the current string using Run-Length Encoding (RLE)
        StringBuilder result = new StringBuilder();
        int len = prev.length();
        
        for (int i = 0; i < len; i++) {
            int count = 1;
            
            // Count consecutive identical characters
            while (i + 1 < len && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            
            // Append the count followed by the digit character itself
            result.append(count).append(prev.charAt(i));
        }
        
        return result.toString();
    }
}
