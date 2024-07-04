package com.trees;

import java.util.Scanner;

public class BinaryTree {
	
	private Node root;
	
	
	private class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

	}
	
	public void populate(Scanner sc) {
		System.out.println("Enter the value for the root:");
		int value = sc.nextInt();
		 root = new Node(value);
		populate(sc,root);
	}

	private void populate(Scanner sc, Node root) {
		System.out.println("Do you need to insert to the left of :"+ root.val+" ?");
		boolean left = sc.nextBoolean();
		if(left) {
			System.out.println("Enter the Left of the value :" +root.val+" ");
			int value = sc.nextInt();
			root.left = new Node(value);
			populate(sc,root.left);
		}
		System.out.println("Do you need to insert to the Right of :"+ root.val+" ?");
		boolean right = sc.nextBoolean();
		if(right) {
			System.out.println("Enter the Right of the value :" +root.val+" ");
			int value = sc.nextInt();
			root.right = new Node(value);
			populate(sc,root.right);
		}
		
		
	}
	public void display() {
		display(this.root,"");
	}

	private void display(Node node, String s) {
		if(node == null) {
			return;
		}
		System.out.println(s+node.val);
		display(node.left,s+"\t");
		display(node.right,s+"\t");
		
		
	}
	
	public void preetyDisplay() {
		preetyDisplay(this.root,0);
	}

	private void preetyDisplay(Node node, int  level) {
		if(node == null) {
			return;
		}
		
		preetyDisplay(node.right, level+1);
		if(level != 0) {
			for(int i=0;i< level-1;i++) {
				
				System.out.print("|\t\t");
			}
			System.out.println("|----------->"+node.val);
		}else {
			System.out.println(node.val);
		}
		preetyDisplay(node.left, level+1);
		
	}
}
