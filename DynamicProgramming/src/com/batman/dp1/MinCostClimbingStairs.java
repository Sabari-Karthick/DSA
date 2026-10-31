package com.batman.dp1;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        return Math.min(helper(0, cost, dp), helper(1, cost, dp));

    }

    private int helper(int i, int[] cost, Integer[] dp) {

        if(i >= cost.length) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }

        dp[i] = Math.min(helper(i + 1, cost, dp), helper(i + 2, cost, dp)) + cost[i];

        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    }
}
