package com.stack;

import java.util.Stack;

/**
 * 
 * 
 * A monotonic stack is a special data structure used in algorithmic problem-solving.
 * Monotonic Stack maintaining elements in either increasing or decreasing order. 
 * It is commonly used to efficiently solve problems such as finding the next greater or smaller element in an array etc.
 * 
 * 
 * 
 */
public class DailyTemperature {

}

class Solutionnm {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int curr = 0 ; curr < temperatures.length ; curr ++){
            while( !stack.isEmpty() && temperatures[curr] > temperatures[stack.peek()]){
                int prev = stack.pop();
                ans[prev] = curr - prev;
            }
            stack.push(curr);
        }
        return ans;
    }
}

