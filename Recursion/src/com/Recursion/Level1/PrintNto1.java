package com.Recursion.Level1;

public class PrintNto1 {
	public static void main(String[] args) {
		//print(5);
		printboth(5);
	}

	@SuppressWarnings("unused")
	private static void print(int n) {
		if(n==0) {
			return;
		}
		//System.out.println(n);
		print(n - 1);
		System.out.println(n);//if 1 to n hold the print statement till reach the end of function call
	}
	private static void printboth(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printboth(n - 1);
		System.out.println(n);
	}
}
