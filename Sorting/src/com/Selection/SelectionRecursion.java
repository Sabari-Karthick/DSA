package com.Selection;

import java.util.Arrays;

public class SelectionRecursion {
	public static void main(String[] args) {
		int arr[] = { 4, 5, 1, 3, 8,2 };
		selectionSort(arr,arr.length,0,0);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr,int e,int c,int max) {
      if(e==0) {
    	  return;
      }
      if(c<e) {//one entire traversal
    	  if(arr[c]>arr[max]) {
    		  selectionSort(arr, e, c+1, c);
    	  }else {
    		  selectionSort(arr, e, c+1, max);
    	  }
      }
      else
      {
    	  swap(arr, max, e-1);
    	  selectionSort(arr, e-1, 0, 0);
      }
	}

	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
