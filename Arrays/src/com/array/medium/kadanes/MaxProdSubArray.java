package com.array.medium.kadanes;

public class MaxProdSubArray {

}

//Brute Force
class Solution12geo5u {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++){
            for(int j = i;j < nums.length ; j++){
                int prod = 1;
                for(int k = i;k <= j ;k++){
                    prod *= nums[k];
                    max = Math.max(prod,max);
                }
            }
        }
        return max;
    }
}

//Better Brute Force 
class Solution2346j {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++){
            int prod = 1;
            for(int j = i;j < nums.length ; j++){
                    prod *= nums[j];
                    max = Math.max(prod,max);
            }
        }
        return max;
    }
}

//Optimal Based On Observations
/**
 * All Positive -> Answer Multiple of all
 * Even Negatives -> Multiple of all is the answer
 * Odd  Negatives -> Try remove one negative which result in either the prefix or the suffix of the removal is the answer
 * Contains Zeros -> Form Subarrays that doesnt contain the zero and get the max of them 
 * 
 */
class Solution234jisg0 {
    public int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;

            pre = pre * nums[i];
            suf = suf * nums[nums.length - 1 - i];

            max = Math.max(max, Math.max(pre, suf));
        }

        return max;
    }
}
