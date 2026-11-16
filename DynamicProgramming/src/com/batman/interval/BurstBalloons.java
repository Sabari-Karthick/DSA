package com.batman.interval;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1, dp);
    }

    private int helper(int[] nums, int s, int e, Integer[][] dp) {
        if(s > e) return 0;

        if(dp[s][e] != null) return dp[s][e];


        int max = 0;

        for(int k = s ; k <=e; k ++){
            int left = helper(nums,s,k-1,dp);
            int right = helper(nums,k+1,e,dp);

            int cost = (s-1< 0 ? 1 : nums[s-1]) * nums[k] * (e+1 < nums.length ? nums[e+1] : 1);


            max = Math.max(max,cost+left+right);
        }

        dp[s][e] = max;


        return dp[s][e];

    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3,1,5,8})); // 167
        System.out.println(new BurstBalloons().maxCoins(new int[]{1,5})); // 10
        System.out.println(new BurstBalloons().maxCoins(new int[]{1,2,3,4,5})); // 110
    }
}
