package com.batman.dp2;

import java.util.Arrays;

/**
 * 
 * 
 * LC:322 https://leetcode.com/problems/coin-change/description/
 * 
 * Whether is it a recursive Problem?
 * Yes --> it asks for fewest number of coins, so we need to calculate all ways 
 * 
 * Express Index :: f(index,target)
 * 
 * For most of the DP subsequence Problems on a particular index the action is either take it or not take it
 * 
 * So here if we decide not to take we reduce the index to index - 1 
 *              -->f(index - 1,Target)
 *         if we decide to take we reduce the target
 *              -->f(index, Target - array[index]) 
 *              --> Here the index is not reduced as it can be used any times 
 *              --> if that condition is not there we can reduce it
 *              
 * To identify whether to take it or not if the array[index] is less or equal to target we take else no.
 * 
 * For the Base Case do it for the end index 
 * 
 * If n-1 is where we start do it for 0 and vice-versa
 * 
 * Basically if we point at a last element how to know we can form it to target or not 
 * It is by modulating the target with the array[index]
 * 
 * target % array[index] == 0 ? 1 : 0;
 * 
 * !!!!! But here index based base condition wont work !!!!!
 * 
 * This has a time complexity of Greater than O ( 2 ^ N) as we stay in the same index so not exactly two spans so exponential
 * Space is O(Target)
 * 
 * 
 */
public class CoinChange {
  public static void main(String[] args) {
	System.out.println(Solution32424535.coinChange(new int[] {1,2,5}, 11));
}
}


//Brute Force Recursion
class Solution32424535 {
	 public static int coinChange(int[] coins, int amount) {
	        int minWays =  helper(coins.length - 1, coins, amount);
	        return minWays == Integer.MAX_VALUE - 1 ? -1 : minWays; //If a invalid answer return -1
	    }

	    private static int helper(int index, int[] coins, int amount) {
	        if (amount == 0) //Since the Problem is not a strict iteration we can't use index at base condition
	            return 0;
	        if (index < 0 || amount < 0) //Here we have two things Valid Base and invalid Base Since we have two operation one decrease amount and another index
	            return Integer.MAX_VALUE - 1; //To set invalid we make it to the max

	        //This is not conditional as we can skip the coin no matter what
	        int notTake = helper(index - 1, coins, amount);  //Option 1 : Not to take
	        int take = Integer.MAX_VALUE - 1; //Since take runs conditionally to get the Minimum we set take High
	        if (coins[index] <= amount) { //Option 2 : Take the coin if it can be useful to make the amount
	            take = 1 + helper(index, coins, amount - coins[index]); //Take the coin and go further 
	        }

	        return Math.min(notTake, take); //Return the minimum of two ways
	    }
}

//Memorization
//We have two changing variables so dp2
//Which is index(coin) and target so dp[coin/index][target]
class Solution29379fsd {
    public int coinChange(int[] coins, int amount) {
        int[][]  dp= new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int minWays =  helper(coins.length - 1, coins, amount,dp);
        return minWays == Integer.MAX_VALUE - 1 ? -1 : minWays;
    }

    private int helper(int index, int[] coins, int amount,int[][] dp) {
        if (amount == 0)
            return 0;
        if (index < 0 || amount < 0)
            return Integer.MAX_VALUE - 1;
        
        if(dp[index][amount] != -1) return dp[index][amount];

        int notTake = helper(index - 1, coins, amount,dp);
        int take = Integer.MAX_VALUE - 1;
        if (coins[index] <= amount) {
            take = 1 + helper(index, coins, amount - coins[index],dp);
        }

        return dp[index][amount] = Math.min(notTake, take);
    }
}

//Tabulation
//Bottum Up (From Base Case to End)
class Solution324529gnsdfo {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1); // Invalid Value
            dp[i][0] = 0; // Base Case For all coin if amount is 0 number of coins needed is also zero
        }
        for (int amt = 1; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = amt / coins[0];
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int amt = 1; amt <= amount; amt++) {
                int notTake = dp[i - 1][amt];
                int take = Integer.MAX_VALUE - 1;
                if (coins[i] <= amt) {
                    take = 1 + dp[i][amt - coins[i]];
                }

                dp[i][amt] = Math.min(notTake, take);
            }
        }
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length - 1][amount];
    }
}


//DP 1 
class Solution245ymgsdt98 {
    public int coinChange(int[] coins, int amount) {
          int dp[] = new int[amount + 1];
          Arrays.fill(dp,Integer.MAX_VALUE - 1);
          dp[0] = 0;
          for(int i = 0;i< coins.length ; i++){
            for(int amt = coins[i] ; amt <= amount ; amt++){
                dp[amt] = Math.min(dp[amt],1 + dp[amt - coins[i]]);
            }
          }
          return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
