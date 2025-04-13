package com.binary;

//https://leetcode.com/problems/search-insert-position/description/
public class CeilInArray {// return a number greater than equal to the target which is smallest in the
							// array
	// If flour return a greatest number in array that is smaller or equal to the
	// target
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 9, 14, 16, 18 };
		System.out.println(findCeil(arr, 10));
	}

	static int findCeil(int[] arr, int target) {
		if (target > arr[arr.length - 1]) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) { // when while is violated we know the answer not lying between start and end so
								// start points the next big number and end points the lower element
			int mid = start + (end - start) / 2;
			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;

			} else if (target == arr[mid]) {

				return arr[mid];
			}

		}
		return arr[start];// for floor return end
	}
}
