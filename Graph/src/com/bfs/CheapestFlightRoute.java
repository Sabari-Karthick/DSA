package com.bfs;

import java.util.*;

public class CheapestFlightRoute {
    public static void main(String[] args) {
        System.out.println(Solution9753bsdf.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
    }
}

class Solution9753bsdf {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Unless BusRoutes here we may need to retake a flight which we initially encountered if we see a less price
        // So the trackpad is cost rather visited

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        // Now we need the graph
        Map<Integer, List<Integer[]>> flightChart = new HashMap<>();

        for (int i = 0; i < n; i++) {
            flightChart.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            flightChart.get(flight[0]).add(new Integer[]{flight[1], flight[2]}); // Src -> {dst,price}
        }

        // Since we need to find the min cost within steps BFS is the best option
        // So we take src and get the flight details and go level by level

        Queue<Integer[]> queue = new ArrayDeque<>();

        List<Integer[]> flightsList = flightChart.get(src);

        // Put the starting point into the queue
        for (Integer[] flight : flightsList) {
            queue.offer(flight);
            cost[flight[0]] = Math.min(cost[flight[0]], flight[1]); // it updates the nextStop Cost from source
        }


        while (!queue.isEmpty() && k-- > 0) { // We should not exceed the level --> K tells how many times we can do

            int flightQueueSize = queue.size(); // Take the snapshot of the level size

            for (int f = 0; f < flightQueueSize; f++) { // Do level
                Integer[] flight = queue.poll(); // For every level do one flight in queue

                int nextSrc = flight[0];
                int price = flight[1];

                for (Integer[] nextFlight : flightChart.get(nextSrc)) {  // Add the next level into the queue
                    if (cost[nextFlight[0]] > nextFlight[1] + price) { // If they are optimal
                        queue.offer(new Integer[]{nextFlight[0], price + nextFlight[1]}); // Dont calculate primitives in BFS
                        cost[nextFlight[0]] = nextFlight[1] + price; // So that next time we have the price tracked
                    }
                }

            }

        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst]; // We never need to know whether we reach the destination or not as BFS using ledger always update all the ledger and return the ledger.

    }
}