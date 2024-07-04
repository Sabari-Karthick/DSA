package com.Recursion.Arrays;
//Since Java is Pass By value of the reference if the array is modified in any of one call it reflects in the subsequent calls
public class IsSorted {
	public static void main(String[] args) {
          int arr[] = {1,3,5,7,2};
          System.out.println(isSorted(arr));
	}
	public static boolean isSorted(int []arr) {
		return helper(arr,0);
	}
	private static boolean helper(int[] arr, int i) {
		if(arr.length==i+1) {
			return true;
		}
		return arr[i]<arr[i+1]&& helper(arr, i+1);
	}
}
