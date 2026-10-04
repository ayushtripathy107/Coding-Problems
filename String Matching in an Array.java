import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Loop through each word in the array
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Do not compare a word with itself
                if (i == j) {
                    continue;
                }
                
                // Check if words[i] is a substring of words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Break out of the inner loop once a match is found to avoid duplicates
                }
            }
        }
        
        return result;
    }
}
