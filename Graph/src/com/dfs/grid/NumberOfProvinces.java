package com.dfs.grid;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/description/">LeetCode</a>
 *
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(Solution.findCircleNum(isConnected)); // Output: 2
    }
}

class Solution {
    public static int findCircleNum(int[][] isConnected) {

        int provinces = 0;

        // The Idea is search every city and if they are connected go deep and mark them.
        // So it will turn out like all the visited city via one city will form one province.
        // We won't search for the visited city again, so we will only count the province once.


        boolean[] visited = new boolean[isConnected.length];

        for (int city = 0; city < isConnected.length; city++) { // Dont use for each loop as it would take zero and one only , where index represents the city.
            // if the city is not visted
            if (!visited[city]) {
                dfs(isConnected, visited, city);
                // if we do DFS on a city, it means we have found a province, so we can increment the count.
                provinces++;
            }
        }

        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {

        // There is no base case for this DFS, because we are using the visited array to keep track of the visited cities
        // . So if we reach a city that is already visited, we will simply return from the function.
        // There wont be a scenario of stack overflow because we are marking the visited cities and we will never go deep into a city that is already visited.

        // Mark the city as visited
        visited[city] = true;

        // Check whether the neighbour is connected
        for (int neighbour = 1; neighbour < isConnected.length; neighbour++) { // We can use index based loop as well, but this is more readable.
            // If the neighbour is connected and not visited, we can go deep into it.
            if (isConnected[city][neighbour] == 1 && !visited[neighbour]) {
                dfs(isConnected, visited, neighbour); // Why Double visited check is needed is because we can have a case where city A is connected to city B, and city B is connected to city A. So if we don't check for visited, we will end up in an infinite loop.
            }
        }
    }


    // This Problem tell one more pattern.
    // If we seen the ask we need cities that belongs to a groups if they are connected.
    // Whenever a group is asked based on some relations between them , We can use Union Find.
    // DFS increase the number of groups found as it goes deep, while Union Find will decrease the number of groups as it merges them together.
    public static int findCircleNum2(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);

        // Now we need to go through pairs
        for(int city = 0; city < isConnected.length; city++){
            for(int neighbour = city + 1; neighbour < isConnected.length; neighbour++){
                if(isConnected[city][neighbour] == 1){
                    dsu.union(city, neighbour); // If they are connected, we merge them together.
                }
            }
        }

        return dsu.count;
    }

    public static class DSU {
        // DSU Class is always standard.

        // A parent array to keep track of the parent of each element.
        int[] parent; // Here Parent array holds the leader for each value (city). Initially it points to itself, meaning each city is its own leader (or province).
        int count; // Count variable to keep track of the number of provinces. Initially, it is equal to the number of cities, because each city is its own province. And get reduced by union().

        DSU(int n) {
            parent = new int[n];
            count = n; // Initially, each city is its own province.
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Each city is its own leader initially.
            }
        }

        // There are some other fields which will optimize like rank or size.

        // Two major functions
        int find(int x) {
            // Returns the leader.
            if (parent[x] != x) { // Meaning, since we started all cities as their own leader, a parent that is not itself means it has been merged with another city, so we need to find the leader of that city.
                parent[x] = find(parent[x]); // Path compression optimization.
            }
            return parent[x];
        }

        void union(int x, int y) {
            // Find their leaders
            int leaderX = find(x);
            int leaderY = find(y);

            // If they are not equal, we merge them.
            // the thing is union will be called iff the relation between the values are satisfied

            // So mark either of the leader to the other, it doesn't matter which one we choose as the new leader, but we can optimize it by using rank or size.
            if (leaderX != leaderY) {
                parent[leaderX] = leaderY; // Merge leaderX into leaderY
                count--; // Since we merged two provinces, we reduce the count by 1.
            }
        }
    }
}