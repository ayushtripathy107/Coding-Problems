class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // Get the value of the current character (A=1, B=2, etc.)
            int value = columnTitle.charAt(i) - 'A' + 1;
            
            // Shift existing result by base 26 and add new value
            result = result * 26 + value;
        }
        return result;
    }
}
