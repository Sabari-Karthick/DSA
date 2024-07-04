package com.Recursion;

import java.util.Arrays;
/**
 * @author _karthick
 * 
 * F(N)  = O(1) (comparison) + F(N/2)(search in half)
 * 
 * 
 *
 */
public class BinarySearch_Recursion {

	public static void main(String[] args) {
		int arr[] = { -4, 3, 5, 603, 647, 25134, 23, 0, 34, 12, 9836, 357401, 32, 67, 54 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 357401,0,arr.length-1));
	}

	private static int binarySearch(int[] arr, int target,int start,int end) {//s,e determine the call so they are passed in the argument
		if(start>end) {
			return -1;
		}
		int mid = start + (end - start)/2;//this is specific to that call // arguments in body
		if(arr[mid]==target) {
			return mid;
		}
	   if(arr[mid]>target) {
			return binarySearch(arr, target, start, mid-1);
		}
			return binarySearch(arr, target, mid+1, end);
		
		
	}

}
