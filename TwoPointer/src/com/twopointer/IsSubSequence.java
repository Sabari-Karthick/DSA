package com.twopointer;

/**
 * This is a straightforward two pointer problem.
 * How ? Again we need to traverse both strings in a parallel manner.
 *
 * We maintain two pointers, one for each string.
 * The main part is if the first pointer's character matches the second pointer's character, we move the first pointer ahead.
 * Regardless of whether there is a match or not, we always move the second pointer ahead.
 *
 * At the end, if the first pointer has traversed the entire string, it means all characters were found in sequence in the second string.
 *
 * Time Complexity: O(N) where N is the length of string t.
 * Space Complexity: O(1) as we are using only two extra variables.
 *
 * There is a follow up to this question where we have multiple s strings to check against a single t string.
 * Like wise s1, s2, s3 ... sk.
 *
 * In that case, we can pre-process string t to create a mapping of each character to its indices in t.
 * Meaning for each character in t, we store a list of all the positions it appears in t.
 * That would be like a HashMap<Character, List<Integer>>. Eg : 'a' -> [0, 5, 10], 'b' -> [1, 6, 11] etc.
 *
 * Then for each s string, we can use binary search to efficiently find the next occurrence of each character in t.
 *
 * So say there are two s like s1 = "abc", s2 = "axc". and t = "ahbgdc".
 *
 * The processing of t would give us a mapping like:
 *  'a' -> [0], 'b' -> [2], 'c' -> [5], 'd' -> [4], 'g' -> [3], 'h' -> [1]
 *
 *  For s1 = "abc":
 *  We find 'a' at index 0 in t, then 'b' at index 2, and 'c' at index 5. All in order, so s1 is a subsequence of t.
 *
 *  For s2 = "axc":
 *  We find 'a' at index 0 in t, but 'x' is not present in t. So s2 is not a subsequence of t.
 *
 *  So we can just check the map for each character in s and use binary search on the list of indices to find the next valid position in t.
 *
 *  If the list of indices for a character is empty or if we can't find a valid position, we can immediately conclude that s is not a subsequence of t.
 *
 *
 * https://leetcode.com/problems/is-subsequence
 */
public class IsSubSequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t)); // Output: true
    }

    private static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;

        // We can always add an early return condition
        if (s.isEmpty()) {
            return true;
        }

        // We need both pointers to traverse their respective strings

        while ((p1 < s.length()) && (p2 < t.length())) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        // At this point, Both have traversed their strings
        // But p1 would have not traversed the entire string if it is not a subsequence, if it didn't find the match for each of its characters in t.

        // So we can say there is a subsequence only if p1 has traversed the entire string s.

        return p1 == s.length();

    }
}
