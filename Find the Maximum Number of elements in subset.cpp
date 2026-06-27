#include <vector>
#include <map>
#include <cmath>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maximumLength(vector<int>& nums) {
        map<long long, int> counts;
        for (int x : nums) counts[x]++;

        int maxLen = 1;

        // Handle 1s separately: length must be odd
        if (counts.count(1)) {
            maxLen = counts[1] % 2 == 0 ? counts[1] - 1 : counts[1];
        }

        for (auto const& [val, count] : counts) {
            if (val == 1) continue;

            long long current = val;
            int currentLen = 0;

            // Build the sequence x, x^2, x^4...
            while (counts.count(current) && counts[current] >= 2) {
                currentLen += 2;
                current *= current; // Square for the next level
                // Prevent overflow for very large squares
                if (current > 1000000000) break; 
            }

            // The peak element (x^k) only needs a count of 1
            if (counts.count(current)) {
                currentLen += 1;
            } else {
                // If the last power isn't present, the previous one was the peak
                currentLen -= 1;
            }

            maxLen = max(maxLen, currentLen);
        }

        return maxLen;
    }
};
