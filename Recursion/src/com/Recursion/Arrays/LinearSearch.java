package com.Recursion.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int arr1[] = { 10, 20, 30, 40, 50, 30 };
		System.out.println(isPresent(arr, 50, 0));
		System.out.println(find(arr, 50, 0));
		System.out.println(find2(arr1, 30, 0,new ArrayList<Integer>()));
		System.out.println(find3(arr1, 30, 0));
	}

	private static boolean isPresent(int[] arr, int target, int index) {
		if (index == arr.length) {
			return false;
		}
		return arr[index] == target || isPresent(arr, target, index + 1);
	}

	private static int find(int[] arr, int target, int index) {
		if (index == arr.length) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		} else {
			return find(arr, target, index + 1);
		}
	}

	private static List<Integer> find2(int[] arr, int target, int index, List<Integer> indexes) {
		if (index == arr.length) {
			return indexes;
		}
		if (arr[index] == target) {
			indexes.add(index);
		}
		return find2(arr, target, index + 1, indexes);

	}
	private static List<Integer> find3(int[] arr, int target, int index) {//not good approach
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (index == arr.length) {
			return ans;
		}
		if (arr[index] == target) {
			ans.add(index);
		}
		 List<Integer> fromOtherCall = find3(arr, target, index + 1);
         ans.addAll(fromOtherCall);
         return ans;
	}
}
