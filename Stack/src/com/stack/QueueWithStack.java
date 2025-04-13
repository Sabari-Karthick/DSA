package com.stack;

import java.util.Arrays;


//With one stack removal will always be O(N)
public class QueueWithStack {//with one stack we cannnot create this we need two stacks -> but it is not efficient
//there are two ways 
//Insertion Efficient	 //Insertion takes constant by enque in the first and deque in the second - > in this insertion is O(1)  AND The deletion is O(N)
//Remove Efficient -> 
	public static void main(String[] args) {
		String s = "Hello Hi Bye";
		
		String[] split = s.split(" ");
		System.out.println(Arrays.toString(split));
	}
}


/**
 class MyQueue {//Insert Efficient
    
    private Stack<Integer> first;
    private Stack<Integer> second;
      
    
    public MyQueue() {
         first= new Stack<>();
         second= new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int item = second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return item;
    }
    
    public int peek() {
         while(!first.isEmpty()){
            second.push(first.pop());
        }
        int item = second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return  item;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */