package com.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
 * 
 * 
 */
public class MinimumStringLengthAfterRemovingSubstrings {

}

class Solution {
    public int minLength(String s) {
        Deque<Character> stk = new ArrayDeque<>(); // We are ideally using it as a stack
        stk.offer(' ');// to avoid isEmpty check

        for(char c : s.toCharArray()){
             if((c == 'B' && stk.peek() == 'A') ||  (c == 'D' && stk.peek() == 'C')){
                  stk.poll();
             }else{
                stk.offerFirst(c);
             }
        }
        return stk.size()-1;
    }
}
