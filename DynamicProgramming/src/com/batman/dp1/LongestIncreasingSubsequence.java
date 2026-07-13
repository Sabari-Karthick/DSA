package com.batman.dp1;

import java.util.Arrays;

/**
 * 
 * For the Subsequence Problem the pattern is 
 *       --> Either Take or not Take
 * 
 * For subsequence We can skip in between characters but the selection should be a sequence
 * 
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println(longestIncreasingSubsequence(new int[]{0,1,0,3,2,3})); // 4
        System.out.println(longestIncreasingSubsequence(new int[]{7,7,7,7,7,7,7})); // 1
    }


    // First Sliding Window and Two pointers are out of the picture here
    // Because Subsequence is not a contiguous sequence so we can skip in between characters which makes SW impossible
    // The two values we compare may have values that may for a sequence is beyond the two values we are comparing so Two Pointers is also out of the picture


    // So Basically we arrive at a point take a number and see how can it form a subsequence which is DFS
    // But instead of exploring we can see one more thing , take the number see if it can fit in any of the subsequence we already have and update the length
    // Like Building Blocks instead of checking or worrying will this sequence get bigger in future
    // Just add it to the big block we have till now
    public  static  int longestIncreasingSubsequence(int[] arr){

        // We need to track for each number what is the longest subsequence(block) its been part of

        int[] dp = new int[arr.length];

        // Since each number is a subsequence of length 1
        Arrays.fill(dp,1);

        for(int i = 0; i < arr.length; i++){ // For Each Number
            // We need to know the subsequence length of the previous numbers and see if we can add this number to that subsequence
            for(int j = 0; j < i; j++){
                // The main condition is that the previous number should be less
                if(arr[i] > arr[j]){ // Means we can add to the previous subsequence if our addition increase the length
                    // Valid Jump
                    // Update the max Subsequence Length for this number
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp[j] is the max till previous number and we add one more length
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }


}
