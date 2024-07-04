package com.LinkedList.reverse;

/**
 * @author _karthick
 * 
 * 
 *
 */
public class LinkedListReverse {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.display();
		linkedList.reverse(linkedList.getHead());
		linkedList.display();
		linkedList.reverseInPlace(linkedList.getHead());
		linkedList.display();

	}
}

class LinkedList {
	public Node head;
	private Node tail;
	private int size;

	public Node getHead() {
		return head;
	}

	public void reverseInPlace(Node node) {
		if(size<2) {
			return;
			
		}
		Node past = null;
		Node pres = head;
		Node next = pres.next;
		while (pres != null) { 
			pres.next=past;
			past=pres;
			pres=next;
			if(next != null) {
				next = next.next;
				head=pres;
			}
		}
	}

	class Node {
		int data;
		Node next; 

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public void insertFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		if (tail == null) {
			tail = head;
		}
		size = getSize() + 1;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	public Node getNodeAtIndex(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public void insert(int data) {
		if (tail == null) {
			insertFirst(data);
			return;
		}
		Node node = new Node(data);
		tail.next = node;
		tail = node;
		size = getSize() + 1;
	}

	public int getSize() {
		return size;
	}
	
	public void reverse(Node node) {
		if(node==null) {
			head=tail;
			return;
		}
		reverse(node.next);
		tail.next=node;
		tail=node;
		tail.next=null;
		
	}

}
