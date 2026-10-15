class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPos = -1;
        int currentPos = 0;
        
        while (n > 0) {
            // Check if the lowest bit is 1
            if ((n & 1) == 1) {
                if (lastPos != -1) {
                    // Update the maximum gap found so far
                    maxGap = Math.max(maxGap, currentPos - lastPos);
                }
                // Record the position of the current 1
                lastPos = currentPos;
            }
            // Shift right to inspect the next bit
            n >>>= 1;
            currentPos++;
        }
        
        return maxGap;
    }
}
