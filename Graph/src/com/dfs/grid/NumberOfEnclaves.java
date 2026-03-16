package com.dfs.grid;

/**
 *
 * <a href="https://leetcode.com/problems/number-of-enclaves/description/">LeetCode</a>
 *
 *
 *  There is one Ditto problem
 * <a href="https://leetcode.com/problems/surrounded-regions/description/">Leetcode2</a> *
 *
 *  Same as this instead of returning count we flip the values of the not invalidated 'O's to 'X'
 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(new Solution234g3().numEnclaves(grid)); // Output: 3
    }
}
class Solution234g3 {
    //An enclave is a group of 1s that are completely surrounded by 0s.

    // This also quite similar to Number of Islands .
    // But where to start the DFS is the main question.
    // And the answer is always start with a node or cell that give a certain answer.
    // So here a boundary land cell is that which guarantees that all lands linked to a boundary land cell are not enclaves.
    // So start with a boundary land , mark the linked lands as visited. Traverse the grid and count the unvisited land cells, which would be the enclaves.
    public int numEnclaves(int[][] grid) {

        int enclaves = 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                // Check for boundary land cell
                if((r == 0 || c == 0 || r == row - 1 || c == col - 1) && grid[r][c] == 1 && !visited[r][c]){
                    dfs(grid, visited, r, c);
                }
            }
        }

        // Now we have marked all the land cells that are connected to the boundary land cells as visited, so we can count the unvisited land cells which would be the enclaves.
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1 && !visited[r][c]){
                    enclaves++;
                }
            }
        }


        return enclaves;

    }

    private void dfs(int[][] grid, boolean[][] visited, int r, int c) {
        // Check the base conditions
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]){
            return;
        }

        // Mark the land as visited
        visited[r][c] = true;

        // All four directions
        dfs(grid, visited, r - 1, c); // Up
        dfs(grid, visited, r + 1, c); // Down
        dfs(grid, visited, r, c - 1); // Left
        dfs(grid, visited, r, c + 1); // Right

    }
}