package com.array.easy;

import java.util.Arrays;

public class RunningSum {
public static void main(String[] args) {
	System.out.println(Arrays.toString(new int[]{1,1,1,1,1}));
}
public int[] runningSum(int[] nums) {
	
    for(int i=1;i<nums.length;i++){
        nums[i]=nums[i]+nums[i-1];
    }
    return nums;
}
}
//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//https://leetcode.com/problems/running-sum-of-1d-array/