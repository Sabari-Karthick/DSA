package com.batman.knapsack;

/**
 * The Flag: "Infinite supply" (or "reuse allowed") + "fewest/minimum/maximum". The ultimate optimization hook.
 * <p>
 * The Intuition: You are at a specific amount. You have an infinite menu of coins. The optimal way to make the big amount is exactly 1 coin + the optimal way to make the remaining smaller amount. You test every coin on the menu and take the minimum result.
 * <p>
 * The Formula: minCoins = Math.min(minCoins, 1 + helper(amount - coin))
 * <p>
 * The Bodyguard (Safe Check): Because invalid paths return -1 (or infinity), you must check if the recursive call survived before adding 1 to it.
 * <p>
 * Known States (Base Cases): amount == 0? Return 0 (it takes 0 coins to make 0). Gatekeeper: If coin > amount, skip it.
 * <p>
 * The Memory (Memo): Integer[] dp = new Integer[amount + 1]. 1D array because amount is the only moving part. Check at the top, save at the bottom.
 */

public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
        return new CoinChange().helper(coins, amount, new Integer[amount + 1]);
    }

    int helper(int[] coins, int amount, Integer[] dp) {
        if (amount == 0) return 0; // Base case: If the amount is 0, no coins are needed.

        int min = Integer.MAX_VALUE; // EveryTime we needs to evaluate the pile to find the min of this target

        // Always check the top
        if (dp[amount] != null) return dp[amount];

        for (int coin : coins) {
            if (coin <= amount) { // If it is within our needed amount
                // Core of the problem is Minimum coins needed for the amount is the minimum coins needed by taking the available options
                int smallerPile = helper(coins, amount - coin, dp);
                if (smallerPile != -1) {
                    min = Math.min(min, 1 + smallerPile);
                }
            }
        }

        // Always update at bottom
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(coinChange(new int[]{2}, 3)); // -1
        System.out.println(coinChange(new int[]{1}, 0)); // 0
    }
}
