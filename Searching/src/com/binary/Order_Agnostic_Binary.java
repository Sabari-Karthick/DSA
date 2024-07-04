package com.binary;

import java.util.Arrays;

/**
 * @author _karthick
 * 
 *         Best Case : O(1) -> constant 
 *         Worst Case : O(log_2 N)
 *  
 *  To create Integer from int ::: Arrays.stream(arr1).boxed().toArray(Integer[]::new);
 *  To create int from Integer ::: Arrays.stream(arrWrapper).mapToInt(Integer::intValue).toArray();
 * 
 *
 */
public class Order_Agnostic_Binary {
	public static void main(String[] args) {
		int arr[] = { -4, 3, 5, 603, 647, 25134, 23, 0, 34, 12, 9836, 357401, 32, 67, 54 };
		int arr1[] = { -4, 3, 5, 603, 647, 25134, 23, 0, 34, 12, 9836, 357401, 32, 67, 54 };
		Integer[] arrWrapper = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
		Arrays.sort(arrWrapper, (n1, n2) -> n2 - n1);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 357401));
		System.out.println(Arrays.toString(arrWrapper));
		arr1 = Arrays.stream(arrWrapper).mapToInt(Integer::intValue).toArray();
		;
		System.out.println(binarySearch(arr1, 0));
	}

	static int binarySearch(int arr[], int target) {
		if (isDesc(arr)) {
			return binSearch(arr, target);
		}
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int elementIndex = start + (end - start) / 2;
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

	private static boolean isDesc(int[] arr) {
		if (arr[0] >= arr[arr.length - 1])//checking the first and the last element to check whether ascending or descending sorted
			return true;
		return false;
	}

	static int binSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int elementIndex = start + (end - start) / 2;
			if (arr[elementIndex] == target)
				return elementIndex;
			else if (arr[elementIndex] > target) {
				start = elementIndex + 1;
			} else if (arr[elementIndex] < target) {
				end = elementIndex - 1;
			}
		}

		return -1;
	}
}
