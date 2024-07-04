package com.Cycle;
//Given an unsorted integer array nums, return the smallest missing positive integer.
//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] arr = {3,4,-1,1};//ignore negatives since the question asks only positive
		int ans = findFirstMissingPositive(arr);//since the first positive starts from 1 and goes to end it is cycle start
		System.out.println(ans);
	}

	private static int findFirstMissingPositive(int[] arr) {
		int i=0;
		while(i<arr.length)
		{
			int correctIndex=arr[i]-1;
			if(arr[i]>0&&arr[i]<=arr.length&&arr[i]!=arr[correctIndex]) {
				swap(arr, i, correctIndex);
			}else {
				i++;
			}
		}
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]!=j+1) {
				return j+1;
			}
		}
		return arr.length+1;
	}
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
