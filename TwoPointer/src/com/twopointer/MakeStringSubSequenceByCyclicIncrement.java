package com.twopointer;
/**
 * 
 * 
 * 
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
 * 
 * 
 * 
 */
public class MakeStringSubSequenceByCyclicIncrement {

}
class Solution239i {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length())
            return false;
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            int diff = str1.charAt(i) - str2.charAt(j);
            if (diff == -1 || diff == 25 || diff == 0) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return  j == str2.length();
    }
}