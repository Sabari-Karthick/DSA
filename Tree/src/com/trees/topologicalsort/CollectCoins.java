package com.trees.topologicalsort;

import java.util.*;

public class CollectCoins {
}

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; ++i) graph[i] = new HashSet<>();

        // 1. Build the Map and count the dirt roads (degrees)
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // 2. PEELING STEP 1: Remove all leaves that have NO coins.
        for (int i = 0; i < n; ++i) {
            // If it's a leaf (degree 1) and has no coin (0)
            if (graph[i].size() == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int leaf = queue.poll();
            for (int neighbor : graph[leaf]) {
                graph[neighbor].remove(leaf); // Snap the branch
                // If the neighbor becomes a new empty leaf, add to queue
                if (graph[neighbor].size() == 1 && coins[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
            graph[leaf].clear(); // Completely remove the dead leaf
        }

        // 3. PEELING STEP 2: The Superpower (Peel exactly 2 layers of remaining leaves)
        // Load all CURRENT leaves (which we now know all have coins) into the queue
        for (int i = 0; i < n; ++i) {
            if (graph[i].size() == 1) {
                queue.offer(i);
            }
        }

        // We only peel exactly 2 layers because our superpower reaches 2 steps
        int layersToPeel = 2;
        while (layersToPeel > 0) {
            int size = queue.size(); // To know how many in each layer
            for (int i = 0; i < size; ++i) {
                int leaf = queue.poll();
                for (int neighbor : graph[leaf]) {
                    graph[neighbor].remove(leaf);
                    // If neighbor becomes a leaf, it will be peeled IN THE NEXT LAYER
                    if (graph[neighbor].size() == 1) {
                        queue.offer(neighbor);
                    }
                }
                graph[leaf].clear(); // Removing by making its size by zero
            }
            layersToPeel--;
        }

        // 4. THE CORE: Count the edges left in the graph
        int remainingEdges = 0;
        for (int i = 0; i < n; ++i) {
            remainingEdges += graph[i].size();
        }

        // Every remaining edge is counted twice in our graph array (A->B and B->A),
        // but remember we also have to walk every edge twice (down and back)!
        // So the raw count in our adjacency list is actually the exact answer.
        return remainingEdges;
    }
}