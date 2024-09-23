package com.trie.problems;
/**
 * 
 * 
 * 
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description
 * 
 * (Log N) ^ 2
 * 
 */
public class KthSmallestElementInLexographicalOrder {

}
class Solution22325435 {
    public int findKthNumber(int n, int k) {
        int current = 1;  // Start with the first lexicographical number
        k--;  // We decrement k because we treat "current" as the first number (1-based to 0-based index)

        while (k > 0) {
            // Count how many numbers are between current and current + 1 (i.e., the next prefix)
            int count = countNumbers(n, current, current + 1);

            if (count <= k) {
                // If the count of numbers in this prefix is less than or equal to k,
                // it means the k-th number is not in this branch, so skip the entire branch
                current++;
                k -= count;  // Reduce k by the count of numbers we skipped
            } else {
                // If the count of numbers is greater than k, then the k-th number is in this branch
                // Go deeper into the tree
                current *= 10;  // Move to the next level by adding a zero to the prefix (e.g., 1 -> 10)
                k--;  // Reduce k because we're considering this current number
            }
        }

        return current;
    }

    // This method counts how many numbers exist between two prefixes (prefix and nextPrefix)
    private int countNumbers(long n, long prefix, long nextPrefix) {
        int count = 0;
        while (prefix <= n) {
            // Add the number of numbers in the current range, which is either (nextPrefix - prefix) or (n + 1 - prefix)
            count += Math.min(n + 1, nextPrefix) - prefix;
            // Move to the next level in the tree (e.g., 1 -> 10 -> 100, and so on)
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }
}
