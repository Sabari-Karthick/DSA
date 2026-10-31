package com.batman.knapsack;

import java.util.Arrays;

/**
 * The Flag: "Subset", "exact capacity", and "no item reuse". If they ask for two equal halves, mathematically they are just asking you to find one subset that equals totalSum / 2. If the total sum is odd, return false immediately.
 * <p>
 * The Intuition: You are a thief with a backpack capacity of target. At every item i, you branch into two universes: you either leave it on the table (Skip) or put it in the bag (Take, shrinking remaining capacity). If either universe succeeds, you succeed.
 * <p>
 * The Formula: dp[i][target] = skip || take
 * (Translated: helper(i + 1, target) || helper(i + 1, target - nums[i]))
 * <p>
 * Known States (Base Cases): target == 0? Return true (capacity perfectly hit). i == nums.length? Return false (ran out of items). Gatekeeper: If nums[i] > target, forced skip.
 * <p>
 * The Memory (Memo): Boolean[][] dp = new Boolean[nums.length][target + 1]. Always check at the top, save at the bottom.
 * <p>
 * Return: helper(nums, 0, sum / 2, dp) (Start at index 0, looking for the half-sum).
 */

public class CanPartitionEqualSumSubset {
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();


        if (sum % 2 != 0) {
            // If the sum is odd we cant partition it into two equal subsets
            return false;
        }

        int target = sum / 2; // So We can match one half of the sum into one partition.
        Boolean[][] dp = new Boolean[nums.length][target + 1]; // How many options we look is the rows and till how we look is the col and +1 is to ocunter the zero index

        return helper(nums, 0, target, dp);
    }

    private static boolean helper(int[] nums, int target, int i, Boolean[][] dp) {
        if (target == 0) {
            // We reached the number by picking the elements into our subset
            return true;
        }

        if (i == nums.length) {
            // Else know we reached the last element and we havent reached the target sum
            return false;
        }

        // We have two choices
        // Either take the number or not but we need to ensure our capacity is not exceeding

        // Always check at the top with memo
        if (dp[i][target] != null) {
            return dp[i][target];
        }

        boolean skip = helper(nums, target, i + 1, dp);


        boolean take = false;

        if (nums[i] <= target) {
            // There is no point in searching the take part if your current number itself exceeded the target
            take = helper(nums, target - nums[i], i + 1, dp);
        }

        dp[i][target] = skip || take; // Save at the bottom

        return dp[i][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 5})); // false
        System.out.println(canPartition(new int[]{1, 5, 11, 5})); // true
    }
}


