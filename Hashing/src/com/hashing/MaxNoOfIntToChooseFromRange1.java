package com.hashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i
 * 
 */
public class MaxNoOfIntToChooseFromRange1 {
}


class Solution132123 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        int sum = 0;
        int count = 0;
        for(int i = 1 ; i <= n ; i ++){
              if(!ban.contains(i)  && sum + i <= maxSum){
                ban.add(i);
                sum+=i;
                count++;
              }
        }
        return count;
    }
}