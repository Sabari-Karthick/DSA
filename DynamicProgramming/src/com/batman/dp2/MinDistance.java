package com.batman.dp2;

/**
 * The Flag: Two strings + "transform/convert" + "minimum operations (insert, delete, replace)".
 * <p>
 * The Intuition: The Two-Finger method. If the letters match, it costs 0 operations. If they mismatch, you are forced to spend 1 operation. You test all three physical buttons (Replace, Delete, Insert) and pick the one that results in the cheapest future.
 * <p>
 * The Formula:
 * <p>
 * Match: helper(i + 1, j + 1)
 * <p>
 * Mismatch: 1 + Math.min(Replace, Math.min(Delete, Insert))
 * <p>
 * Replace: helper(i + 1, j + 1) (Both fingers move)
 * <p>
 * Delete: helper(i + 1, j) (Word 1 finger moves, Word 2 finger stays)
 * <p>
 * Insert: helper(i, j + 1) (Word 1 finger stays, Word 2 finger moves)
 * <p>
 * Known States (Base Cases):
 * Word 1 is empty (i == word1.length())? Return word2.length() - j (Cost is inserting the rest of Word 2).
 * Word 2 is empty (j == word2.length())? Return word1.length() - i (Cost is deleting the rest of Word 1).
 * <p>
 * The Memory: 2D array Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];.
 * <p>
 * Time Complexity: O(m \times n) to fill the memory states.
 * <p>
 * Space Complexity: O(m \times n) for the array + O(m + n) for the recursion stack.
 *
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2, 0, 0, dp);
    }

    private int minDistanceHelper(String word1, String word2, int i, int j, Integer[][] dp) {
        if (i == word1.length()) {
            // means we have reached the end of word1, we need as many insertions as the remaining characters in word2
            return word2.length() - j; // We may have passed some j in the word2 so we need remaining characters in word2
        }

        if (j == word2.length()) {
            // means we have reached the end of word2, we need as many deletions as the remaining characters in word1
            return word1.length() - i; // We may have passed some i in the word1 so we need remaining characters in word1
        }

        // Always check memo at top
        if (dp[i][j] != null)
            return dp[i][j]; // If we have already calculated the result for this subproblem, we can simply return the stored value instead of recalculating it.

        // First Case : We got the letter Match
        if (word1.charAt(i) == word2.charAt(j)) {
            // We can move both pointers
            dp[i][j] = minDistanceHelper(word1, word2, i + 1, j + 1, dp);
        } else {
            // Second Case : We got the letter Mismatch
            // Now we have three choices, either we can insert, delete or replace a character and take the minimum of all three results.

            // Simple : Replace . Means no worry on pointers , we spend 1 and we get the pointers matched
            int replace = 1 + minDistanceHelper(word1, word2, i + 1, j + 1, dp); // We move both pointers because we have replaced the character in word1 with the character in word2

            // Delete :
            // With delete our pointer of word1 will fallout so we need to move it
            int delete = 1 + minDistanceHelper(word1, word2, i + 1, j, dp); // We move the pointer of word1 because we have deleted the character in word1

            //Insert :
            // If we added a new character in place of the pointer of word1, we need to move the pointer of word2 because we have matched the character in word2 with the new character in word1
            int insert = 1 + minDistanceHelper(word1, word2, i, j + 1, dp); // We move the pointer of word2 because we have inserted a new character in word

            //Since we need minimum edit distance, we take the minimum of all three results
            dp[i][j] = Math.min(replace, Math.min(delete, insert));
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros")); // 3
        System.out.println(new MinDistance().minDistance("intention", "execution")); // 5
    }

}
