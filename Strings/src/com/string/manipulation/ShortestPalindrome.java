package com.string.manipulation;
/**
 * 
 * 
 * https://leetcode.com/problems/shortest-palindrome/description
 * There is a faster approach than this is O( N ^ 2) but takes more time
 */
public class ShortestPalindrome {

}
class Solution1234 {
    public String shortestPalindrome(String s) {
        for (int r = s.length() - 1; r >= 0; r--) {
            if (isPalindrome(s, 0, r)) {
                String suffix = s.substring(r+1);//to get the remaining string other than the palindrome
                return new StringBuilder(suffix).reverse().toString() + s;
            }
        }
        return "";
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}