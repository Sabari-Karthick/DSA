package com.Linear;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenDigits {
	public static void main(String[] args) {
		int[] arr = { 34, 321, 1, 4673, 24, 12345678, 3, 890, 1000 };

		System.out.println(findNumbers(arr));
	}

	static int findNumbers(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (even(num))
				count += 1;
		}
		return count;
	}

	/*
	 * static boolean even(int num) { String s = num+""; if(s.length()%2==0) return
	 * true; return false; }
	 */
	static boolean even(int num) {
		/*
		 * int count = 0; while(num>0) { count++; num/=10; } if(count%2==0) return true;
		 * return false;
		 */

		return ((int) Math.log10(num) + 1) % 2 == 0;
	}
}
