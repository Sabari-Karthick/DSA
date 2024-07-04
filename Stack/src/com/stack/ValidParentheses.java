package com.stack;

public class ValidParentheses {

}
//we need to keep the track of the characters in the string so stack will be used

//class Solution {
//    public boolean isValid(String s) {
//        if(s.isEmpty()){
//            return true;
//        }
//        Stack<Character> stack = new  Stack<>();
//        for(char c : s.toCharArray()){
//            if(c=='('||c=='{'||c=='['){
//                stack.push(c);
//            }else{
//                if(c==')'){
//                    if(stack.isEmpty() || stack.pop()!='('  ){
//                        return false;
//                    }
//                }
//                 if(c==']'){
//                    if(stack.isEmpty() ||  stack.pop()!='[' ){
//                        return false;
//                    }
//                }
//                 if(c=='}'){
//                    if( stack.isEmpty() || stack.pop()!='{' ){
//                        return false;
//                    }
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//}