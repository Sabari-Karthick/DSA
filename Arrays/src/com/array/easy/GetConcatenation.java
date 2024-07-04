package com.array.easy;

import java.util.Arrays;

public class GetConcatenation {
public static void main(String[] args) {
	int nums[] = {1,3,2,1};
	System.out.println(Arrays.toString(getConcatenation(nums)));
}
public static int[] getConcatenation(int[] nums) {
    int ans[] = new int[nums.length*2];
     for(int i=0;i<nums.length;i++){
         ans[i]=nums[i];
         ans[nums.length+i] = nums[i];
    }
    return ans;
}
}
//Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//https://leetcode.com/problems/concatenation-of-array/description/