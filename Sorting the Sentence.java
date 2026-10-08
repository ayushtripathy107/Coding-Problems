class Solution {
    public String sortSentence(String s) {
        // Split the shuffled sentence into individual words
        String[] words = s.split(" ");
        
        // Create an array to store the reconstructed words in their correct order
        String[] ans = new String[words.length];
        
        for (String word : words) {
            // Extract the 1-indexed position at the end of the word
            int index = word.charAt(word.length() - 1) - '0';
            
            // Extract the word itself by removing the trailing digit
            String actualWord = word.substring(0, word.length() - 1);
            
            // Place the word at its correct 0-indexed position
            ans[index - 1] = actualWord;
        }
        
        // Join the sorted words with spaces
        return String.join(" ", ans);
    }
}
