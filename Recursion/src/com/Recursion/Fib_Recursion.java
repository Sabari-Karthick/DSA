package com.Recursion;
//Time Complexity ; Golden ratio power N
public class Fib_Recursion {

	public static void main(String[] args) {
		int ans = fib(2);
      System.out.println(ans);
	}
	 static int fib(int n) {
		if(n<2) {//this is the base as f(0)=0,f(1)=1
			return n;
		}
		return fib(n-1)+fib(n-2);//it is not tail recursion
	}

}
