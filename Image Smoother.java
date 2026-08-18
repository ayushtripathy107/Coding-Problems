class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        
        // Iterate over every pixel in the image
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                
                // Iterate over the 3x3 surrounding window
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // Check if the neighbor is within the matrix boundaries
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            sum += img[x][y];
                            count++;
                        }
                    }
                }
                
                // Calculate the floor average
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}
