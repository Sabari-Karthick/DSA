package com.trees.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * <a href="https://leetcode.com/problems/path-sum-iii/description/">LeetCode</a>
 *
 */
public class PathSum3 {

}

class Solution2342gt1 {
    // Now the main caveat is path is not from root to leaf , it can be any
    // So if brute force means we first get all the paths and then check if any of them sum to targetSum

    // Okay what makes the brute force slow ?
    // Say we have a single straight branch 10 -> 5 -> 3  -> 4
    // When I do dfs(10) --> we get a sum of 22
    // Later when we move to the next node dfs(5) we need to calculate 5 + 3 again .

    // So is there a way we can resue some of the calculation we did earlier ??
    // Ok so lets say i keep a running_sum for each node

    // For 10 --> running_sum = 10
    // For 5 --> running_sum = 15
    // For 3 --> running_sum = 18
    // For 4 --> running_sum = 22

    // Now after one iteration ie, dfs(10) I got some running_sums
    // So now in the next if i want to know what is 5+3 How can i get that ??
    // I do the top running sum - bottom running sum ie , before 5 what is the running sum - at 3 what i the running sum
    // 18 - 15 = 3 (BIG Sum - Top Sum)

    ///  Current Running Sum - Old Running Sum = Sum of the path in between

    // So we solved one part where we dont need to recalculate again
    // Now how we know which part have the sum that is equal to target sum?

    // Ok lets say the target sum is 8

    // And currently we are at node 3 , which means the running_sum = 18
    // So till me i have 18 but i only need 8 so what should i do ?
    // Current Running Sum - targetSum =  18 - 8 = 10 (Means I need to chop a path that sums equal to 10)

    // Okay How I know ehether i encounted the a running sum 10
    // So we need to store the running sums in a hashmap

    // Here the ask is do i have a runnign sum of 10 // Rule of thumb : Always the ask is the key
    // So we have a hashmap with key being a running sum , okay what is the value ?

    // There maybe situations were we may encounter the same running multiple times
    // Eg 10 -> 5 -> -5 > 5 {10 : 2 , 15 :2}

    // So the frequency will be the value and we bactrack by reducing -1 whenever we leave the node
    public int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> rsumfrequency = new HashMap<>();

// Base case: A path starting from the root that perfectly matches targetSum
        rsumfrequency.put(0L, 1);

        return dfs(root, 0, targetSum, rsumfrequency);
    }

    private int dfs(TreeNode root, long currentSum, int targetSum, Map<Long, Integer> rsumfrequency) {

        if (root == null) return 0;

        // Calculate the run Sum
        currentSum += root.val;

        // Check whether we met the target
        long pathSumToChop = currentSum - targetSum;

        int validPaths = rsumfrequency.getOrDefault(pathSumToChop, 0);

        // Update the frequency
        rsumfrequency.put(currentSum, rsumfrequency.getOrDefault(currentSum, 0) + 1);

        validPaths += dfs(root.left, currentSum, targetSum, rsumfrequency);
        validPaths += dfs(root.right, currentSum, targetSum, rsumfrequency);

        // BackTrack
        rsumfrequency.put(currentSum, rsumfrequency.get(currentSum) - 1);


        return validPaths;
    }
}
