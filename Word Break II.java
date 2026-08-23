import java.util.*;

class Solution {
    // Memoization map to store calculated results for suffixes
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert dictionary to a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // If this substring has already been processed, return its saved result
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();
        
        // Base case: if the string is empty, return a list containing an empty string
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        // Try every possible prefix of the current string
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            
            // If the prefix exists in the dictionary, process the remaining suffix
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixSegments = backtrack(suffix, wordSet);
                
                // Combine the current prefix with all valid suffixes found
                for (String segment : suffixSegments) {
                    if (segment.isEmpty()) {
                        res.add(prefix);
                    } else {
                        res.add(prefix + " " + segment);
                    }
                }
            }
        }

        // Cache the result for the current string before returning
        memo.put(s, res);
        return res;
    }
}
