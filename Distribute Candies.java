import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        // Step 1: Find the number of unique candy types
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        
        // Step 2: Calculate the maximum allowed candies Alice can eat
        int maxAllowed = candyType.length / 2;
        
        // Step 3: Return the minimum of unique types available and max allowed
        return Math.min(uniqueCandies.size(), maxAllowed);
    }
}
