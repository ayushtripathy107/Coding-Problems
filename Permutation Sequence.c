#include <stdlib.h>
#include <string.h>

char* getPermutation(int n, int k) {
    // Step 1: Precompute factorials up to (n-1) and initialize numbers pool
    int factorials[10];
    int numbers[10];
    factorials[0] = 1;
    
    for (int i = 1; i < n; i++) {
        factorials[i] = factorials[i - 1] * i;
    }
    
    for (int i = 0; i < n; i++) {
        numbers[i] = i + 1; // Pool: [1, 2, 3, ..., n]
    }
    
    // Convert k to 0-indexed
    k--;
    
    // Allocate memory for the result string (+1 for null-terminator)
    char* result = (char*)malloc((n + 1) * sizeof(char));
    
    // Step 2: Build the permutation digit by digit
    for (int i = 0; i < n; i++) {
        // Elements remaining for the sub-problem
        int remaining_elements = n - 1 - i; 
        
        // Find index of the digit to pick
        int idx = k / factorials[remaining_elements];
        
        // Append chosen digit to the result string
        result[i] = numbers[idx] + '0';
        
        // Shift remaining numbers to fill the gap of the removed digit
        for (int j = idx; j < n - 1 - i; j++) {
            numbers[j] = numbers[j + 1];
        }
        
        // Update k for the next iteration
        k %= factorials[remaining_elements];
    }
    
    result[n] = '\0'; // Null-terminate string
    return result;
}
