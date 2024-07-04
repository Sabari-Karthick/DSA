package com.trees;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
              BinaryTree tree = new BinaryTree();
              Scanner scanner = new Scanner(System.in);
              tree.populate(scanner);
              tree.preetyDisplay();
	}
}
