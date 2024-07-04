package com.trees;

public class BST {

	private Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;
		private int height;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public int getHeight(Node node) {// maximum height is log(n)
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void display() {
		display(this.root, "Root node: ");
	}

	private void display(Node node, String details) {
		if (node == null) {
			return;
		}
		System.out.println(details + node.getValue());
		display(node.left, "Left Child of :" + node.getValue() + " : ");
		
		display(node.right, "Right Child of :" + node.getValue() + " : ");

	}

	public void populate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			this.insert(nums[i]);
		}
	}

	public void insert(int value) {
		root = insert(value, this.root);
	}

	private Node insert(int value, Node node) {
		if (node == null) {
			node = new Node(value);
			return node;
		}
		if (node.value > value) {
			node.left = insert(value, node.left);
		}

		if (node.value < value) {
			node.right = insert(value, node.right);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;// because one node is added
		return node;

	}
	
	public void populateSoted(int []nums) {// if the input array is  sorted the tree became skewed so we split the array and insert
		 populatedSorted(nums, 0, nums.length); //n *  log(n) 
	}

	private void populatedSorted(int[] nums, int start, int end) {
		 if(start >= end) {
			 return;
		 }
		 int mid = start + (end - start)/2;
		 this.insert(nums[mid]);
		 populatedSorted(nums, start, mid);
		 populatedSorted(nums, mid+1, end);
		 
		 
	}
	
	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {//O(N)
		if(node == null) {
			return;
		}
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
		
		
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {//O(N)
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
		
		
	}
	
	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {//O(N) -> N numbers printing 
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value+" ");
		
		
	}
	public boolean isBalanced() {
		return balanced(this.root);
	}

	private boolean balanced(Node node) {
		if (node == null) {
			return true;
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}
}
