package com.stack;

public class Test {
	public static void main(String[] args) throws Exception {
		CustomStack stack = new CustomStack(20);
//		Stack<Integer> stac = new Stack<>();
//		Collections.min(stac);
		stack.push("Hi");
		stack.push("Hello");
		stack.push("Hoooo");
		stack.push("Bye");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
