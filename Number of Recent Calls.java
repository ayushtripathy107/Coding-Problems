import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    // Queue to store the timestamps of recent requests
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current request time to the queue
        requests.add(t);
        
        // Remove all requests older than t - 3000
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        
        // The remaining size of the queue is the number of recent requests
        return requests.size();
    }
}
