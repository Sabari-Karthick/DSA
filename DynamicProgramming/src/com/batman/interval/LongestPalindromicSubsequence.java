package com.batman.interval;

/**
 * The Flag: Single string/array + "Palindrome" + "Subsequence" + "Longest".
 * <p>
 * The Intuition: The "Vice Grip" method. Palindromes are perfectly symmetrical from the outside in.
 * <p>
 * Place your fingers on the extreme outer boundaries (start, end).
 * <p>
 * The Match: If the outer characters match, they form the outer shell of your palindrome.
 * <p>
 * Claim them (+2 length) and squeeze both fingers inward to see what's inside.
 * <p>
 * The Mismatch: If they don't match, you physically cannot use both in your palindrome.
 * <p>
 * You must throw one away.
 * <p>
 * Branch into two parallel universes: throw away the left character (squeeze left) OR throw away the right character (squeeze right).
 * <p>
 * Keep whichever universe yields the longer result.
 * <p>
 * The Formula:
 * <p>
 * If arr[s] == arr[e]: 2 + helper(s + 1, e - 1)
 * <p>
 * If arr[s] != arr[e]: Math.max(helper(s + 1, e), helper(s, e - 1))
 * <p>
 * Known States
 * <p>
 * (Base Cases):s == e $\rightarrow$ return 1. (Fingers landed on the exact same character; it's a palindrome of length 1).
 * <p>
 * s > e $\rightarrow$ return 0. (Fingers crossed each other; the string is empty).
 * <p>
 * The Memory: Integer[][] dp = new Integer[n][n]. Indexing is always dp[start][end].
 * <p>
 * Time Complexity: $O(n^2)$. You have $n^2$ possible (start, end) combinations. Unlike the Knife Cut which requires a for loop inside, the Vice Grip only does $O(1)$ constant work (just checking an if statement and taking a Math.max).
 * <p>
 * Space Complexity: $O(n^2)$ for the 2D memoization table + $O(n)$ for the recursion stack (the deepest the recursion goes is $n$ steps if it constantly mismatches and shrinks one letter at a time).
 *
 *
 *
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, dp);
    }

    private int helper(String str, int s, int e, Integer[][] dp) {
        if (s == e) return 1; //We are at the center so it is a valid single palidrome
        if (s > e) return 0; // We cant compare anything

        // Always check the memo at top
        if (dp[s][e] != null) return dp[s][e];

        // First Scenario
        // We get our s and e matched
        if (str.charAt(s) == str.charAt(e)) {
            dp[s][e] = 2 + helper(str, s + 1, e - 1, dp); // We can move both pointers and add 2 to the count
            return dp[s][e];
        }

        // Else we need to explore two options
        int leftRemoved = helper(str, s + 1, e, dp); // We remove the left character and move the left pointer
        int rightRemoved = helper(str, s, e - 1, dp); // We remove the right character and move the right pointer
        dp[s][e] = Math.max(leftRemoved, rightRemoved);

        return dp[s][e];

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbabcbcab")); // 7
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd")); // 2
    }
}
