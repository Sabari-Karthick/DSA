package com.array.medium;

import java.util.Arrays;
//
//https://leetcode.com/problems/product-of-array-except-self/description/
/**
 * The solution lies in the question itself
 * 
 * answer[i]=(product of all elements to the left of i)×(product of all elements to the right of i)
 * 
 * Key Pattern to Look For:  
 *     "All elements except the current one" → This hints that the result for each element depends on multiple other parts of the array
 *      If you can’t modify the array in-place easily, precomputing something (like prefix or suffix products) becomes a strong candidate.
 * 
 * 
 */
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

//Reverse Calculation
class Solution234234ghb {
    public int[] productExceptSelf(int[] nums) {
    	int[] ans = new int[nums.length];
    	int l = 1, r = 1; // They hold the respective side products till i.

    	// Calculate Suffix Product (right products)
    	for (int i = nums.length - 1; i >= 0; i--) {
    	    // Initially, ans[i] stores the product of all elements to the right of index i.
    	    ans[i] = r; 
    	    // Update r to include nums[i], so the next iteration has the correct right product.
    	    r *= nums[i];
    	}
    	// Calculate Prefix Product (left products) and combine with right products
    	for (int i = 0; i < nums.length; i++) {
    	    // Multiply the existing right product (stored in ans[i]) with the left product (l).
    	    ans[i] *= l; 
    	    // Update l to include nums[i] for the next iteration.
    	    l *= nums[i];
    	}

    	return ans;


    }
}