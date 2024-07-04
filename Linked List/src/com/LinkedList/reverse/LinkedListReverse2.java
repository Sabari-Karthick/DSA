package com.LinkedList.reverse;


/**
 * @author _karthick
 * 
 * 
 *
 */
public class LinkedListReverse2 {
	public static void main(String[] args) {
		LinkedList2 linkedList = new LinkedList2();
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

class LinkedList2{
	public Node head;
	private Node tail;
	private int size;

	public Node getHead() {
		return head;
	}

	
	//https://leetcode.com/problems/reverse-linked-list-ii/submissions/
	public void reverseInRange(Node node , int left,int right){
		    if(left ==  right) {
		    	return;
		    }
		    Node  current = node;
		    Node prev = null;
		    for(int i=0; current != null  && i<left - 1;i++ ){//we need the previous node of the left
		    	prev = current;
		    	current = current.next;
		    }
		    Node last = prev;//this is the previous of the left
		    Node newEnd = current;//this will become the end of the sublist
		    Node next = current.next;
		    for(int i=0;i<  right -left +1 && current != null;i++ ) {
		    	current.next=prev;
				prev=current;
				current=next;
				if(next != null) {
					next = next.next;
				}
		    }
		    if(last != null) {
		    	last.next=prev;
		    }else {
		    	head = prev;
		    }
		    newEnd.next=current;
		    
		    
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
