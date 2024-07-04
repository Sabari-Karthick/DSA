 package com.DutchmanNationalFlag;
/**
 * 
 * The Dutchman National Flag algorithm, also known as 3-way partitioning,
 *          is an algorithm for sorting an array containing three distinct values. 
 * The algorithm was designed to solve the problem of sorting an array containing only 0s, 1s, and 2s,
 * 
 * When we encounter to sort only three numbers use this algorithm
 * 
 * 
 * 
 * 
 * 
 * The idea behind the algorithm is to keep all the 0s before the low pointer, all the 2s after the high pointer, and all the 1s between the low and high pointers.
 * The algorithm moves the mid pointer through the array, comparing the value at each position with 1.
 * If the value is 0, the element is swapped with the element at the low pointer, and the low and mid pointers are incremented. 
 * If the value is 2, the element is swapped with the element at the high pointer, and the high pointer is decremented. 
 * If the value is 1, the mid pointer is simply incremented. 
 * The algorithm terminates when the mid pointer crosses the high pointer, indicating that all the elements have been processed and the array is sorted.
 * 
 * 
 * Time complexity: O(n) 
 * Space complexity: O(1)
 * 
 * 
 * 
 * 
 * 
 */
import java.util.Arrays;

public class DNFSort {
	public static void main(String[] args) {
      int n[]= {2,0,2,1,1,0};
      sort(n);
      System.out.println(Arrays.toString(n));
	}

	public static void sort(int[] nums) {
             int lptr = 0,mid = 0,rptr=nums.length-1;
             while(mid<=rptr) {
            	 if(nums[mid]==0) {
            		 swap(nums, mid, lptr);
            		 lptr++;
            		 mid++;//We increase mid is because we know that the this place swapped with zero and that zero is also in the correct partition
            	 }else if(nums[mid]==2) {
            		 swap(nums, mid, rptr);
            		 rptr--;//here we do not increase mid as we cannot ensure that if the swapped value may introduce zero at the mid and if the mid gets incremented then the zero is not in its correct partition
            	 }else {
            		 mid++;
            	 }
             }
	}

	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
