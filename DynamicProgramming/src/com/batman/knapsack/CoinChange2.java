package com.batman.knapsack;

public class CoinChange2 {
    public int change(int amount, int[] coins) {


        // Our state here is the amount as usual but we need to know which coin we are currently tracking

        Integer[][] dp = new Integer[amount + 1][coins.length];
        return helper(amount, coins, dp, 0);
    }

    private int helper(int amount, int[] coins, Integer[][] dp, int index) {

        if (amount == 0) return 1;
        if (index >= coins.length) return 0;

        if (dp[amount][index] != null) {
            return dp[amount][index];
        }

        int take = 0;


        if (coins[index] <= amount) {
            take = helper(amount - coins[index], coins, dp, index);
        }
        int notTake = helper(amount, coins, dp, index + 1);


        dp[amount][index] = take + notTake;
        return dp[amount][index];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: 1 way to make amount 0 (use no coins)

        for (int coin : coins) {
            // We only start looking at amounts >= the coin itself
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5})); // 4
        System.out.println(new CoinChange2().change(3, new int[]{2})); // 0
        System.out.println(new CoinChange2().change(10, new int[]{10})); // 1
    }
}
