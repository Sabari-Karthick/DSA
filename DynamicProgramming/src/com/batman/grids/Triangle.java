package com.batman.grids;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return helper(0,0,triangle,dp);
    }

    private int helper(int r, int c, List<List<Integer>> triangle, Integer[][] dp) {
        // If we reached the Bottom
        if (r == triangle.size() - 1) return triangle.get(r).get(c);

        if(dp[r][c] != null) return dp[r][c];

        // Our standard option is moving to next row

        // Same Index next row
        int down = triangle.get(r).get(c) + helper(r + 1, c, triangle,dp);
        // Next Index , next row
        int diagonal = triangle.get(r).get(c) + helper(r + 1, c + 1, triangle,dp);

        dp[r][c] = Math.min(down, diagonal);

        return dp[r][c];
    }

}
