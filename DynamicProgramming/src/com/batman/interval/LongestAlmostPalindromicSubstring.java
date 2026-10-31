package com.batman.interval;

// Bumd@ Problem
public class LongestAlmostPalindromicSubstring {

    // Not Passing Answer . Time will exceed .
    public int almostPalindromic(String s) {

        int maxLength = 0;

        Boolean[][] palindrome = new Boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {

            int l = i;
            int r = i;
            // Odd length palindrome , keep i as center and expand both sides
            while (l >= 0 && r < s.length()) {
                if (isValid(s, l, r, false,palindrome)) {
                    maxLength = Math.max(maxLength, r - l + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            // Even length palindrome , keep i and i+1 as center and expand both sides
            while (l >= 0 && r < s.length()) {
                if (isValid(s, l, r, false,palindrome)) {
                    maxLength = Math.max(maxLength, r - l + 1);
                }
                l--;
                r++;
            }

        }

        return maxLength;
    }

    boolean isValid(String s, int l, int r, boolean skipUsed,Boolean[][] palindrome) {

        if(palindrome[l][r] != null) return palindrome[l][r];

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            if (skipUsed) return false;
            return isValid(s, l + 1, r, true,palindrome) || isValid(s, l, r - 1, true,palindrome);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestAlmostPalindromicSubstring().almostPalindromic("abca")); // 4
        System.out.println(new LongestAlmostPalindromicSubstring().almostPalindromic("abcda")); // 3
        System.out.println(new LongestAlmostPalindromicSubstring().almostPalindromic("abcd")); // 1
        System.out.println(new LongestAlmostPalindromicSubstring().almostPalindromic("abccba")); // 6
    }
}
