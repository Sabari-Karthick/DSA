package com.LinkedList.Problems;
/**
 * @author _karthick
 * 
 * 
 * Observations :
 *  Void return type and make changes in the linkedList
 *  
 *  Node return type that returns the list node  to change the structure
 * 
 *
 */
public class LinkedListReursion {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(6);
		linkedList.display();
		//linkedList.insertAtIndex(5, 4);
		linkedList.insertIn(5, 4);
		linkedList.display();
		linkedList.deleteFirst();
		linkedList.display();
		linkedList.deleteLast();
		linkedList.display();
		linkedList.deleteAtIndex(2);
		linkedList.display();
		System.out.println(linkedList.getSize());
	}
}

class LinkedList {
	public  Node head;
	private Node tail;
	private int size;

	 public Node getHead() {
		return head;
	}

	

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data,Node next) {
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
	
	public void insertIn(int data,int index) {
		head = insertAtIndexRec(data, index, head);
	}

	private Node insertAtIndexRec(int data,int index,Node node) {
		if(index==0) {
			Node temp = new Node(data,node);
			size++;
			return temp;
		}
		node.next= insertAtIndexRec(data, index-1, node.next);
		return node;
	}
	
	public void insertAtIndex(int data, int index) {
		if (index == 0) {
			insertFirst(data);
		} else if (index == size) {
			insert(data);
		} else {
			Node temp = head;
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			Node node = new Node(data);
			node.next = temp.next;
			temp.next = node;
			size++;
		}
	}
	
	public Node getNodeAtIndex(int index) {
		Node node = head;
		for(int i=0;i<index;i++) {
			node = node.next;
		}
		return node;
	}
	public int deleteFirst() {
		if(head==null) {
			return 0;
		}
		int data = head.data;
		
		head = head.next;
		if(head==null) {
			tail=null;
		}
		
		size--;
		return data;
	}
	
	public int deleteLast() {
		
		if(size<=1)
		{
			return deleteFirst();
			
		}
		Node secondLast = getNodeAtIndex(size-2);
		int data =  secondLast.data;
		secondLast.next=null;
		tail=secondLast;
		size--; 
		return data;
	}
	
	public int deleteAtIndex(int index) {
		if(index==0) {
			return deleteFirst();
		}
		if(index==size-1) {
			return deleteLast();
		} 
		Node prev = getNodeAtIndex(index-1);
		int data = prev.next.data;
		prev.next=prev.next.next;
		size--;
		return data;
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

}
