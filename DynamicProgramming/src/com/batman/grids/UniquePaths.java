package com.batman.grids;

/**
 * The Flag: A grid, a starting point, an end point, and a rule limiting your movement (e.g., "only right and down") + "Total number of ways/paths".
 * <p>
 * The Intuition: The number of ways to win from your current tile is simply the sum of the winning paths of your available moves. (Reality A + Reality B).
 * <p>
 * The Formula: paths = helper(RIGHT) + helper(DOWN)
 * <p>
 * Known States (Base Cases): Hit the exit? Return 1 (One valid path). Fall off the board? Return 0 (Zero valid paths).
 * <p>
 * The Memory: 2D array, because your physical state requires an X and a Y coordinate to track.
 *
 */

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n]; // Memo
        return helper(0, 0, m, n, dp); // We need every path from the start
    }

    private static int helper(int row, int col, int m, int n, Integer[][] dp) {
        if (row == m - 1 && col == n - 1) return 1; // Reached the destination
        if (row >= m || col >= n) return 0; // Out of bounds we fall out

        if (dp[row][col] != null) return dp[row][col];

        dp[row][col] = helper(row + 1, col, m, n, dp) + helper(row, col + 1, m, n, dp); // Move down or right

        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
    }
}

