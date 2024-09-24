package com.trie.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/extra-characters-in-a-string/description
 * 
 * The Current Implementation is Using DP/Memorization it needs to be optimized Using Trie
 */
public class ExtraCharactersInString {
	public static void main(String[] args) {
	}
}
class Solution46g48sg57sf {
    Set<String> words;
    Map<Integer,Integer> dp = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        words = new HashSet<>(Arrays.asList(dictionary));
        dp.put(s.length(),0);
        return DFS(0,s);
    }

    public int DFS(int index,String s){
        // if(index == s.length()) return 0; // Replace it with cache
       // int res = len(s) - index; // not needed // Since we need to minimize
        if(dp.containsKey(index))  return dp.get(index);
        int res = 1 + DFS(index +1 ,s);//Skip the index // We no need to initialize since if there are no match the res would be to the thing len(s) - index. which is the thing we need to intialize
        for(int cur=index;cur<s.length();cur++){
            String subword = s.substring(index,cur+1);
            if(words.contains(subword)){
                res = Math.min(res,DFS(cur+1,s));// ensure that you are not missing the rest of the string.
            }
            dp.put(index,res);
        }
        return res;
    }
}