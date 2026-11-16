package com.batman.statemachine;

public class BestTimeToBuyAndSellStocks3 {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][3];
        return helper(prices, 0, 0, 0, dp);
    }

    private int helper(int[] prices, int day, int hold, int count, Integer[][][] dp) {
        if(day > prices.length - 1 || count == 2) return 0;

        if(dp[day][hold][count] != null) return dp[day][hold][count];

        // Now same as this problem we have two states
        // 1. Hold
        if(hold == 1){
            // Means we can only sell or do nothing and doNothing is a default state.
            int doNothing = helper(prices, day + 1, hold, count, dp);
            int sell = prices[day] + helper(prices, day + 1, 0, count + 1, dp); // Selling is the trigger to increase the count of transactions
            dp[day][hold][count] = Math.max(doNothing, sell);
        }
        // 2. Not Hold
        else {
            // Means we can only buy or do nothing and doNothing is a default state.
            int doNothing = helper(prices, day + 1, hold, count, dp);
            // But we can only buy if we have not reached the limit of transactions, so we can only buy if count < 2
            int buy = -prices[day] + helper(prices, day + 1, 1, count, dp);
            dp[day][hold][count] = Math.max(doNothing, buy);
        }

        return dp[day][hold][count];
    }


    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStocks3().maxProfit(new int[]{3,3,5,0,0,3,1,4})); // 6
        System.out.println(new BestTimeToBuyAndSellStocks3().maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(new BestTimeToBuyAndSellStocks3().maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
