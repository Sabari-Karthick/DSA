package com.binary;

import java.util.Arrays;
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstAndLastOccurence {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int ans[] = new int[] { firstOccurence(nums, target), lastOccurence(nums, target) };
		System.out.println(Arrays.toString(ans));
		
	
	}

	public static int firstOccurence(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int position = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target > nums[mid]) {
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				position = mid;
				end = mid - 1;

			}
		}
		return position;
	}

	public static int lastOccurence(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int position = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target > nums[mid]) {
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				position = mid;
				start = mid + 1;

			}
		}
		return position;

	}
}
