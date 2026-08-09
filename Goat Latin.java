import java.util.HashSet;
import java.util.Set;

class Solution {
    public String toGoatLatin(String sentence) {
        // Define a set for quick vowel checking
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        
        // Split the sentence into individual words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder suffixA = new StringBuilder("a"); // Track the 'a's to append per index
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            
            // Check if the word starts with a vowel
            if (vowels.contains(firstChar)) {
                result.append(word);
            } else {
                // If it starts with a consonant, rotate the first character
                result.append(word.substring(1)).append(firstChar);
            }
            
            // Append "ma" and the index-based 'a's
            result.append("ma").append(suffixA);
            
            // Add a space between words, but not after the last word
            if (i < words.length - 1) {
                result.append(" ");
            }
            
            // Increment the trailing 'a's for the next word
            suffixA.append("a");
        }
        
        return result.toString();
    }
}
