package com.batman.counting;

/**
 *
 * The Flag: "How many ways", "Total number of combinations", or "Count the distinct paths".
 * <p>
 * The Intuition: This is not an optimization (Min/Max) problem.
 * <p>
 * You are not looking for the best answer; you are counting the total number of valid parallel universes.
 * <p>
 * The Core Mechanic: Instead of using Math.max() to choose the winning path, you use addition (+) to aggregate all valid paths.T
 * <p>
 * he Exit Door: If your pointer reaches the end of the sequence, the universe survived.
 * <p>
 * Return 1 to add this successful run to the total count.
 * <p>
 * The Landmine: If you hit an invalid state (like a string starting with '0'), this universe is dead.
 * <p>
 * Return 0 so it contributes nothing to the count.
 * <p>
 * The Engine:int ways = 0;
 * <p>
 * Choice 1 (Always valid if not '0'): ways += helper(index + 1);
 * <p>
 * Choice 2 (Conditional): If the next two digits are valid (e.g., <= 26), ways += helper(index + 2);
 * <p>
 * Known States (Base Cases):index == string.length $\rightarrow$ return 1. (Successfully reached the end).
 * <p>
 * string.charAt(index) == '0' $\rightarrow$ return 0. (Invalid state, dead end).
 * <p>
 * The Memory: Integer[] dp = new Integer[n]. Since only the 1D index moves forward, a single array perfectly captures the state. Indexing is dp[index].
 * <p>
 * Time Complexity: $O(n)$. There are $n$ indices in the string. You visit each index once, doing constant $O(1)$ work (just a couple of if checks and string parsing).
 * <p>
 * Space Complexity: $O(n)$ for the 1D memo table + $O(n)$ for the recursion stack depth.
 *
 */
public class DecodeWays {
    public int numDecodings(String s) {

        Integer[] dp = new Integer[s.length()]; // At worst case we will have to store the number of ways for each index
        return helper(0, s, dp);
    }

    private int helper(int i, String s, Integer[] dp) {

        // If we reach the end of the String we decoded it successfully
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0; // If we encounter a '0' we cannot decode it
        }

        // Always check the memo at top
        if (dp[i] != null) {
            return dp[i];
        }

        // Since we know the string is not start with zero, single letter decode is always possible
        int ways = helper(i + 1, s, dp);

        // If we have more than one character , two letter is also possible
        // current character plus the next character should be less than or equal to 26
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            ways += helper(i + 2, s, dp);
        }

        dp[i] = ways; // Save at the bottom


        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226")); // 3
        System.out.println(new DecodeWays().numDecodings("12")); // 2
        System.out.println(new DecodeWays().numDecodings("06")); // 0
        System.out.println(new DecodeWays().numDecodings("11111")); // 8
    }
}
