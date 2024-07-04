package com.array.easy;

import java.util.Arrays;

public class BuildArrayFromPermutation {
	public static void main(String[] args) {
		int []nums = {5,0,1,2,3,4};
		int []ans = buildArray(nums);
		System.out.println(Arrays.toString(ans));
	}
	public static int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i=0 ;i<nums.length;i++){
             ans[i]=nums[nums[i]];
        }
        return ans;
        
    }

}
//Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//https://leetcode.com/problems/build-array-from-permutation/description/