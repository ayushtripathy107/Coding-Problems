class Solution {
    public int findLucky(int[] arr) {
        // Since constraints state 1 <= arr[i] <= 500, 
        // we can use a fixed-size frequency array.
        int[] count = new int[501];
        
        // Count the frequency of each number
        for (int num : arr) {
            count[num]++;
        }
        
        // Iterate backwards from 500 to 1 to find the largest lucky integer
        for (int i = 500; i >= 1; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        
        return -1;
    }
}
