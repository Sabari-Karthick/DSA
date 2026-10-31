package com.batman.knapsack;

import java.util.Arrays;

public class LastStoneWeight2 {
    // Whenever we get confused with which order should we execute and different order return different answers
    // That should lead to the question on "what's actually fixed regardless of order?" instead of "what order is best?"
    // For |x−y| specifically: repeatedly replacing two numbers with their absolute difference is the same operation as "flip the sign of one of them and add" — smash x,y → either (x−y) or (y−x), same magnitude.
    // So the only real decision across the whole game is, per stone, does it end up contributing as +weight or −weight to one running total.
    // That's a decision per stone, not a sequence of pairings — which is why it collapses to "two groups" instead of "what order to smash."
    public int lastStoneWeightII(int[] stones) {

        int total = Arrays.stream(stones).sum();

        Integer[][] dp = new Integer[stones.length][total / 2 + 1]; // We can use a 2D array to store the results of the subproblems. The size of the array will be stones.length x total/2. We can initialize the array with null values to indicate that we have not calculated the result for that subproblem yet.

        return total - 2 * helper(0, stones, total / 2, dp); // The minimum possible weight of the left stone is the total weight of the stones minus twice the best sum we can achieve that is less than or equal to half of the total weight.

    }

    /**
     *
     * So now we know we can change the sign (means sign is not a matter)
     * why ? the magnitude of the difference is the same as the magnitude of the sum of the two numbers with one of them negated.
     * Eg : smash 2,7 → 5 is the same as 2 + (-7) = -5 or -2 + 7 = 5
     * So what this tells us is we can try all sign combinations and do a sum , and out of the four possibility we get , two match the total sum
     * Eg : 2,7 → 2+7=9 , 2-7=-5 , -2+7=5 , -2-7=-9
     * <p>
     * So we now got the clue we can add all the elements to match the target which is eventually a partition problem, we can try to match a half target ,
     * Means we can fill a bag which is the as close to half which is the best way to smash the stones because we nearly smased all the stones.
     * If we cant reach the full target with 2x the best half target we can reach then we can return the difference which is the best we can do.
     * <p>
     * In SHORT : The reduction operation is same as forming the whole sum , so we get the best sum we can do and return the difference because the reduction is same to the sum operation because of negation.
     * So we can think of this problem as a subset sum problem where we want to find a subset of stones that has a sum less than or equal to half of the total weight. The remaining stones will have a sum greater than or equal to half of the total weight. The difference between these two sums will be the minimum possible weight of the left stone.
     *
     */

    private int helper(int i, int[] stones, int target, Integer[][] dp) {

        if (i == stones.length) return 0;

        if (dp[i][target] != null)
            return dp[i][target]; // If we have already calculated the result for this subproblem, we can simply return the stored value instead of recalculating it.

        int notTake = helper(i + 1, stones, target, dp);

        int take = 0;
        if (stones[i] <= target) {
            take = stones[i] + helper(i + 1, stones, target - stones[i], dp);
        }

        dp[i][target] = Math.max(take, notTake);

        return dp[i][target];
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeight2().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(new LastStoneWeight2().lastStoneWeightII(new int[]{31, 26, 33, 21, 40})); // 5
        System.out.println(new LastStoneWeight2().lastStoneWeightII(new int[]{1, 2})); // 1
    }
}
