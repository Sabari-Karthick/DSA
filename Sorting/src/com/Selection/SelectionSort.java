package com.Selection;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 * Select an element and put it in its right position
 * For i parse find the range with start and end and find the max in that and swap it to the end
 * 
 * 
 * 
 * Best and Worst Both are : O(N^2)
 * It is not a stable sorting algorithm ,, the order not same when the values are same
 * 
 * Not a fast one so not recommended,but works good if the data set is small.
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
      int arr[] = {4,5,1,3,8};
      selectionSort(arr);
      System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
				int lastIndex = arr.length-1-i;//the last index get reduced by i times
				int maxIndex = maxIndex(arr,0,lastIndex);
				swap(arr, lastIndex, maxIndex);
			}
	}

	private static int maxIndex(int[] arr,int start,int end) {
		int max =start;
	      for(int i = start;i<=end;i++) {
	    	  if(arr[max]<arr[i]) {
	    		  max = i;
	    	  }
	      }
		return max;
	}
	public static void swap(int arr[],int a,int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
} 
