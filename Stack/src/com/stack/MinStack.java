package com.stack;

import java.util.Stack;

//https://leetcode.com/submissions/detail/1314150015/
public class MinStack {

}
class MinnStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
   
    public MinnStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        val = Math.min(val , minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
       return  stack.peek();
    }
    
    public int getMin() {
       return  minStack.peek();
    }
}