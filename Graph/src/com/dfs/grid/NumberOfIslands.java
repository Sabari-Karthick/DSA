package com.dfs.grid;

/**
 *
 * <a href="https://leetcode.com/problems/number-of-islands/description/">LeetCode</a>
 *
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new Solution324().numIslands(grid)); // Output: 3
    }
}
class Solution324 {

    // This is almost same as Number of Provinces, the only difference is that we are working with a 2D grid instead of an adjacency matrix.
    // So we need to check for the neighbours in four directions instead of just one direction.
    public int numIslands(char[][] grid) {

        int islands = 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                // The idea is if we see a non visited 'land' we found an island, so we can do a DFS to mark all the connected land as visited and then increment the island count.
                if(grid[r][c] == '1' && !visited[r][c]){
                    dfs(grid, visited, r, c);
                    islands++; // Everytime we do a DFS, it means we have found an island, so we can increment the count.
                }
            }
        }


        return islands;

    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {

        // But unline Number of Provinces, we need to check for the base case here, because we can go out of bounds or we can encounter water or we can encounter a visited land.
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited[r][c]){
            return;
        }

        // Mark the land as visited
        visited[r][c] = true;

        // All four directions
        dfs(grid, visited, r - 1, c); // Up
        dfs(grid, visited, r + 1, c); // Down
        dfs(grid, visited, r, c - 1); // Left
        dfs(grid, visited, r, c + 1); // Right

        // There will be problems were we can just go in two directions, like only right and down, because we are traversing the grid in a top left to bottom right manner, so we will never encounter a scenario where we need to go up or left.
        // But in this problem, we can have islands that are connected in all four directions, so we need to check for all four directions.
    }


    // Same as Number of Provinces, we can also solve this problem using Union Find, but it is more complex and less efficient than DFS in this case, because we need to iterate through the grid multiple times to perform the union operations and to count the number of islands.
    // And since it is a 2D array DSU parent array will be of size row * col, which can be large and can lead to memory issues.
    static class DSU{
        int[] parent;
        int island;

        DSU(int r, int c){
            parent = new int[r * c];
            island = r * c;
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int leaderX = find(x);
            int leaderY = find(y);

            if(leaderY != leaderX){
                parent[leaderY] = leaderX;
                island--;
            }
        }

    }


    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        DSU dsu = new DSU(n, m);

        // Populate the DSU
        for(int r = 0 ; r < n ; r++){
            for(int c = 0; c < m ; c++){
                // To Flatten 2D to 1D to store in the DSU
                int id = r * m + c; // Here it will skip that many columns for each row, and then add the column index to get the unique id for each cell in the grid.
                dsu.parent[id] = id;

                if(grid[r][c] == '0'){
                    dsu.island--;
                }
            }
        }

        // Direction we look for neighbors
        int[][] dir = {{1,0},{0,1}}; // Down and Right

        for(int r = 0 ; r < n ; r++) {
            for (int c = 0; c < m; c++) {
                if(grid[r][c] == '1'){
                    int id = r * m + c; // Current Land

                    for(int[] d : dir){
                        int nr = r + d[0];
                        int nc = c + d[1];

                        // Check the neighbor is not water
                        if(nr < n && nc < m && grid[nr][nc] != '0'){
                            int id2 = nr * m + nc; // Neighbor Land
                            dsu.union(id,id2);
                        }
                    }
                }
            }
        }

        return dsu.island;

    }
}