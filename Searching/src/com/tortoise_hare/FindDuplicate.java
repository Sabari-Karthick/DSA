package com.tortoise_hare;

/**
 * @author _karthick
 * 
 *         Given an array of integers nums containing n + 1 integers where each
 *         integer is in the range [1, n] inclusive. There is only one repeated
 *         number in nums, return this repeated number. You must solve the
 *         problem without modifying the array nums and uses only constant extra
 *         space.
 * 
 *         https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 */
public class FindDuplicate {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));
//this method is not that good
	}

	public static int findDuplicate(int nums[]) {//This is only used to find single cycle
		int tortoise = nums[0];
		int hare = nums[0];
		while (true) {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
			if (tortoise == hare) {//cycle
				break;
			}
		}
		tortoise = nums[0];
		while (tortoise != hare) {//to detect start of cycle
			tortoise = nums[tortoise];
			hare = nums[hare];
		}
		return tortoise;
	}
}
