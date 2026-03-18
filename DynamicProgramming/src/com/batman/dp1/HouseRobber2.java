package com.batman.dp1;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2})); // 3
    }

    private static int rob(int[] nums){

        if(nums == null || nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int robFirst = robStraight(nums,0,nums.length - 2);
        int robLast = robStraight(nums,1,nums.length-1);

        return Math.max(robFirst, robLast);
    }

    static int robStraight(int[] nums,int start,int end){


        int prev1 = 0;
        int prev2 = 0;

        for (int i = start ; i <= end ; i++){
            int current = Math.max(prev2 , nums[i] + prev1);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
