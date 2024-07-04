package com.binary;

//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedArray2_NoDuplicates {
	public static void main(String[] args) {
		int arr[] = { 3, 3, 3, 1 };
		System.out.println(search(arr, 1));

	}

	public static int search(int[] nums, int target) {
		int pivot = pivotIndex(nums);
		int firstSearch = binarySearch(nums, target, 0, pivot);
		if (firstSearch != -1) {
			return firstSearch;
		}
		return binarySearch(nums, target, pivot + 1, nums.length - 1);
	}

	public static int pivotIndex(int[] nums) {// Pivot is the largest element
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid < end && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (mid > start && nums[mid] < nums[mid - 1]) {
				return mid - 1;
			} else if (nums[start] >= nums[mid]) {//if start is greater or equal to the mid which means the part of array after mid is smaller than the part before the mid because of rotation so we can skip the second part as we only needed the largest element the pivot
				end = mid - 1;
			} else if (nums[start] < nums[mid]) {//in this the largest number lie in the second part of array
				start = mid + 1;//both cases we skip the middle as we know if the mid is the pivot it would have caught in the case 1
			}

		}
		return -1;
	}

	public static int binarySearch(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
