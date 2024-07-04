package com.Merge;

import java.util.Arrays;

/**
 * @author karthick
 * 
 *         Divide the array into two parts 
 *         Sort the parts via Recursion 
 *         Merge the sorted parts
 *         At Every Level N elements are being merged 
 *        Stable Sorting Algorithm
 * Complexity :
 *     Time :: O ( N comparisons * Log N division) :: O(N * Log N)  
 *     Space :: O( N)
 *     
 *     
 *     
 *     
 *     
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 6, 7, 4 };
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	static int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int first[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int second[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(first, second);

	}

	private static int[] merge(int[] first, int[] second) {

		int[] ans = new int[first.length + second.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < first.length && j < second.length) {
			if (first[i] < second[j]) {
				ans[k] = first[i];
				i++;
			} else {
				ans[k] = second[j];
				j++;
			}
			k++;
		}

		while (i < first.length) {
			ans[k] = first[i];
			i++;
			k++;
		}
		while (j < second.length) {
			ans[k] = second[j];
			j++;
			k++;
		}

		return ans;
	}
}
