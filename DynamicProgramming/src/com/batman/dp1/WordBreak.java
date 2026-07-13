package com.batman.dp1;

import java.util.*;

public class WordBreak {

    private static final Map<String, Boolean> memo  = new HashMap<>(); // It stores the recursive results not whether the word exists in dic or not
    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }

    // What's the Brute Force ??
    // We can cut the string in each of its gap so it is 2 ^ (N - 1) ways and then with those chunks and we can run the loop
    // This is exponential time complexity

    // Other way instead of cutting the string in each gap we can check if the string is present in the dictionary or not and then we can check for the remaining string and so on
    // That is DFS

    // But if you see with different combination we may get into check the same word again and again is in dictionary if we use plain loop
    // With Plain DFS we get Time Exceed . So We need memorization
    public static boolean wordBreak(String s, List<String> wordDict) {

        if(memo.containsKey(s)) return memo.get(s); // Means we already went through this Branch

        if(wordDict.contains(s)){ // Avoid this by having a empty check plus running loop till the length
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
}
