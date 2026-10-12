package com.batman.dp1;

/**
 *
 * The Flag: Single array + "Circular sequence" (first and last are adjacent) + "Cannot pick adjacent" + "Maximum sum".
 * <p>
 * The Intuition: A circle breaks linear DP because the end depends on the beginning.
 * <p>
 * Do not try to carry a "did I pick the first one?" boolean through your entire recursion tree.
 * <p>
 * Instead, physically cut the circle into two separate straight lines.
 * <p>
 * Since you cannot rob both House 0 and House n-1, the optimal answer must live in one of two parallel universes:
 * <p>
 * Universe A: You ignore the last house entirely (Run standard DP from 0 to n-2).
 * <p>
 * Universe B: You ignore the first house entirely (Run standard DP from 1 to n-1).
 * <p>
 * The Engine (The Standard Robber):helper(idx, end) = Math.max(helper(idx + 1, end), arr[idx] + helper(idx + 2, end))
 * <p>
 * The Formula (The Circle Breaker):Math.max(helper(0, n-2), helper(1, n-1))
 * <p>
 * Known States (Base Cases):The Circle Edge Case: If there is only 1 house total (n == 1), just rob it and return arr[0]. (Our 0 to n-2 logic breaks if there's only 1 house).
 * <p>
 * The Linear Base Case: idx > end $\rightarrow$ return 0.
 * <p>
 * The Memory: Integer[] dp (1D array).
 * <p>
 * Crucial note: Because you are running two completely separate simulations (Universe A and Universe B), you must use two separate DP arrays (or re-instantiate it), otherwise the memories will cross-contaminate.
 * <p>
 * Time Complexity: $O(n)$. You run a linear $O(n)$ scan twice. $O(2n)$ reduces to $O(n)$.
 * <p>
 * Space Complexity: $O(n)$ for the 1D memoization table + $O(n)$ for the recursion stack depth.
 *
 *
 */

public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2})); // 3
    }

    private static int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int robFirst = robStraight(nums, 0, nums.length - 2);
        int robLast = robStraight(nums, 1, nums.length - 1);

        return Math.max(robFirst, robLast);
    }

    static int robStraight(int[] nums, int start, int end) {


        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev2, nums[i] + prev1);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
