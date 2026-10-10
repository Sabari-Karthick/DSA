package com.batman.dp1;

import java.util.Arrays;

/**
 *
 * For the Subsequence Problem the pattern is
 * --> Either Take or not Take
 * <p>
 * For subsequence We can skip in between characters but the selection should be a sequence
 * <p>
 * The Flag: Single array + "subsequence" + "strictly increasing" + "longest/maximum".
 * <p>
 * The Intuition: At each element, you have two choices:
 * <p>
 * Skip: Ignore the element (prev does not change).
 * <p>
 * Take: Only valid if prev == -1 or arr[cur] > arr[prev].
 * <p>
 * If taken, add 1, and cur becomes the new prev.
 * <p>
 * The Formula: Math.max(skip, take)
 * <p>
 * Known States (Base Cases): cur == arr.length $\rightarrow$ return 0.
 * <p>
 * The Memory: Integer[n][n + 1] dp. Indexing is always dp[cur][prev + 1].
 * <p>
 * Time Complexity: $O(n^2)$ states, each taking $O(1)$ work.
 * <p>
 * Space Complexity: $O(n^2)$ for the memo table + $O(n)$ recursion stack.
 *
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(longestIncreasingSubsequence(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(longestIncreasingSubsequence2(new int[]{0, 1, 0, 3, 2, 3})); // 4
        System.out.println(longestIncreasingSubsequence2(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
        System.out.println(longestIncreasingSubsequence2(new int[]{4, 10, 4, 3, 8, 9})); // 3
    }


    // First Sliding Window and Two pointers are out of the picture here
    // Because Subsequence is not a contiguous sequence so we can skip in between characters which makes SW impossible
    // The two values we compare may have values that may for a sequence is beyond the two values we are comparing so Two Pointers is also out of the picture


    // So Basically we arrive at a point take a number and see how can it form a subsequence which is DFS
    // But instead of exploring we can see one more thing , take the number see if it can fit in any of the subsequence we already have and update the length
    // Like Building Blocks instead of checking or worrying will this sequence get bigger in future
    // Just add it to the big block we have till now
    public static int longestIncreasingSubsequence(int[] arr) {

        // We need to track for each number what is the longest subsequence(block) its been part of

        int[] dp = new int[arr.length];

        // Since each number is a subsequence of length 1
        Arrays.fill(dp, 1);

        int ans = 1; // As we have at least one number in the array

        for (int i = 0; i < arr.length; i++) { // For Each Number
            // We need to know the subsequence length of the previous numbers and see if we can add this number to that subsequence
            for (int j = 0; j < i; j++) {
                // The main condition is that the previous number should be less
                if (arr[i] > arr[j]) { // Means we can add to the previous subsequence if our addition increase the length
                    // Valid Jump
                    // Update the max Subsequence Length for this number
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp[j] is the max till previous number and we add one more length
                }
            }

            ans = Math.max(ans, dp[i]); // Update the max subsequence length we have seen so far, we can't blindly take dp[i] as it may not have been calculated itself
        }

        return ans;
    }

    public static int longestIncreasingSubsequence2(int[] arr) {
        // We can track the current number we looking and the last number we picked in our sequence
        Integer[][] dp = new Integer[arr.length][arr.length + 1]; // +1 because we can have a case where we haven't picked any number yet so we need to track that as well
        return lis(arr, 0, -1, dp);
    }

    private static int lis(int[] arr, int cur, int prev, Integer[][] dp) {
        if (cur == arr.length) {
            return 0; // We have reached the end of the array
        }

        // Always check memo at top
        if (dp[cur][prev + 1] != null) { // Note we store prev = -1 at index 0 thats why our length is n x n + 1
            return dp[cur][prev + 1];
        }

        int take = 0; // Take is the optional part here which only happens if it satisfies the condition

        if (prev == -1 || arr[cur] > arr[prev]) {
            take = 1 + lis(arr, cur + 1, cur, dp); // Cur becomes our next prev as in prev we are tracking the last picked number
        }

        // Not take is our default option because it requires no condition
        int notTake = lis(arr, cur + 1, prev, dp); // We can always skip the current number


        dp[cur][prev + 1] = Math.max(take, notTake); // While updating we are putting it in one index forward

        return dp[cur][prev + 1]; // Since for prev we have values from -1 to n-1
    }


}
