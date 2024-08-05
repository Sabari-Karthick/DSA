package com.binary;

import java.util.Arrays;//Good Problem
//Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized. 
//Return the minimized largest sum of the split.
//https://leetcode.com/problems/split-array-largest-sum/description/
//Complexity O(N) + O(log S) * O(N) --> O(N log S) where s is the sum of array (Upper Bound /End Limit)
public class SplitArrayLargestSum {
public static void main(String[] args) {//find where the possible answers lie 
	int nums[]= {7,2,5,10,8};
	System.out.println(splitArray(nums, 2));
}
public static int splitArray(int[] nums, int k) {
    int start = Arrays.stream(nums).max().getAsInt();
    int end = Arrays.stream(nums).sum();
   
    while(start < end){
        int mid = start +(end - start)/2;
            int sum=0;
            int pieces = 1;
        for(int i : nums){
            
            if(sum+i>mid){
                sum = i;
                pieces++;
            }else{
                sum+=i;
            }
        }
        if(pieces<=k){//there may be other better solution(a minimized sum) if equal
            end = mid;
        }
        else{
            start=mid+1;// we need to reduce the pieces so taking larger sum which is after mid
        }
    }
    return start;
}
}
