package com.array.medium.kadanes;

import java.util.Arrays;
import java.util.Map;

/*
 * 
 * Find the largest sum of any contiguous subarray." ← This screams Kadane.
 * 
 * Keywords like “maximum subarray sum”, “largest sum of contiguous elements”, or even “maximum profit” are red flags for kadanes.
 * 
 * 
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * 
 * Kadane’s Intuition Simplified:  
 *     Think of it like this:  
 *          "Is adding this number helping me?" 
 *             Yes → Keep adding to the current sum.
 *             No → Start fresh from this number.
 *          You’re making a decision at each element: 
 *             Carry forward the current sum or Reset the sum starting from here
 * 
 */
public class MaxSumSubArray {
public static void main(String[] args) {
//	Map<Integer,int[]> maxSubArray = Solutionsg452g23425.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
	Map<Integer,int[]> maxSubArray = Solutionsg452g23425.maxSubArray(new int[] {5,4,-1,7,8});
	for (Map.Entry<Integer, int[]> entry : maxSubArray.entrySet()) {
		Integer key = entry.getKey();
		int[] val = entry.getValue();
		System.out.println("Max :: " + key + " Array :: " + Arrays.toString(val));
		
	}
}
}

//Brute Force O(N ^ 3)
class Solution24fsdf90 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){ // Sub Array Start
             for(int j = i ; j < nums.length ; j++){ // Sub Array End
               int sum = 0;
               for(int k = i;k <= j ; k++){ //Sub Array Sum
                 sum += nums[k];
                 max = Math.max(sum,max);
               }
            }
        }
        return max;
    }
}

//Better Brute Force O (N ^ 2)
class Solution23487fsnut {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){ // Sub Array Start
            int sum = 0;
             for(int j = i ; j < nums.length ; j++){ // Sub Array End
                 sum += nums[j];
                 max = Math.max(sum,max);
            }
        }
        return max;
    }
}

//Optimal O(1)
class Solutionsg452g {
    public  int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Step 1: Do the operation (add current number)
            sum += nums[i];
            
         // Step 2: Update the end result (check if it's the new max)
            max = Math.max(sum, max);
            
            // Step 3: Carry the result only if it helps (reset if negative)
            if (sum < 0) {  //Dragging the Value Down, Start new Subarray
                sum = 0;
                //sum = Math.max(0, sum);
            }
        }
        
        return max;
//        return max < 0 ? 0 : max; //If 0 is expected for a possible empty subarray or a whole negative array
    }
}


//Printing the Sub array with the max Sum
class Solutionsg452g23425 {
    public static Map<Integer, int[]> maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int l = -1 , r = -1;
        for (int i = 0; i < nums.length; i++) {
        	if(sum == 0) {
        		l = i; //Start of SubArray 
        	}
        	
        	
            sum += nums[i];
            
            if(sum > max) {
            	max = sum;
            	//The key is that r only marks the end of the best subarray we've found so far.
            	r=i; //Marks the current end of the subarray whenever we find a new maximum sum
            }
            if (sum < 0) {  
                sum = 0; // This means every time a new Sub Array starts sum will be zero
            }
        }
        return Map.of(max,Arrays.copyOfRange(nums, l, r+1));
    }
}