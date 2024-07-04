package com.Bubble;

import java.util.Arrays;

public class BubbleWithRecursion {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 2, 4 };
		bubbleSort(arr,arr.length-1,0);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int arr[],int endIndex,int start) {
		if(endIndex==0) {
			return;
		}
		if(start<endIndex) {//one traversal
			if(arr[start]>arr[start+1]) {
				swap(arr, start, start+1);
			}
			bubbleSort(arr, endIndex, start+1);
		}
		bubbleSort(arr, endIndex-1, 0);
		
		
	}

	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
 
