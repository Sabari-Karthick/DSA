package com.Linear;
//https://leetcode.com/problems/richest-customer-wealth/description/
public class MaxWealth {
	public static void main(String[] args) {
		int [][]arr = {
				{3,6,7},
				{34,76,21,9,19},
				{1,2,4,1000}
		};
		System.out.println(maximumWealth(arr));
	}
	 public static int maximumWealth(int[][] accounts) {
	        int maxWealth = 0;
	        for (int[] account : accounts) {
	        int maxWealthPerson = 0;

	            for (int element : account) {
	                maxWealthPerson += element;
	            }
	            if(maxWealthPerson>maxWealth)
	                   maxWealth = maxWealthPerson;
	        }
	        return maxWealth;
	    }

}
