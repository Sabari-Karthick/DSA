package com.batman.dp1;

import java.util.*;


/**
 *
 * The Flag: Single string + "Dictionary of words" + "Can it be segmented/broken completely?" + returning a True/False boolean.
 * <p>
 * The Intuition: The Telegraph Operator. You cannot greedily take the first valid word you see (e.g., taking "apple" might ruin "applepen"). You must try every valid prefix.
 * <p>
 * The Sliding Finger: Anchor your left finger. Slide a right finger forward.
 * <p>
 * The Cut: The moment the chunk between left and right forms a valid dictionary word, you have permission to make a cut.
 * <p>
 * The Delegation: Jump your left finger to the cut point, and recursively ask if the rest of the string can be broken. If the rest of the string survives the maze (returns true), the whole string is valid.
 * <p>
 * Time Complexity: $O(n^3)$.There are $n$ states (your left finger positions).
 * <p>
 * Inside each state, the for loop runs up to $n$ times
 * <p>
 * .Inside the loop, s.substring() physically copies the string, which takes $O(n)$ time. $n \times n \times n = n^3$. (Note: You can optimize this in advanced rounds by using a Trie, but $O(n^3)$ is the standard accepted DP solution).
 * <p>
 * Space Complexity: $O(n)$ for the 1D memoization table + $O(n)$ for the recursion stack depth.
 *
 *
 */
public class WordBreak {

    private static final Map<String, Boolean> memo = new HashMap<>(); // It stores the recursive results not whether the word exists in dic or not

    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println("-----");
        System.out.println(new WordBreak().wordBreak2("leetcode", List.of("leet", "code"))); // true
        System.out.println(new WordBreak().wordBreak2("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(new WordBreak().wordBreak2("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }

    // What's the Brute Force ??
    // We can cut the string in each of its gap so it is 2 ^ (N - 1) ways and then with those chunks and we can run the loop
    // This is exponential time complexity

    // Other way instead of cutting the string in each gap we can check if the string is present in the dictionary or not and then we can check for the remaining string and so on
    // That is DFS

    // But if you see with different combination we may get into check the same word again and again is in dictionary if we use plain loop
    // With Plain DFS we get Time Exceed . So We need memorization
    public static boolean wordBreak(String s, List<String> wordDict) {

        if (memo.containsKey(s)) return memo.get(s); // Means we already went through this Branch

        if (wordDict.contains(s)) { // Avoid this by having a empty check plus running loop till the length
            memo.put(s, true); // Whole word is valid means no branch needed
            return true;
        }

        // Start at index 1 the first word
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            // Check if the left word is in the dictionary
            if (wordDict.contains(left)) {
                // We need to now know whether the remaining part is valid
                if (wordBreak(right, wordDict)) {
                    memo.put(s, true); // Remember that the we are storing the process we took so that we dont do do it again not the words for that is dictionary for
                    return true;
                } // Else Continue the loop
            }

        }

        memo.put(s, false);
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return helper(s, 0, dp, wordDict);
    }

    private boolean helper(String s, int left, Boolean[] dp, List<String> wordDict) {
        if (left == s.length()) return true; // We reached the end of the string

        if (dp[left] != null) return dp[left];

        for (int i = left + 1; i <= s.length(); i++) { // Left + 1 is because , substring is exclusive of the end index so we need to go till the length of the string
            // Same we need to go till the length so that we get the exclusion to include the last character
            String word = s.substring(left, i);
            if (wordDict.contains(word) && helper(s, i, dp, wordDict)) {
                dp[left] = true;
                return true;
            }
        }


        if (dp[left] == null) dp[left] = false;
        return dp[left];
    }
}
