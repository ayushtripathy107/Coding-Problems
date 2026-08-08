class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev2 = 1; // Represents dp[i-2]
        int prev1 = 1; // Represents dp[i-1]

        for (int i = 1; i < n; i++) {
            int current = 0;
            char single = s.charAt(i);
            char doubleFirst = s.charAt(i - 1);

            // Check if single digit valid
            if (single != '0') {
                current += prev1;
            }

            // Check if double digit valid
            if (doubleFirst == '1' || (doubleFirst == '2' && single <= '6')) {
                current += prev2;
            }

            // If it cannot be decoded at all
            if (current == 0) {
                return 0;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
