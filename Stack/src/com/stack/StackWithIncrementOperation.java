package com.stack;
/**
 * 
 * 
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
 */
public class StackWithIncrementOperation {

}

class CustomStack123 {

    int[] stack;
    int top = -1;
    public CustomStack123(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(!isFull())
            stack[++top] = x;
    }
    
    public int pop() {
        if(top == -1)
              return -1;
        int item = stack[top];
        stack[top] = 0;
        top--;
        return item;
    }
    
    public void increment(int k, int val) {//There is a way to optimize it by using another increment array
        if(k > stack.length)
           k  = stack.length;
        for(int i = 0;i<k;i++){
            stack[i] += val;
        }
        //  IntStream.range(0, limit).forEach(i -> stack[i] += val);
    }
    public boolean isFull() {
		if(top == stack.length-1) {
			return true;
		}
		return false;
	}
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */