package com.batman.dp1;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, 0, 0, dp);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (i + j == s3.length()) return true; // If we have matched the entire s3, we found a valid interleaving

        if (dp[i][j] != null) return dp[i][j]; // Check memoization

        // First Scenario : Characters Match
        boolean firstStringMatch = i < s1.length() && s1.charAt(i) == s3.charAt(i + j);

        boolean secondStringMatch = j < s2.length() && s2.charAt(j) == s3.charAt(i + j);
        if(firstStringMatch && secondStringMatch) {
            // We can either take this character from s1 or from s2
            dp[i][j] = helper(s1, s2, s3, i + 1, j, dp) || helper(s1, s2, s3, i, j + 1, dp);
        } else if(firstStringMatch) {
            // We can only take this character from s1
            dp[i][j] = helper(s1, s2, s3, i + 1, j, dp);
        } else if(secondStringMatch) {
            // We can only take this character from s2
            dp[i][j] = helper(s1, s2, s3, i, j + 1, dp);
        } else {
            // Characters don't match
            dp[i][j] = false;
        }

        return dp[i][j];


    }
}
