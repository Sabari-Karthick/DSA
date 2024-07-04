package com.trees;


public class AVL {
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
		return rotate(node);

	}
	
	private Node rotate(Node node) {
		
		if(height(node.left) - height(node.right) >1) { // means it is left heavy -> LL OR LR
			if(height(node.left.left)-height(node.left.right)>0) {//LL
				return rightRotate(node);
			}else {//LR
				node.left =  leftRotate(node.left);//rotate on child
				return rightRotate(node);
			}
		}
		 if (height(node.left) - height(node.right) < -1) {
		      // right heavy
		      if(height(node.right.left) - height(node.right.right) < 0) {
		        // right right case
		        return leftRotate(node);
		      }
		      if(height(node.right.left) - height(node.right.right) > 0) {
		        // left right case
		        node.right = rightRotate(node.right);//rotate on child
		        return leftRotate(node);
		      }
		    }
		return node;//if no condition is met
	}

	 public Node leftRotate(Node c) {
		    Node p = c.right;
		    Node t = p.left;

		    p.left = c;
		    c.right = t;
		    
		    p.height = Math.max(height(p.left), height(p.right) + 1);
		    c.height = Math.max(height(c.left), height(c.right) + 1);

		    return p;
		  }
	private Node rightRotate(Node node) {
		
		Node child = node.left;
		Node t = child.right;
		child.right = node;
		node.left = t;
		
		node.height = Math.max(height(node.left), height(node.right)+1);
		child.height = Math.max(height(child.left), height(child.right)+1);
		return node;
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
	 public int height() {
		    return height(root);
		  }
	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}
}
