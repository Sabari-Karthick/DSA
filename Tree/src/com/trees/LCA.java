package com.trees;

public class LCA {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution234242dbfgsy34{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if(l != null && r != null){
            //Means both have a ancestor which is what is the root in their call
            return root;
        }
        
        //Else if there is a non null one that is the ancestor
        return l == null ? r : l;
    }
}