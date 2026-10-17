package com.batman.dp1;

import java.util.Arrays;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        // We cannot se every possible ways on picking a Particular Number as that cause 2 power N because for each state we add a new entry to the existing one
        // Lets fix some obstacles , the first is the +1 and -1 ,
        int max = Arrays.stream(nums).max().getAsInt(); // To Map index to sum value
        // This makes all the groups near and we can avoid the skip case in total

        long[] dp = new long[max + 1];

        for (int num : nums) {
            dp[num] += num; // This will map the group sum of each number
        }

        long twoBack = 0, oneBack = 0;
        for (int i = 0; i <= max; i++) {
            // The Choice to take a number is if the next group is a +1 group and will taking the cur affect the next .
            // That is if teh current is a +1 group of rpevious and previous is bigger we need to take that.
            // But the catch is even if it is there a gap it will get filled by dp[m-1] equals the last non-zero best.
            // So the only choice is all +1 groups
            long cur = Math.max(oneBack, twoBack + dp[i]);
            twoBack = oneBack;
            oneBack = cur;
        }
        return (int) oneBack;
    }

    public int deleteAndEarn1(int[] nums) {

        int max = Integer.MIN_VALUE;

        Boolean[] np;

        for (int i = 0; i < nums.length; i++) {
            np = new Boolean[nums.length];
            max = Math.max(max, helper(i, nums, np));
        }
        return max;

    }

    private int helper(int i, int[] nums, Boolean[] np) {

        int cost = 0;

        getFilteredArray(i, nums, np);

        for (int j = 0; j < nums.length; j++) {
            Boolean[] copyNP = np.clone(); // We can't use the same np as for the current i we remove we have to see every non marked start seperatly
            if (np[j] == null) {
                cost = Math.max(cost, helper(j, nums, copyNP)); // Keep only the subproblem with max result
            }
        }

        return cost + nums[i];
    }

    private void getFilteredArray(int i, int[] nums, Boolean[] np) {
        np[i] = true;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == nums[i] + 1 || nums[j] == nums[i] - 1) {
                np[j] = true;
            }
        }
    }


    public static void main(String[] args) {
//        System.out.println(new DeleteAndEarn().deleteAndEarn1(new int[]{3, 4, 2})); // 6
//        System.out.println(new DeleteAndEarn().deleteAndEarn1(new int[]{2, 2, 3, 3, 3, 4})); // 9
//        System.out.println(new DeleteAndEarn().deleteAndEarn1(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10})); // 66
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{3, 4, 2})); // 6
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})); // 9
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10})); // 66
    }
}
