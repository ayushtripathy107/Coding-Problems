class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty
            if (flowerbed[i] == 0) {
                // Check if the left plot is empty or out of bounds
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                // Check if the right plot is empty or out of bounds
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // If both sides are clear, plant a flower here
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                    
                    // Early exit optimization
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        
        return count >= n;
    }
}
