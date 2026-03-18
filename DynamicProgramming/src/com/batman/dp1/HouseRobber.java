package com.batman.dp1;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(Solution234b4h234m9.rob(new int[]{1,2,3,1})); // Output : 4
    }
}

class Solution234b4h234m9 {
    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        // We need a notepad to store decisions
        int[] dp = new int[nums.length]; // At each house we decide whether to rob or not

        // Always for DP assume we have building the array while searching only for the start
        dp[0] = nums[0]; // As we have one house that is our best bet
        dp[1] = Math.max(nums[0], nums[1]); // We rob the house with the max profit

        // Now we have our decisions
        for (int i = 2; i < nums.length; i++) { // From the next house

            // We have two choice either choose that house or skip
            // Math.max(choiceB,ChoiceA)

            // Choice A is sum the one previous house
            // Choice B is skip and continue the previous house profit
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);

        }

        return dp[nums.length - 1]; // The last entry

    }

    public static int rob2(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];



        int prev1 = nums[0]; // First House Profit
        int prev2 = Math.max(nums[0], nums[1]); // Second House Profit;

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(prev2, nums[i] + prev1); // I carry the second house or sum with the first house
            prev1 = prev2; // So next time I either take this value to add
            prev2 = temp; // Or carry this value
        }

        return prev2;
    }
}