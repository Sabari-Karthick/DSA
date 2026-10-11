package com.batman.interval;

/**
 * The Flag: Single array + "chain/sequence of merges" + "cost of operations" + "minimum/maximum".
 * <p>
 * The Intuition: At any contiguous block of matrices from start to end, you have to find the best place to make the final merge.
 * <p>
 * The Trap: Simulating merges left-to-right creates new arrays, mutating state and causing memory explosion.
 * <p>
 * The Fix: Freeze the array. Use (start, end) pointers to define chunks.
 * <p>
 * The Choice: Slide a knife k from start to end - 1. For every k, your cost is the cost to build the Left chunk (start, k), plus the cost to build the Right chunk (k+1, end), plus the manual labor to multiply those two resulting chunks together.
 * <p>
 * The Formula: Math.min(cost, helper(start, k) + helper(k + 1, end) + (arr[start - 1] * arr[k] * arr[end]))
 * <p>
 * Known States (Base Cases): start == end $\rightarrow$ return 0. (A single matrix requires zero multiplications).
 * <p>
 * The Memory: Integer[][] dp = new Integer[n][n]. Indexing is always dp[start][end]. (Note: start never drops below 1, so row 0 is unused, which perfectly aligns with 1-based matrix numbering).
 * <p>
 * Time Complexity: $O(n^3)$. You have $O(n^2)$ possible (start, end) states to solve. Inside every state, you run a for loop that tests up to $n$ knife cuts. $n^2 \times n = n^3$.
 * <p>
 * Space Complexity: $O(n^2)$ for the 2D memo table + $O(n)$ for the recursion stack (the deepest the tree will go is splitting off one matrix at a time).
 */
public class MatrixChainMultiplication {
    public int matrixMultiplication(int[] arr) {
        // We need to know for multiplying the set of matrix and their cost memorized.
        // We can't store all the possible List of matrices by created new list everytime
        // So in order to avoid mutation of arr we need to play with the indexes of the array and store the cost of multiplying the matrices from i to j
        Integer[][] dp = new Integer[arr.length][arr.length];
        return helper(arr, 1, arr.length - 1, dp); // Arr represents the dimensions of the matrices so we need to start from 1 to n-1 as we need to multiply the matrices from 1 to n-1
    }

    private int helper(int[] arr, int s, int e, Integer[][] dp) {
        if (s == e) {
            // we have only one matrix and the cost is zero
            return 0;
        }

        if (dp[s][e] != null) { // Always check the memo at top
            return dp[s][e];
        }

        // Now to find the cost of the result which is eventually the result of two multiplication of matrix which is a continuous subarray without skip or mix we can see the left block and right block separated by a cut point k and
        // we can try all the possible cut points and take the minimum cost of all the possible cut points

        int cost = Integer.MAX_VALUE;

        for (int k = s; k < e; k++) { // k < e because we need to place k at further right but still need to have a matrix leftin the right block
            int left = helper(arr, s, k, dp);
            int right = helper(arr, k + 1, e, dp);

            // Left and right calc leave us with the two matrix cost and we need to multiply the left and right block
            // for a matrix multiplication of m x n and n x p the cost is m x n x p
            // Here s is the start and k is the split common and e is the end
            int totalCost = left + right + (arr[s - 1] * arr[k] * arr[e]); // s-1 becaue that represents the row of the left matrix and k represents the column of the left matrix and row of the right matrix and e represents the column of the right matrix

            // Dont update memory here as it will cause the Forged receipt scenario, where for a particular s,e we have multiple K so find the min out of all and update at last

            cost = Math.min(cost, totalCost);
        }

        dp[s][e] = cost;

        return cost;
    }


    public static void main(String[] args) {
        System.out.println(new MatrixChainMultiplication().matrixMultiplication(new int[]{2, 1, 3, 4})); //20
        System.out.println(new MatrixChainMultiplication().matrixMultiplication(new int[]{1, 2, 3, 4, 3})); //30
        System.out.println(new MatrixChainMultiplication().matrixMultiplication(new int[]{3, 4})); //0
    }
}
