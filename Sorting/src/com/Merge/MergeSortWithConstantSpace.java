package com.Merge;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 * Divide the array into two parts Sort the parts via Recursion Merge the sorted parts At Every Level N elements are being merged
 * 
 * Complexity : Time :: T(n) = 2T(n/2) + O(n) :: O ( N comparisons * Log N division) :: O(N * Log N) Space :: O(1)
 * 
 * 
 * 
 * 
 * 
 */
public class MergeSortWithConstantSpace {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 6, 7, 4 };
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int[] arr, int start, int end) {
		if (end - start == 1) {
			return;
		}
		int mid = start + (end - start) / 2;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);

		merge(arr, start, mid, end);

	}

	static void merge(int[] arr, int s, int m, int e) {
		int[] ans = new int[e - s];
		int i = s;
		int j = m;
		int k = 0;

		while (i < m && j < e) {
			if (arr[i] < arr[j]) {
				ans[k] = arr[i];
				i++;

			} else {
				ans[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i < m) {
			ans[k] = arr[i];
			i++;
			k++;
		}
		while (j < e) {
			ans[k] = arr[j];
			j++;
			k++;
		}

		for (int x = 0; x < ans.length; x++) {
			arr[s + x] = ans[x];
		}
	}
}
