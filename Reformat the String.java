class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                letters.append(c);
            }
        }
        
        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        boolean flag = letters.length() >= digits.length();
        int i = 0, j = 0;
        
        while (i < letters.length() || j < digits.length()) {
            if (flag) {
                res.append(letters.charAt(i++));
            } else {
                res.append(digits.charAt(j++));
            }
            flag = !flag;
        }
        
        return res.toString();
    }
}
