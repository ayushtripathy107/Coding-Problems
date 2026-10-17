import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a Max-Heap by passing Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stone weights to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        // Process stones until 0 or 1 stone is left
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest stone
            int x = maxHeap.poll(); // Second heaviest stone
            
            if (x != y) {
                maxHeap.add(y - x); // Put the remaining weight back
            }
        }
        
        // If the heap is empty, return 0; otherwise, return the last stone weight
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
