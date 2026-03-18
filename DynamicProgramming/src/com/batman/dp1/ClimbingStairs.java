package com.batman.dp1;
/**
 * 
 * 
 * LC : 70 --> https://leetcode.com/problems/climbing-stairs/description/
 * 
 * Question asks Distinct Ways so it is a recursive Problem
 * 
 * 
 * So the recursion is if f(n) is the recursion 
 * 
 * f(n) --> number of ways to reach the the number n from 0 (0 to n)
 * 
 * The stuff here is jump 1 or jump 2
 * 
 * So we can say each step is each index from 0 to n .
 * 
 * For our base case to reach 0th step number of ways is 1 
 * To get to step 1 number of ways is 1 
 * to step 2 number of ways is 2
 * 
 * Then at each index you can do jump 1 or jump 2 which means 
 * 
 * FROM (n-1) you jumbed one or from (n-2) you jumped 2 steps so calculate that number of ways for (n-1) and (n-2) steps
 * 
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4)); // 5
    }

    private static int climbStairs(int n) {
        // Distinct ways is a clear sign of DP

        // We have two options either jump 1 or 2
        // So till two stairs our choice is same
        if(n <= 2) return n; // As 0 means 0 ways, 1 means 1 ways , 2 means 2 ways [{1,1},{2}]

        int prev1 = 1; // For First Step
        int prev2 = 2; // For second Step

        for(int i = 3 ; i <= n ; i++){
            int current = prev1 + prev2; // Since we need all the possible ways
            prev1 = prev2; // So for 3 // prev1 = 2 (2 ways) and prev2 = 3 (3 ways)
            prev2 = current;
        }
        return  prev2;
    }

}


//Brute Force Recursion
class Solution {
    public int climbStairs(int n) {
     if (n <= 2) return n;
     return climbStairs(n - 1) + climbStairs(n - 2);
    }
}


//Dp 
class Solution3242 {
    public int climbStairs(int n) {
        if (n <= 2) return n; // 0 -> 1 step , 1 -> 1 step, 2 ->2step
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2; // dp[0] = 0 by default
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

//Since we need only two values to be remembered for each step we dont need to store fully
class Solution234234sfd {
    public int climbStairs(int n) {
        if (n <= 2) return n; // 0 -> 1 step , 1 -> 1 step, 2 ->2step
        int prev2 = 1 , prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1=cur;
        }
        return prev1;
    }
}


