public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left to make room for the next bit
            res <<= 1;
            // Get the last bit of n and add it to res
            res |= (n & 1);
            // Shift n right to process the next bit
            n >>= 1;
        }
        return res;
    }
}
