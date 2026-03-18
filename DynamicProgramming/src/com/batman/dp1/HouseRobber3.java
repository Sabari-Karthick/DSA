package com.batman.dp1;


// Rule of Thumb for a DFS , if a parent node cant decide its action until child finish theirs , the dfs should return the values
public class HouseRobber3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root)); // Output: 7
    }

    private static int rob(TreeNode root) {
        int[] result = robSub(root); // It will return result[rob,skip]
        return  Math.max(result[0], result[1]);
    }

    private static int[] robSub(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        // To choose whether to rob
        // Because if we rob root we cant rob the left and right and vice versa
        // So for the parent to decide whether to rob or skip we need to decision of child
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);


        int rob = root.val + left[1] + right[1];

        // While Skipping we need to consider the max of the left and right to avoid the rob of left is smaller that nskip of left
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // Dont be greedy as if we skip the root robbing left and right is obvious but we should consider the skip as well.

        return   new int[]{rob, skip};

    }




}
