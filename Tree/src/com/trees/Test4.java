package com.trees;

public class Test4 {
	public static void main(String[] args) {
          SegmentTree tree = new SegmentTree(new int[] {3,2,8,5,6,1});
          int ans = tree.query(2, 5);
          System.out.println(ans);
	}
}
