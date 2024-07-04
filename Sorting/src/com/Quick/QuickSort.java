package com.Quick;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 *         Choose any element as Pivot 
 *         After first pass all are less than pivot are at the left hand side and the greater than pivot at the right of pivot 
 *         After every pass the pivot reaches its right position Then apply recursion for the either side of the pivot to get them sorted
 * 
 *         In merge sort even if the array is sorted it goes till the base condition but it won't happen in the quick sort
 *         low and high are the variables which tells the which part of the array we working at
 *         start  and end are just for swapping 
 *         Not a stable sorting algorithm
 *         Preferred for Arrays while Merge sort is good with Link-List -> because of not contiguous memory allocation
 * 
 * 
 *  Recurrence Relation:: T(k) + T(N-k-1)+O(N)
 * 
 * At Worst Case:: O(n^2) 
 * At Best  Case:: O(N Log N)
 * 
 * 
 * 
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 6, 7, 4 };
		quickSort(arr, 0, arr.length-1); 
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int arr[], int low, int high) {
		if (low >= high) {
			return;
		}
		int s = low;
		int e = high;
		int mid = s + (e - s) / 2;
		int pivot = arr[mid];
		while (s <= e) {
			while (arr[s] < pivot) {
				s++;

			}
			while (arr[e] > pivot) {
				e--;
			}
			if(s<=e) {//if already sorted it will not swap
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		//now the pivot will be at the correct index now sort the other halfs
		quickSort(arr, low, e);
		quickSort(arr, s, high);
	}
}
