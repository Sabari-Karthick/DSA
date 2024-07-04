package com.LinkedList;

public class CircularLinkedList {
	public static void main(String[] args) {
             CircularLL list = new CircularLL();
             list.insert(1);
             list.insert(2);
             list.insert(3);
             list.insert(4);
             list.display();
             list.delete(4);
             list.display();
             
	}
}

class CircularLL {

	private Node head;
	private Node tail;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}
	
	
	public void insert(int data) {
		Node node = new  Node(data);
		if(head==null) {
			head=node;
			tail=node;
		    return;			
		}
		tail.next=node;
		node.next=head;
		tail=node;
	}
	
	public void display() {
		Node node = head;
		if(head != null) {
		do {
			System.out.print(node.data+" -> ");
			node = node.next;
		}while(node !=head);
		}
		System.out.println(node.data+"(HEAD)");
	}
	
	public void delete(int data) {
		Node node = head;
		if(node==null) {
			return;
		}
		
		if(node.data==data) {
			head  = head.next;
			tail.next=head;
		}
		do {
			Node n=node.next;
			if(n.data==data) {
				node.next= n.next;
				break;
			}
			node=node.next;
		}while(node !=head);
	}

}
