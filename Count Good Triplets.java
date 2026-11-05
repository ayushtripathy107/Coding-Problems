class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        
        // Loop through all possible triplets (i, j, k)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // Optimization: Check the first condition before launching the third loop
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        // Check the remaining two conditions
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
