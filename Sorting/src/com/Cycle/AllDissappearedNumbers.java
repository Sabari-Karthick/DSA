package com.Cycle;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
import java.util.ArrayList;
import java.util.List;

public class AllDissappearedNumbers {
	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> ans = findAllDissappearedNumbers(arr);
		System.out.println(ans);
	}

	private static List<Integer> findAllDissappearedNumbers(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		while (i < arr.length) {
			int correctIndex = arr[i] - 1;
			if (arr[i] != arr[correctIndex]) {
				swap(arr, i, correctIndex);
			} else {
				i++;
			}
		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != j + 1) {

				ans.add(j + 1);
			}
		}
		return ans;

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
