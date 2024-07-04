package com.DutchmanNationalFlag;

import java.util.Arrays;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
public class SortColors {
public static void main(String[] args) {
	int nums[]= {2,0,2,1,1,0};
	sortColors(nums);
	 System.out.println(Arrays.toString(nums));
}
public static void sortColors(int[] nums) {
	 int lptr = 0,mid = 0,rptr=nums.length-1;
     while(mid<=rptr) {
    	 if(nums[mid]==0) {
    		 swap(nums, mid, lptr);
    		 lptr++;
    		 mid++;
    	 }else if(nums[mid]==2) {
    		 swap(nums, mid, rptr);
    		 rptr--;
    	 }else {
    		 mid++;
    	 }
     }
    
}
public static void swap(int arr[],int a,int b) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}
}
