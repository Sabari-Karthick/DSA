package com.Recursion.Level1;

public class SumOfSquare {
	public static void main(String[] args) {
		int squareSum = squareSum(19);
		System.out.println(squareSum);

	}

	static int squareSum(int num) {
		if (num % 10 == num) {
			return num * num;
		}
		int rem = num % 10;

		return rem * rem + squareSum(num / 10);

	}
}
