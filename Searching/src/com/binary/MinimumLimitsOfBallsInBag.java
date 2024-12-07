package com.binary;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag
 * 
 * It is similar to the koko eating banana problem
 * 
 * The maximum number of balls is the penalty and we need to minimize the penalty 
 * 
 * The maximum number of balls after the max Operations can be max equal to the max element in the array and the minimum is 1 since number of balls is positive
 * 
 * This falls under search in a sorted sequence so binary search 
 * 
 * Here canDivide is the function determines the search movement here 
 * 
 * That function simply checks whether the maxBalls count passed to it can be possible in the given nums array within the maxOperations 
 * 
 * It can be done by dividing the number by max Balls and subtract one from its ceil value 
 * 
 * dividing the number by max Balls -> to have the max at most which takes ceil_val(div) parts and subtract one is for number of operations
 * 
 * If yes find a minimal solution else try to increment the search range
 * 
 * 
 */
public class MinimumLimitsOfBallsInBag {

}
class Solution234jnjb {
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();
        while(start < end){
            int mid = start + (end - start) / 2;
            if(canDivide(nums,mid,maxOperations)){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }

    public boolean canDivide(int[] nums,int max,int maxOperations){
        int opr = 0;
        for( int i : nums){
            opr += Math.ceil((i *1.0)/max) - 1;
            if(opr > maxOperations) return false;
        }

        return true;
    }
}