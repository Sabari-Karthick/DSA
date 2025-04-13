package com.binary;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 *         Best Case : O(1) -> constant -> time remains constant even the array
 *         increases with best case Worst Case : O(log_2 N) --> number of time
 *         we need to divide the array, k = log_2 N --> N= 2^k
 * 
 * 
 *         If the problem is of a sorted array or follow a sequence which is
 *         sorted then binary search may be good option
 * 
 *
 */
public class Binary {
	public static void main(String[] args) {

		int arr[] = { -4, 3, 5, 603, 647, 25134, 23, 0, 34, 12, 9836, 357401, 32, 67, 54 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 357401));
	}

	static int binarySearch(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {// when condition is violated start = end +1
			int elementIndex = start + (end - start) / 2;// helps in handling large values as normal way may exceed the
															// range of int
			if (arr[elementIndex] == target)
				return elementIndex;
			else if (arr[elementIndex] > target) {
				end = elementIndex - 1;
			} else if (arr[elementIndex] < target) {
				start = elementIndex + 1;
			}
		}

		return -1;
	}
}
