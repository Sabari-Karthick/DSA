package com.LinkedList.Problems;

import com.LinkedList.Problems.LinkedList.Node;

public class RemoveDuplicate {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.display();
		removeDupicate(list.getHead());
		list.display();
	}

	private static void removeDupicate(Node head) {
	  
		Node node = head;
		while(node.next != null) {
			if(node.data == node.next.data) {
				node.next = node.next.next;
			}
			else {
				node=node.next;
			}
		}
  
	}

}
