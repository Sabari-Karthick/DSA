package com.Recursion.Level1;

@SuppressWarnings("unused")
public class ReverseNumber {
	public static void main(String[] args) {
		int ans = rev(12345);
		System.out.println(ans);
	}

	static int sum = 0;

	private static void reverse(int n) {
		if (n == 0) {
			return;
		}
		int rem = n % 10;
		sum = sum * 10 + rem;
		reverse(n / 10);
	}
	
	private static int rev(int n) {//sometimes you need extra variables as arguments in that case create another function
		
		int digits = (int) (Math.log10(n))+1;
		
		
		return helper(n,digits);
	}

	private static int helper(int n, int digits) {
		if(n%10==n) {//for the last digit
			return n;
		}
		int rem = n%10;
		return (int) (rem * Math.pow(10, digits-1) + helper(n/10, digits-1));
	}
}
