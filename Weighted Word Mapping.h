class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        string result = "";
        
        for (const string& word : words) {
            long long totalWeight = 0;
            
            // Calculate sum of weights for the current word
            for (char c : word) {
                totalWeight += weights[c - 'a'];
            }
            
            // Map the weight to a character (0 -> 'z', 1 -> 'y', etc.)
            int mappedValue = totalWeight % 26;
            char mappedChar = 'z' - mappedValue;
            
            result += mappedChar;
        }
        
        return result;
    }
};
