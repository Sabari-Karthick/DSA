package com.array.medium;
/**
 * https://leetcode.com/problems/permutation-in-string/description/
 * 
 * Main thing do not confuse with the permutation the main idea is to find whether there is an anagram exist within a particular window of the size of the s1.
 * May be refer isAnagram Problem
 * 
 */
public class PermutationInString {

}

class Solutionag47rew {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) return false;
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i = 0 ; i < s1.length(); i++){ // For first window
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        
        for(int i = 0;i< s2.length() - s1.length() ; i++){
            if(match(s1Map,s2Map)) {
                return true;
            }
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new
            // window
            s2Map[s2.charAt(i + s1.length()) - 'a']++;
            s2Map[s2.charAt(i) - 'a']--;


        }
        return match(s1Map,s2Map);
    }

    private boolean match(int[] arr1 , int[] arr2){
        for(int i = 0; i<26 ;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}