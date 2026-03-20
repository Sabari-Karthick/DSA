package com.dfs.grid;

import java.util.ArrayList;
import java.util.List;


//
public class PacificAtlanticWaterFlow {
}


class Solutionh3qh{
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int n = heights.length;

        int m = heights[0].length;

        boolean[][] pacificReachable = new boolean[n][m];
        boolean[][] atlanticReachable = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            // Left Edge (Touches Pacific) -> Column is always 0
            dfs(heights, r, 0, pacificReachable, heights[r][0]);

            // Right Edge (Touches Atlantic) -> Column is always m-1
            dfs(heights, r, m - 1, atlanticReachable, heights[r][m - 1]);
        }

        for (int c = 0; c < m; c++) {
            // Top Edge (Touches Pacific) -> Row is always 0
            dfs(heights, 0, c, pacificReachable, heights[0][c]); // No need to check for map as we are not counting

            // Bottom Edge (Touches Atlantic) -> Row is always n-1
            dfs(heights, n - 1, c, atlanticReachable, heights[n - 1][c]);
        }

        for(int r = 0; r < n; r++){
            for (int c = 0; c < m; c++) {
                if(pacificReachable[r][c] && atlanticReachable[r][c]){
                    result.add(List.of(r,c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights,int r, int c,boolean[][] map,int prevHeight) { // Previous height is needed to
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || heights[r][c] < prevHeight || map[r][c]) return;

        map[r][c] = true;

        dfs(heights,r+1,c,map,heights[r][c]);
        dfs(heights,r,c+1,map,heights[r][c]);
        dfs(heights,r-1,c,map,heights[r][c]);
        dfs(heights,r,c-1,map,heights[r][c]);


    }
}