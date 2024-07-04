package com.stack;

import java.util.Stack;

public class Minimumaddtomakeparanthesesvalid {
public static void main(String[] args) {
	Solution solution = new Solution();
	int minAddToMakeValid = solution.minAddToMakeValid("())(");
	System.out.println(minAddToMakeValid);
}
}
//
class Solution {
    public int minAddToMakeValid(String s) {
         if(s.isEmpty()){
           return 0;
       }
       Stack<Character> stack = new  Stack<>();

       for(char c : s.toCharArray()){
           if(c=='('){
               stack.push(c);
          
           }else{
               if(c==')'){
                   if(!stack.isEmpty() && stack.peek()=='('  ){
                       stack.pop();
                   }else{
                       stack.push(c);
                   }
               }
               
           }
       }
       return stack.size();
        
    }
}