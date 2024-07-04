package com.Recursion.Level1;

public class SumOfDigits {
public static void main(String[] args) {
	System.out.println(sumOfDigit(1342));
}

private static int sumOfDigit(int i) {
	if(i%10==i) {
		return i;
	}
	
	return i%10  + sumOfDigit(i/10);
//	return i%10  * sumOfDigit(i/10);
}
}
