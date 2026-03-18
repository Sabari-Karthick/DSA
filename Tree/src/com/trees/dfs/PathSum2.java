package com.trees.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);

        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(Solution234go03.pathSum(treeNode,22));
    }
}

class Solution234go03 {

    // This problem is similar to PathSum , But instead now we need to return all the paths that sum to targetSum
    // Here when we reach the leaf we check add add the path to the result
    // But one catch is the path list we keep in the recursion will be same for all the paths
    // So we need to make a new list for each path while adding to the result
    // And while leaving the path we should reset the path by removing the last element (Backtracking)

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          List<List<Integer>> result = new ArrayList<>();

          if(root == null) return result;

          List<Integer> path = new ArrayList<>();

          int sum = 0;

          dfs(root, targetSum, sum, path, result);
          return result;
    }

    private static void dfs(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
        // We already know root wont be null so

        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(path)); // We need to create a copy rather than adding the same list Why? Because we are using the same list for all the paths
        }

        // Now we know we havent reached the root yet so if the children are not null dfs
        if(root.left != null) dfs(root.left, targetSum, sum, path, result);
        if(root.right != null) dfs(root.right, targetSum, sum, path, result);

        // Backtrack
        // Rule of Thumb For each DFS we only back track once not after each call
        // And Dont remove like path.remove(root.val) because we need to maintain the order so remove the last added element

        path.remove(path.size()-1);
        // We dont need to reset primitive variables as they are passed by value

    }
}
