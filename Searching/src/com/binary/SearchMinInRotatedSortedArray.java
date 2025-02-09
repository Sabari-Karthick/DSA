package com.binary;


/**
 * 
 * 153 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * 
 * 
 * 
 */
public class SearchMinInRotatedSortedArray {

}

class Solution435g {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length -1 ;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid] > nums [mid + 1]){
                return nums[mid + 1];
            }else if(mid > start && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }else if(nums[start] <= nums[mid]){
                start = mid + 1;
            }else if(nums[start] > nums[mid]){
                end = mid - 1;
            }
        }
        return nums[0];
    }
}