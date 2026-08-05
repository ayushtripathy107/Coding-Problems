class Solution {
    public int[] constructRectangle(int area) {
        // Start from the integer floor of the square root
        int w = (int) Math.sqrt(area);
        
        // Decrement w until it perfectly divides the area
        while (area % w != 0) {
            w--;
        }
        
        // Calculate the corresponding length
        int l = area / w;
        
        return new int[]{l, w};
    }
}
