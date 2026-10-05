import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;
        
        // Calculate the total candies for Alice
        for (int x : aliceSizes) {
            sumA += x;
        }
        
        // Calculate the total candies for Bob and store his sizes in a HashSet
        Set<Integer> bobSet = new HashSet<>();
        for (int y : bobSizes) {
            sumB += y;
            bobSet.add(y);
        }
        
        // Target difference to add to Alice's box size
        int delta = (sumB - sumA) / 2;
        
        // Find the matching pair
        for (int x : aliceSizes) {
            int targetY = x + delta;
            if (bobSet.contains(targetY)) {
                return new int[]{x, targetY};
            }
        }
        
        return new int[0]; // Guaranteed to find an answer per constraints
    }
}
