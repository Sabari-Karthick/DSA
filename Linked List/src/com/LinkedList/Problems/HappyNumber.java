package com.LinkedList.Problems;
//https://leetcode.com/problems/happy-number/
public class HappyNumber {
	public static void main(String[] args) {
              System.out.println(isHappyNumber(2));
	}
	
    static boolean 	isHappyNumber(int n) {
    	
    	 int tortoise = n;
    	 int hare = n;
    	 
    	 while(true) {
    		 tortoise = squareSum(tortoise);
    		 hare =squareSum(squareSum(hare));
    		 if(tortoise==hare) {
    			 break;
    		 }
    	 }
    	 if(tortoise==1) {
    		 return true;
    	 }
    	
    	
    	
    	return false;
    }
    static int squareSum(int num) {
		if (num % 10 == num) {
			return num * num;
		}
		int rem = num % 10;

		return rem * rem + squareSum(num / 10);

	}
}
