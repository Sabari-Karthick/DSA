package com.binary;
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. it may have duplicates
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchInRotatedSortedArray {
public static void main(String[] args) {
	int arr[]= {4,5,6,7,0,0,1,2};
	System.out.println(search(arr, 14));
	
}
public static boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length-1;
    while(start <=end) {
    	int mid = start + (end - start)/2;
    	if(nums[mid]==target) {
    		return true;
    	}
    	if(nums[start]==nums[mid]&&nums[end]==nums[mid]) {//ignore the duplicates //To reduce large duplicate span
    		start++;
    		end--;
    	}
    	
    	else if(nums[start]<=nums[mid]) {//check if the first half in ascending
    	  if(nums[start]<=target&&nums[mid]>=target) {//check whether the target exist in this part
    		  end = mid-1;
    	  }else {
    		  start = mid +1;
    	  }
    	}
    	else {
    		if(nums[end]>=target&& nums[mid]<=target) {
    			start = mid +1;
    		}
    		else {
    			end = mid-1;
    		}
    	}
    }
	return false;
}

}
