package com.batman.interval;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        // The Problem is not finding the common subsequences, it is the number of ways we can form t from s. So we need to explore all the possibilities.
        return helper(s, t, 0, 0, dp);
    }

    private int helper(String s, String t, int i, int j, Integer[][] dp) {
        if(j == t.length()) return 1; // If we have matched the entire t, we found a valid subsequence
        if(i == s.length()) return 0; // If we have exhausted s and haven't matched t, return 0

        if(dp[i][j] != null) return dp[i][j]; // Check memoization

        // First Scenario : Characters Match
        if(s.charAt(i) == t.charAt(j)) {
            // We can either take this character or skip it
            // This is the main crux of the problem, we need to explore both possibilities and add them up.
            // On match, we are guaranteed that we can move both pointers, but we can also skip the character in s and try to match the next character in s with the current character in t.
            dp[i][j] = helper(s, t, i + 1, j + 1, dp) + helper(s, t, i + 1, j, dp);
        } else {
            // Characters don't match, we can only skip the character in s
            dp[i][j] = helper(s, t, i + 1, j, dp);
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit")); // 3
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag")); // 5
    }
}
