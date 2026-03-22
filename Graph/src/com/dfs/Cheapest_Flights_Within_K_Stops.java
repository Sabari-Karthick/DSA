package com.dfs;

import java.util.*;

class Cheapest_Flights_Within_K_Stops {
    // A global variable to remember the cheapest route we find
    int minCost = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build the Adjacency List (Your stopChart)
        // Storing: src -> List of [destination, price]
        Map<Integer, List<int[]>> stopChart = new HashMap<>();
        for (int[] f : flights) {
            stopChart.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        // 2. Your Path tracker (visited set to prevent flying in circles on the same trip)
        boolean[] visited = new boolean[n];
        visited[src] = true;

        // 3. Start the DFS
        dfs(src, dst, k, 0, 0, visited, stopChart);

        // If minCost never changed, we never found a valid route
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private void dfs(int currCity, int dst, int k, int stops, int currentCost, boolean[] visited, Map<Integer, List<int[]>> stopChart) {
        // BASE CASE 1: Did we reach the destination?
        if (currCity == dst) {
            minCost = Math.min(minCost, currentCost); // Save the cheapest!
            return;
        }

        // BASE CASE 2: Did we take too many stops? (Your "violated the max stops" check)
        if (stops > k) {
            return; 
        }

        // OPTIMIZATION: If our current flight already costs more than a route we already found, stop flying!
        if (currentCost >= minCost) {
            return; 
        }

        // If there are no outgoing flights from here, dead end.
        if (!stopChart.containsKey(currCity)) return;

        // Try every outgoing flight
        for (int[] flight : stopChart.get(currCity)) {
            int nextCity = flight[0];
            int price = flight[1];

            // If we haven't visited this city on our CURRENT path
            if (!visited[nextCity]) {
                visited[nextCity] = true; // Mark as visited
                
                // Fly to the next city! (Stops + 1, Cost + price)
                dfs(nextCity, dst, k, stops + 1, currentCost + price, visited, stopChart);
                
                visited[nextCity] = false; // BACKTRACK: Unmark it so other routes can use it later
            }
        }
    }
}