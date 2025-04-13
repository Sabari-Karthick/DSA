package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 * 
 * 
 */
public class LevelOrderTraversal {

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

class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        //Track the Nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size(); // size is the number of nodes in that level
            List<Integer> lvl = new ArrayList<>(); //Values of Nodes in that lvl
            for(int i = 0 ; i< size ; i++){
                TreeNode node = queue.poll();
                lvl.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(lvl);
        }
        return ans;
    }
}