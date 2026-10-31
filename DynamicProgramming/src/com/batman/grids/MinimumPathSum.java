package com.batman.grids;

/**
 *
 * The Flag: A grid with numbers (costs/tolls) + movement constraints + "Minimum/Maximum path sum".
 * <p>
 * The Intuition: The absolute cheapest way to reach the exit from where I am right now is: the toll booth I am currently standing on + the cheapest future path available to me.
 * <p>
 * The Formula: cost = grid[row][col] + Math.min(helper(RIGHT), helper(DOWN))
 * <p>
 * Known States (Base Cases):Finish Line: On the bottom-right tile? Return grid[row][col]. (Just pay the final toll).The Void: Fall off the board? Return Integer.MAX_VALUE. (Force Math.min to reject this path).
 * <p>
 * The Memory: 2D array Integer[][] dp = new Integer[m][n];.
 * <p>
 * Time Complexity: $O(m \times n)$. The robot visits each tile exactly once, and because of the memory array, it never recalculates a tile.
 * <p>
 * Space Complexity: $O(m \times n)$ to store the 2D memory array, plus the depth of the recursive call stack (which goes up to $O(m + n)$).
 */


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return helper(0, 0, grid, dp);
    }

    private int helper(int r, int c, int[][] grid, Integer[][] dp) {
        if (r == grid.length - 1 && c == grid[0].length - 1)
            return grid[r][c]; // We reached the last and the only cost is the cost of the tile

        if (r >= grid.length || c >= grid[0].length)
            return Integer.MAX_VALUE; // Out of bounds we fall out // Be careful on Integer rounding, we need to return a large number so that it is not considered in the min calculation

        if (dp[r][c] != null) return dp[r][c];

        // Our cost here is current cost plus the best next choice
        dp[r][c] = grid[r][c] + Math.min(helper(r + 1, c, grid, dp), helper(r, c + 1, grid, dp)); // Move down or right
        return dp[r][c];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}})); // 7
    }
}
