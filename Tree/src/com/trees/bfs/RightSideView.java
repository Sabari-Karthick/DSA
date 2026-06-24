package com.trees.bfs;

import com.trees.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // Same as level order traversing one change is we just need the right most element which is the last element of the level
        // If no element at right means left is the last of the level that is what we see from the side

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode last = new TreeNode();

            for (int i = 0; i < size; i++) {
                TreeNode val = queue.poll();

                if (val.left != null) {
                    queue.add(val.left);
                }

                if (val.right != null) {
                    queue.add(val.right);
                }

                last = val; // Update the last node of the level

            }

            result.add(last.val);

        }

        return result;

    }


    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result,0);

        return result;

    }

    public void dfs(TreeNode root,List<Integer> result,int depth){
        if(root == null) return;


        if(depth >= result.size()){
            result.add(root.val);
        }

        dfs(root.right,result,depth+1);
        dfs(root.left,result,depth+1);

    }
}
