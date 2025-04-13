package com.trees;

public class DiameterOfBT {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution33324gega {
    int     max = 0; // diamter
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    int height(TreeNode node){
        if(node == null) return 0;
        int l = height(node.left);
        int r = height(node.right);
    
        //Update the diameter

        max = Math.max(max,l+r);
        return Math.max(l,r)+1;
    }
}