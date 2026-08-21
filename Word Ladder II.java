import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        // If the endWord is not in the dictionary, no valid sequence exists.
        if (!dict.contains(endWord)) {
            return res;
        }
        
        // Map to store the minimum steps/distance from beginWord to each word
        Map<String, Integer> distanceMap = new HashMap<>();
        // Adjacency list to store the graph transitions
        Map<String, List<String>> adjMap = new HashMap<>();
        
        // Step 1: BFS to find shortest paths and build the DAG graph
        boolean found = bfs(beginWord, endWord, dict, distanceMap, adjMap);
        
        // Step 2: DFS to reconstruct all paths if a valid path was found
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, distanceMap, adjMap, path, res);
        }
        
        return res;
    }
    
    private boolean bfs(String beginWord, String endWord, Set<String> dict, 
                        Map<String, Integer> distanceMap, Map<String, List<String>> adjMap) {
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        
        boolean isFound = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process layer by layer (level order traversal)
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDist = distanceMap.get(curr);
                
                // Stop generating next level paths if we already found the endWord at a shorter level
                if (curr.equals(endWord)) {
                    isFound = true;
                }
                
                List<String> neighbors = getNeighbors(curr, dict);
                for (String neighbor : neighbors) {
                    // If neighbor is visited for the first time at a deeper level
                    if (!distanceMap.containsKey(neighbor)) {
                        distanceMap.put(neighbor, currDist + 1);
                        queue.offer(neighbor);
                    }
                    
                    // If neighbor is part of an optimal layer path, add it to the graph
                    if (distanceMap.get(neighbor) == currDist + 1) {
                        adjMap.computeIfAbsent(curr, k -> new ArrayList<>()).add(neighbor);
                    }
                }
            }
            if (isFound) break; 
        }
        return isFound;
    }
    
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String nextWord = new String(chars);
                if (dict.contains(nextWord)) {
                    neighbors.add(nextWord);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
    
    private void dfs(String curr, String endWord, Map<String, Integer> distanceMap, 
                     Map<String, List<String>> adjMap, List<String> path, List<List<String>> res) {
        
        if (curr.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        List<String> neighbors = adjMap.get(curr);
        if (neighbors == null) return;
        
        for (String neighbor : neighbors) {
            // Strictly follow the shortest path layer hierarchy
            if (distanceMap.get(neighbor) == distanceMap.get(curr) + 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, distanceMap, adjMap, path, res);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }
}
