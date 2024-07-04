package com.Recursion.Level1;

public class Palindrome {
	public static void main(String[] args) {

		System.out.println(isPallindrome(1221));
	}

	private static boolean isPallindrome(int num) {
		int digits = (int) (Math.log10(num)) + 1;

		return helper(num, digits) == num;
	}

	private static int helper(int num, int digits) {
		if (num % 10 == num) {
			return num;
		}
		int rem = num % 10;

		return (int) (rem * Math.pow(10, digits - 1) + helper(num / 10, digits - 1));
	}

}
