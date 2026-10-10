package com.batman.dp2;

/**
 * The Flag: Two strings + "subsequence" (order matters, but characters don't need to be touching) + "longest/maximum".
 * <p>
 * The Intuition: The Two-Finger method. If the letters under your fingers match, you score a point and move both fingers forward. If they don't match, you test the two alternate realities (move left finger vs. move right finger) and take the maximum score.
 * <p>
 * The Formula:
 * Match: 1 + helper(i + 1, j + 1)
 * Mismatch: Math.max(helper(i + 1, j), helper(i, j + 1))
 * <p>
 * Known States (Base Cases): If either finger falls off the end of its word (i == text1.length() || j == text2.length()), return 0.
 * There are no more letters to match.
 * <p>
 * The Memory: 2D array Integer[][] dp = new Integer[text1.length()][text2.length()];.
 * <p>
 * Time Complexity: O(m \times n), where m and n are the lengths of the two strings. We evaluate every pair of indices exactly once.
 * <p>
 * Space Complexity: O(m \times n) for the 2D memory array, plus O(m + n) for the recursive call stack.
 *
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // Since we have two moving pointers, we can use a 2D array to store the results of the subproblems.
        // The size of the array will be text1.length() x text2.length().
        // We will initialize the array with null values to indicate that we have not calculated the result for that subproblem yet.
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, 0, 0, dp);
    }

    private int lcs(String text1, String text2, int i, int j, Integer[][] dp) {
        if (i == text1.length() || j == text2.length())
            return 0; // Base case: If we have reached the end of either string, there is no common subsequence.

        //Always check memo at top
        if (dp[i][j] != null)
            return dp[i][j]; // If we have already calculated the result for this subproblem, we can simply return the stored value instead of recalculating it.

        // Rule 1 : Our Characters match, we can move both pointers and add 1 to the result.
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs(text1, text2, i + 1, j + 1, dp);
        } else {
            // Rule 2 : If don't match we have two choices, either move the first pointer or move the second pointer and take the maximum of both results.
            // We take max because we don't want to lock ourselves into a path that doesn't give us the longest common subsequence.
            // There maybe a case where we can find a longer common subsequence by moving the second pointer instead of the first pointer.
            dp[i][j] = Math.max(lcs(text1, text2, i + 1, j, dp), lcs(text1, text2, i, j + 1, dp));
        }

        return dp[i][j]; // Return the result for this subproblem.
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc")); // 3
    }

}
