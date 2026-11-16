package com.batman.statemachine;

public class BestTimeToBuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int day, int hold, Integer[][] dp) {
        if(day > prices.length - 1) return 0;

        if(dp[day][hold] != null) return dp[day][hold];

        // We have two states
        // 1. Hold
        if(hold == 1){
            // Means we can only sell or do nothing and doNothing is a default state.
            int doNothing = helper(prices, day + 1, hold, dp);
            int sell = prices[day] + helper(prices, day + 1, 0, dp);
            dp[day][hold] = Math.max(doNothing, sell);
        }
        // 2. Not Hold
        else{
            // Means we can only buy or do nothing and doNothing is a default state.
            int doNothing = helper(prices, day + 1, hold, dp);
            int buy = -prices[day] + helper(prices, day + 1, 1, dp);
            dp[day][hold] = Math.max(doNothing, buy);
        }

        return dp[day][hold];
    }
}
