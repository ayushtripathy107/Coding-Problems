class Solution {
    public int findJudge(int n, int[][] trust) {
        // Create an array to store the net trust score of each person.
        // Size is n + 1 because people are labeled from 1 to n.
        int[] trustScores = new int[n + 1];
        
        // Loop through each trust relationship
        for (int[] relation : trust) {
            int truster = relation[0];
            int trustee = relation[1];
            
            // Decrease the score of the person who trusts
            trustScores[truster]--;
            // Increase the score of the person being trusted
            trustScores[trustee]++;
        }
        
        // Check if anyone has a score equal to n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        // If no such person exists, return -1
        return -1;
    }
}
