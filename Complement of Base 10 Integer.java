class Solution {
    public int bitwiseComplement(int n) {
        // Special case: the complement of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        int mask = 0;
        int temp = n;
        
        // Create a mask of 1s with the same bit length as n
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        
        // XORing n with the mask flips all of its bits
        return n ^ mask;
    }
}
