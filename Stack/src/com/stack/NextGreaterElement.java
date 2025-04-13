package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 */


public class NextGreaterElement {

}

class Solutionu4823y98rgbrfg {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums2){
            while(!stk.isEmpty() && stk.peek() < num){ //Pop all the smaller nums
                //Means it is a greater
                map.put(stk.pop(),num); //For the current top element(i th eleement) in stk the num is the next greater
            }
            stk.push(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }

        return ans;
    }
}