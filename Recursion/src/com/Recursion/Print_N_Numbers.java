package com.Recursion;

public class Print_N_Numbers {
	public static void main(String[] args) {
		print(1);
	}

	static void print(int n) {
		if (n == 11) {// Base Condition
			return;// ->it goes to the previous call n=10;
		}
		System.out.println(n);
		print(n + 1);// Tail Recursion

	}
}
