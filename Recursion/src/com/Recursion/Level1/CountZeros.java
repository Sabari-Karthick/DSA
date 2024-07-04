package com.Recursion.Level1;

public class CountZeros {
private static int count = 0;;

public static void main(String[] args) {
      count(100003);
      System.out.println(count );
      System.out.println(count1(10400530));
}

private static int count(int i) {
	if(i%10==i) {
		return i;
	}
	int rem = i%10;
	if(rem==0) {
		count++;
	}
	return count(i/10);
}
private static int count1(int i) {
	return helper(i,0);
}

private static int helper(int num, int count) {
	if(num==0) {
		return count;//return the same value in the function call
	}
	
	int rem = num%10;
	if(rem==0) {
		return helper(num/10, count+1);
	}
	return helper(num/10, count);
	
}
}
