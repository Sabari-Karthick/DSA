package com.array.easy;

import java.util.Arrays;

public class ShuffleArray {
public static void main(String[] args) {
	System.out.println(Arrays.toString(shuffle(new int[] {2,5,1,3,4,7}, 3)));
}
public static int[] shuffle(int[] nums, int n) {
    int ans[] = new int[nums.length];
    
    for(int i=0;i<n;i++){
        ans[2*i] = nums[i];
        ans[2*i+1] = nums[n+i];
    }
    return ans;

}
}
//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

//Return the array in the form [x1,y1,x2,y2,...,xn,yn].

//https://leetcode.com/problems/shuffle-the-array/description/