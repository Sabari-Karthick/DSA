package com.LinkedList;


public class DoublyLinkedList {
   public static void main(String[] args) {
	DoublyLL list = new DoublyLL();
	list.insertFirst(5);
	list.insertFirst(4);
	list.insertFirst(3);
	list.insertFirst(2);
	list.display();
	list.insertLast(6);
	list.display();
	list.insertAtIndex(33, 2);
	list.display();
}
   
}

class DoublyLL {

	private Node head;
	private int size;

	class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public int getSize() {
		return size;
	}

	public void insertFirst(int data) {

		Node node = new Node(data);
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		

		size++;
	}
	
	public void insertLast(int data) {
		
		Node node = new Node(data);
		Node last = head;
		node.next=null;
		if(head==null) {
			node.prev=null;
			node.next=null;
			head=node;
			return;
		}
		
		while(last.next != null) {
			last=last.next;
		}
		last.next=node;
		node.prev=last;
		size++;
		
		
	}
	
	public void insertAtIndex(int data , int index) {
		Node node = new Node(data);
		if(index==0) {
			insertFirst(data);
			return;
		}
		if(index==size) {
			insertLast(data);
			return;
		}
		Node prev = head;
		for(int i=1;i<index;i++) {
			prev=prev.next;
		}
		node.next=prev.next;
		node.prev=prev;
		prev.next=node;
		node.next.prev=node;
	}
	
	public void display() {
		Node node = head;
		Node last = null;
		while(node!= null) {
			System.out.print(node.data+" -> ");
			last=node;
			node=node.next;
		}
		System.out.println("End");
		while(last != null) {
			System.out.print(last.data+" -> ");
			last=last.prev;
		}
		System.out.println("Start");
	}

}
