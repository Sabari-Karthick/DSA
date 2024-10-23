package com.hashing;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * 
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
 * O(M + n)
 * O(M)
 */
public class LengthOfLongestCommonPrefix {

}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefix = new HashSet<>();
        for(int i : arr2){
            while(i != 0 && !prefix.contains(i)){
                prefix.add(i);
                i/=10;
            }
        }
        int res = 0;
        for(int n : arr1){
            while(n!= 0 && !prefix.contains(n)){
                n /=10;
            }
            
            if(n != 0){// a case where prefix exists
                  res = Math.max(res,String.valueOf(n).length());
            }

        }
        return res;
    }
}