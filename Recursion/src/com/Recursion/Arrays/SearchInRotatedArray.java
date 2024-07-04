package com.Recursion.Arrays;

public class SearchInRotatedArray {
public static void main(String[] args) {
	int []arr= {4,5,6,6,7,0,1,1,2};
	System.out.println(searchIndex(arr, 1, 0, arr.length-1));
}
public static int searchIndex(int[] arr,int target,int s , int e) {
	if(s>e) {
		return -1;
	}
	int mid = s + (e-s)/2;
	if(arr[mid]==target) {
		return mid;
	}
	if(arr[s]<=arr[mid]) {
		if(arr[s]<=target&&target<=arr[mid]) {
			return searchIndex(arr, target, s, mid-1);
		}else {
			return searchIndex(arr, target, mid+1, e);
		}
	}
	if(target>=arr[mid]&&target<=arr[e]) {
		return searchIndex(arr, target, mid+1, e);
	}
	
	return searchIndex(arr, target, s, mid-1);
}
}
