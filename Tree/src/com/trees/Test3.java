package com.trees;


public class Test3 {
	public static void main(String[] args) {
             AVL avl = new AVL();
             for(int i=1;i<=1000;i++)
             {
            	avl.insert(i);
             }
             System.out.println(avl.height());
             
	}
}
