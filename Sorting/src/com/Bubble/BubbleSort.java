package com.Bubble;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 *  It is a comparison sort method 
 *  With the first parse the large element came to the end
 *  that is ,, with every i parse the  the i_th largest element reaches it respective place at the worse
 *  Also called sinking, exchanging sort
 *  
 *  Space complexity is constant : O(1)
 *  Sorting algorithms using Constant space are called in place sorting algorithms
 *  Time complexity at 
 *                   Best:O(1 * N-1)->O(N) -> Sorted -> no swap
 *                   Worst:O(N^2) -> Sorted in decreasing.
 *                   
 *    It is a stable sorting algorithm -> Order is same when the value is same --> like sorting the color with  values ,, the order of the color in the unsorted with same value should be same
 *           
 *  Use case is that the implementation is simple if the trade off is possible for the execution speed it can be used                  
 *
 */
public class BubbleSort {
public static void main(String[] args) {
	int arr[] = {3,1,5,2,4};
	bubbleSort(arr);
	System.out.println(Arrays.toString(arr));
	
}

public static void bubbleSort(int arr[]) {
	boolean swapped;

	for (int i = 0; i < arr.length; i++) {//i is not a pointer just a counter
		swapped = false;
		for (int j = 1; j < arr.length-i; j++) {//length-i is that that at every i_th parse the i_th element is an sorted element
			if(arr[j]<arr[j-1]) {
				swap(arr, j, j-1);
				swapped = true;
			}
		}
		if(!swapped) {
  			break;
		}
		
	}
	
}
public static void swap(int arr[],int a,int b) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}
}
