class Solution {
    public int maximum69Number (int num) {
        // Convert the number to a string to easily manipulate characters
        String numStr = String.valueOf(num);
        
        // Find the first occurrence of '6' from the left and replace it with '9'
        String resultStr = numStr.replaceFirst("6", "9");
        
        // Convert the modified string back to an integer
        return Integer.parseInt(resultStr);
    }
}
