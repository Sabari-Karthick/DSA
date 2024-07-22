package com.stack;

import java.util.Stack;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?source=submission-noac
public class ReversePolishCalculation {
// the maximum number of operands 𝑘 k in the worst case would be approximately 𝑁 / 2 + 1 N/2+1, where 𝑁 N is the length of the array.
}
class Solutionx {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                if (stack.size() >= 2 ) {
                    int first =stack.pop();
                    int second = stack.pop();
                    stack.push(first + second);
                } 
            } else if (s.equals("*")) {
                if (stack.size() >= 2 ) {
                       int first =stack.pop();
                    int second = stack.pop();
                    stack.push(first * second);
                } 
            } else if (s.equals("/")) {
                if (stack.size() >= 2) {
                        int first =stack.pop();
                    int second = stack.pop();
                    stack.push( second / first);
                }
            }else if (s.equals("-")) {
                if (stack.size() >= 2) {
                        int first =stack.pop();
                    int second = stack.pop();
                    stack.push( second - first);
                } 
            }  else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}