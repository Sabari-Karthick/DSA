package com.bfs;

import java.util.*;

public class BusRoutes {
}
class Solution25dskjr3 {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target)
            return 0;

        Map<Integer, List<Integer>> stopChart = new HashMap<>();

        boolean[] visited = new boolean[routes.length];

        for (int i = 0; i < routes.length; i++) {
            for (int route : routes[i]) {
                stopChart.computeIfAbsent(route, k -> new ArrayList<>()).add(i);
            }
        }

        if (stopChart.get(source) == null)
            return -1;

        Queue<Integer> busQueue = new ArrayDeque<>();

        for (int bus : stopChart.get(source)) {
            busQueue.add(bus);
            visited[bus] = true;
        }

        int numberOfBusTaken = 1;

        while (!busQueue.isEmpty()) {
            int numberOfBuses = busQueue.size();
            for (int i = 0; i < numberOfBuses; i++) {
                int bus = busQueue.poll();

                for (int stop : routes[bus]) {
                    if (stop == target)
                        return numberOfBusTaken;

                    for (int nextBus : stopChart.get(stop)) {
                        if (!visited[nextBus]) {
                            busQueue.add(nextBus);
                            visited[nextBus] = true;
                        }
                    }
                }
            }

            numberOfBusTaken++;
        }

        return -1;

    }
}