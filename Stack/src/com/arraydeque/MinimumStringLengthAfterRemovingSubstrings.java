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
        Deque<Character> stk = new ArrayDeque<>();
        stk.push(' ');// to avoid isEmpty check

        for(char c : s.toCharArray()){
             if((c == 'B' && stk.peek() == 'A') ||  (c == 'D' && stk.peek() == 'C')){
                  stk.pop();
             }else{
                stk.push(c);
             }
        }
        return stk.size()-1;
    }
}
