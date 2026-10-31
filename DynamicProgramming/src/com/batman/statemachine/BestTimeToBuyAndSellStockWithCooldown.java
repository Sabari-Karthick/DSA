package com.batman.statemachine;

/**
 * A "State Machine" (or Finite State Machine) is just a fancy engineering term for
 * <p>
 * a system that can be in exactly one of a few distinct statuses (states) at a time, and
 * <p>
 * every action you take transitions you from one state to another.
 * <p>
 * <p>
 * The Problem: Best Time to Buy and Sell Stock with Cooldown
 * <p>
 * The Flag: Sequence of events over time + actions restricted by your "current status" + "maximum profit".
 * <p>
 * The Intuition: You cannot just pick and choose numbers left-to-right;
 * <p>
 * your available actions are dictated by your current physical state.
 * <p>
 * The State Variable: Add a dimension to your DP to track your current status (e.g., 0 for Empty, 1 for Holding).
 * <p>
 * The Transitions: Map out what happens when you press each available button.
 * <p>
 * The Cooldown (The House Robber Jump): When an action triggers a penalty (like a cooldown), you don't need complex flags to track it.
 * <p>
 * You just physically jump your day pointer over the penalty phase (day + 2).
 * <p>
 * The Formula:If Empty (hold == 0): Math.max(helper(day + 1, 0), -prices[day] + helper(day + 1, 1))
 * <p>
 * If Holding (hold == 1): Math.max(helper(day + 1, 1), prices[day] + helper(day + 2, 0))
 * <p>
 * Known States (Base Cases):day >= prices.length $\rightarrow$ return 0. (The timeline has ended; no more moves can be made).
 * <p>
 * The Memory: Integer[][] dp = new Integer[n][2].
 * <p>
 * Index dp[day][hold] represents the maximum profit achievable from day to the end of the array, given your current hold status.
 * <p>
 * Time Complexity: $O(n)$. You have $n$ days, and at each day you can be in 2 possible states.
 * <p>
 * That's $2n$ subproblems.
 * <p>
 * Each subproblem just takes the Math.max of two choices, which is $O(1)$ constant work.
 * <p>
 * Total time is linear!
 * <p>
 * Space Complexity: $O(n)$ for the 2D memoization table + $O(n)$ for the recursion stack depth.
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2]; // Days x Holding Stock Flag
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int day, int hold, Integer[][] dp) {
        if (day >= prices.length) {
            // Market is closed
            return 0;
        }

        // Always check memo at top
        if (dp[day][hold] != null) {
            return dp[day][hold];
        }

        int profit = 0;

        if (hold == 0) { // If we are not holding anything we get two choices buy or do nothing
            int nothing = helper(prices, day + 1, hold, dp);
            int buy = -prices[day] + helper(prices, day + 1, 1, dp);
            profit = Math.max(profit, Math.max(buy, nothing));
        } else { // We get again two choices either sell or do nothing
            int nothing = helper(prices, day + 1, hold, dp);
            // If we sell we can't buy next day so we technically have a dead next day which can be skipped
            int sell = prices[day] + helper(prices, day + 2, 0, dp);
            profit = Math.max(profit, Math.max(sell, nothing));
        }

        dp[day][hold] = profit;

        return dp[day][hold];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1})); // 0
    }
}
