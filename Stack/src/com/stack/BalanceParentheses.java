package com.stack;

public class BalanceParentheses {

}
//class Solution {
//    public int minInsertions(String s) {
//        Stack<Character> stack=new Stack<>();
//        int count=0;
//        for(int i=0;i<s.length();i++){
//// -Keep adding left barckets
//            if(s.charAt(i)=='('){
//                stack.push(s.charAt(i));
//            }else{
//                if(i+1<s.length()&& s.charAt(i+1)==')'){
//                    // -Skip it as two consecutives are present
//                    i++;
//                }else count++;
//                
//                if(!stack.isEmpty()){
//                    stack.pop();
//                }else count++ ;
//            }
//        }
//        count+=2*stack.size();
//        return count;
//    }
//}