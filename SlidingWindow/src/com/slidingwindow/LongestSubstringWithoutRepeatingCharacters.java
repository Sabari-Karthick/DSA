package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
public static void main(String[] args) {
	System.out.println(lengthOfLongestSubstring("pwwkew"));
}
public static int lengthOfLongestSubstring(String s) {//It wont work for the repeating characters between l and r
    int l = 0;
    int r = 1;
    char[] c = s.toCharArray();
    int ans = 0;
    while(r<c.length){
       if(c[r-1] == c[r]){
          String currentMaxSubString = s.substring(l,r);
          ans = Math.max(currentMaxSubString.length(),ans);
          l=r;
       }
       r++;
    }
    return ans;
}
}
class Solution45sg { // O(N ^ 2) Solution // Not pure Sliding window
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        List<Character> substringL = new ArrayList<>();
        int ans = 0;
        while(r<s.length()){
           if(substringL.contains(s.charAt(r))){
             int index = substringL.indexOf(s.charAt(r));
             substringL.remove(index);
             if(index > 0){
                substringL.subList(0,index).clear();
             }
           }
           substringL.add(s.charAt(r));
           ans = Math.max(substringL.size(),ans);
           r++;
        }
        return ans;
    }
}
class Solution {// O(1)
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        int l = 0;
        Set<Character> c = new HashSet<>();
        int ans = 0;
        while(r<s.length()){
           if(c.contains(s.charAt(r))){
              //now the current character at which l points to needs to be removed as that is no longer considered and we start with the next window
              c.remove(s.charAt(l));
              l++;
           }else{

           c.add(s.charAt(r));
           ans = Math.max(ans,r - l +1);//Update With Current Window Length
           r++;
           }
        }
        return ans;
    }
}