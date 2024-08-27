package com.twopointer;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumInputSorted {

}
/**
 * Consider the brute force where we use every pair to get the target total in that if the sum exceeds in-between we no need to check the further combination.
 * This is the intuition for two pointer : 
 *        -> if sum is increased decrease it by reducing the end pointer
 *        -> no if larger sum is needed means increase the start pointer
 *        
 *    This will increase the efficiency.
 *    
 *    Normal Two Sum Hash-map Solution also work
 * 
 * 
 * 
 * 
 * 
 */


class Solution78dsfd{
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length - 1;

        while(ptr1 < ptr2){
            int num1 = numbers[ptr1];
            int num2 = numbers[ptr2];

            if(num1 + num2 == target)
                 break;

            if(num1 + num2 > target){
                //sum is already greater so remove the last element
                ptr2--;
                continue;
            } 
            ptr1++;
        }
        return new int[]{ptr1+1,ptr2+1};
    }
}