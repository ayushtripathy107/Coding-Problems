import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert primitive int[] to Integer[] to use a custom Comparator
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        // Sort by bit count first, then by numerical value
        Arrays.sort(boxedArr, (a, b) -> {
            int bitCompare = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            if (bitCompare != 0) {
                return bitCompare;
            }
            return Integer.compare(a, b);
        });

        // Copy sorted elements back into the original primitive array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }

        return arr;
    }
}
