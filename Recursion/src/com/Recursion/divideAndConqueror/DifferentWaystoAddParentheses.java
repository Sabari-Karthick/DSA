package com.Recursion.divideAndConqueror;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * 
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description
 * 
 * 
 */
public class DifferentWaystoAddParentheses {

}



class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // Base case: if the expression is just a number, return it as a result
        List<Integer> result = new ArrayList<>();
        
        // Iterate through the expression and look for operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is an operator, split the expression into two parts
            if (c == '+' || c == '-' || c == '*') {
                // Recursively compute the result for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine results from left and right parts based on the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // If the result list is still empty, it means the expression is a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}
