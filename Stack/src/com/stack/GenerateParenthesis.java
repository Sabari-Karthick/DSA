package com.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParenthesis {

}

class Solution902 {
	Stack<Character> stack = new Stack<>();
	List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		backtrack(0, 0, n);
		return res;
	}

	public void backtrack(int open, int close, int n) {
		if (close == open && close == n) {
			@SuppressWarnings("rawtypes")
			Iterator itr = stack.iterator();
			String ans = "";
			while (itr.hasNext()) {
				ans += itr.next();
			}
			res.add(ans);
		}

		if (open < n) {
			stack.add('(');
			backtrack(open + 1, close, n);
			stack.pop();
		}

		if (close < open) {
			stack.add(')');
			backtrack(open, close + 1, n);
			stack.pop();
		}
	}
}