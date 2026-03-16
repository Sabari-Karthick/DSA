package com.trees.dfs;

/**
 *
 *  <a href="https://leetcode.com/problems/path-sum/description/">LeetCode</a>
 *
 */
public class PathSum {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);

        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(Solution234gh4.hasPathSum(treeNode,22)); // true

    }
}
class Solution234gh4 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // Straight Forward DFS

        // If root is null return false
        if (root == null) return false;

        // Now we know root wont be null
        int sum = 0;
        return dfs(sum,targetSum,root);
    }

    private static boolean dfs(int sum, int targetSum, TreeNode root) {
        // Since root wont be null;


        sum += root.val;

        // In this problem recursion breaker is always reaching the leaf node

        // If we reach the root node
        if(root.left == null && root.right == null) {
            return sum == targetSum;
        }

        // Now we know we havent reached the root yet so if the children are not null dfs

        boolean dfsLeft = false;
        if(root.left != null) dfsLeft = dfs(sum,targetSum,root.left);

        boolean dfsRight = false;
        if(root.right != null) dfsRight = dfs(sum,targetSum,root.right);

        return dfsLeft || dfsRight; // If either of the dfs is true return true

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
