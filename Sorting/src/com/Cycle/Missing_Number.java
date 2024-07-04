package com.Cycle;
//https://leetcode.com/problems/missing-number/
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class Missing_Number {
public static void main(String[] args) {
	int arr[] = {4,2,0,3,1,6,5,8};
	int nuber = findMissingNuber(arr);
	System.out.println(nuber);
}

private static int findMissingNuber(int[] arr) {
	
	//in sorted  version element will be at its index
	
	int i=0;
	while(i<arr.length) {
		if(i!=arr[i]&&arr[i]<arr.length)//to ignore if the end index 
		{
			swap(arr, i, arr[i]);
			
		}else {
			i++;
		}
	}
	for(int j=0;j<arr.length;j++) {
		if(arr[j]!=j) {
			return j;
		}
	}
	
	
	return arr.length;
	
}
private static void swap(int []arr,int a,int b) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}
}
