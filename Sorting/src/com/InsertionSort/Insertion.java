package com.InsertionSort;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 *  Inserting the element in the left sorted array
 *  Sort the array partially -> sort part by part -> sort till i_th index in each i parse
 *  Worst case : O(N^2)
 *  Best Case : O(N) 
 *   
 * It is adaptive -> Steps get reduced if array is sorted
 *                -> No of swaps reduced comparing to bubble sort
 *                -> Stable Sorting
 *                ->Good for small sets and with partially sorted arrays
 *  take part in some hybrid sorting algorithm(combination of some fast algorithm and insertion)
 *  in-built sort() at a max use insertion sort in hybrid
 *  the library sort() functions run : NlogN times
 *   
 */
public class Insertion {
	public static void main(String[] args) {
    
		 int arr[] = {4,5,-2,0,1,3,2};
		 insertionSort(arr);
	      System.out.println(Arrays.toString(arr));
	}
	
	public static void insertionSort(int []arr) {
		   for (int i = 0; i < arr.length-1; i++) {
				for (int j = i+1; j >0	; j--) {
					if(arr[j]<arr[j-1]) {
						swap(arr, j, j-1);
					}
					else {
						break;
					}
				}
	}
	}
	public static void swap(int arr[],int a,int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
