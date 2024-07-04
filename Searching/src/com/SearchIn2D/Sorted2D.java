/**
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/1307272287/
 */
package com.SearchIn2D;

import java.util.Arrays;

/**
 * @author _karthick
 *
 */
public class Sorted2D {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };
		System.out.println(Arrays.toString(search(arr, 8)));
	}

	public static int[] search(int arr[][], int target) {// 0( M + N)
		int row = 0;//start from the top right element
		int col = arr.length - 1;

		while (row < arr.length && col >= 0) {
			if (arr[row][col] == target) {
				return new int[] { row, col };
			}
			if (arr[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}

		return new int[] { -1, -1 };
	}
}
