package com.array.medium;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductExceptSelf {
	public static void main(String[] args) {
       int[] productExceptSelf = productExceptSelf(new int[]{1,2,3,4});
       System.out.println(Arrays.toString(productExceptSelf));
	}
	public static int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		int left = 1;//Track prefix product
		int right = 1;//track post_fix product
		for (int i = 0; i < nums.length; i++) {
			ans[i] = left;
			left *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] *= right;
			right *= nums[i];
		}
		return ans;
	}
}
