class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // Pointer for name
        int j = 0; // Pointer for typed
        
        while (j < typed.length()) {
            // If characters match, move both pointers forward
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } 
            // If characters don't match, check if it's a long press of the previous character
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } 
            // If it's a mismatch and not a long press, it's an invalid typing
            else {
                return false;
            }
        }
        
        // The typed string is valid only if we successfully matched all characters in name
        return i == name.length();
    }
}
