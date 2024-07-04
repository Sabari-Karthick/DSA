package com.Cycle;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 * When numbers given from range 1 to N(Continuous) Use cyclic sort
 * Or finding a number in the range 1 to N
 * Worst Case : (N-1)+N = O(N)->Linear
 * Best Case  : N       = O(N)
 *
 */
public class CycleSort {
public static void main(String[] args) {
	 int arr[] = {4,3,2,7,8,2,3,1};
	 cyclicSort(arr);
      System.out.println(Arrays.toString(arr));
}

private static void cyclicSort(int[] arr) {
	int i=0;
	while(i<arr.length) {
	int correctIndex = arr[i]-1; 
		if(arr[i] != arr[correctIndex] ) {//that element should be in its corect index
			swap(arr, i, correctIndex);
		}else {
			i++;
		}
	}
	
}
public static void swap(int arr[],int a,int b) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}
}

