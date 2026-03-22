package com.bfs;

import java.util.*;

public class MinimumCosttoMakeatLeastOneValidPathGrid {
}

class Solutionnw845 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] cost = new int[m][n]; // As we may need to revisit the cell and act with the rules

        for(int[] row : cost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Here For Grids there is no rules to traverse to the next cell
        // So we have no hashmap as the graph
        // Rather every cell with in the grid are the relations
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}}; // R L B U

        // And each Direction is in our level here at that cell
        Deque<List<Integer>> queue = new ArrayDeque<>();

        // Start at 0,0
        queue.offer(List.of(0,0));
        cost[0][0] = 0;

        while(!queue.isEmpty()){
            // We dont need snapshots as the level is always 4 directions
            List<Integer> list = queue.poll();

            int r =  list.get(0);
            int c = list.get(1);

            for (int d = 0 ; d < 4 ; d++){ // Here the level is the where i can move which is the all four directiosn
                int[] dir =  directions[d];
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int ticketPrice = 0;

                // If the current cell arrow not point the expected direction
                if(d+1 != grid[r][c]) ticketPrice = 1;


                // If the next cell have a price that is higher than our new price we can move there
                if(cost[nr][nc] > cost[r][c] + ticketPrice){
                    if (ticketPrice == 1) {
                        queue.addLast(List.of(nr, nc));
                    } else {
                        queue.addFirst(List.of(nr, nc));
                    }
                    cost[nr][nc] = cost[r][c] + ticketPrice; // Dont calculate Primitive in BFS
                }

            }
        }

        return cost[m-1][n-1]; // Let the ledger do the final return rather we check for condition

    }
}