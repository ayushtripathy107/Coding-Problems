import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    // A prime number for the number of buckets helps distribute keys evenly
    private static final int BUCKET_SIZE = 769;
    private List<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function to map key to a bucket index
    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        // Only add if it doesn't already exist to maintain uniqueness
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        // Remove the key if found (using Integer object to match value, not index)
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
}
