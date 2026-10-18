package com.batman.counting;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][2001]; // We have the target ranging from -1000 to 1000 and our mapping is index to target only
        return dfs(0,nums,target,0,dp);
    }

    private int dfs(int i, int[] nums, int target, int sum, Integer[][] dp) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int sumIdx = sum + 1000; // Sum can be negative

        // Check cache for the CURRENT state right away
        if (dp[i][sumIdx] != null) {
            return dp[i][sumIdx];
        }

        int plusPath = dfs(i + 1, nums, target, sum + nums[i], dp);
        int minusPath = dfs(i + 1, nums, target, sum - nums[i], dp);

        // Save the combined result for the CURRENT state
        dp[i][sumIdx] = plusPath + minusPath;

        return dp[i][sumIdx];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1}, 1)); // 1
    }
}
