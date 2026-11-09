import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;
        
        // Loop through the array from right to left, or as long as there is a carry in k
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i]; // Add the current digit to k
                i--;
            }
            res.add(k % 10); // The last digit of k is the current column's result
            k /= 10;         // Carry over the remaining part of k
        }
        
        // Since we added digits from right to left, reverse the list to get the correct order
        Collections.reverse(res);
        return res;
    }
}
