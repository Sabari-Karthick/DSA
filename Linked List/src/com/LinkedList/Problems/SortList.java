package com.LinkedList.Problems;

import com.LinkedList.Problems.LinkedList.Node;

public class SortList {//Bubble
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.display();
		bubbleSort(list.getHead());
		list.display();
	}

	private static void bubbleSort(Node head) {
		bubble(getSize(head)-1,0,head);
	}
	
	private static void bubble(int end, int start,Node head) {
		if(end==0) {
			return;
		}
		
		if(start<end) {
			Node f = getNodeAtIndex(start,head);
			Node s = getNodeAtIndex(start+1,head);
			if(f.data>s.data) {
				//if f == head
				if(f==head) {
					s=head;
					f.next= s.next;
					s.next=f;
				}else if(s.next==null) {
					//we need prev
					Node prev = getNodeAtIndex(start-1,head); 
					prev.next=s;
					s.next=f;
					f.next=null;
					
				}else {
					Node prev = getNodeAtIndex(start-1,head);
					prev.next=s;
					f.next=s.next;
					s.next=f;
				}
			}
			bubble(end, start+1,head);
		}
		bubble(end-1, start,head);
		
	}

	static Node getNodeAtIndex(int index,Node head) {
		Node node = head;
		for(int i=0;i<index;i++) {
			node = node.next;
		}
		return node;
	}
	static int getSize(Node head) {
		int size=0;
		Node node = head;
		while(node!=null) {
			node = node.next;
			size++;
		}
		return size;
	}
	
	
}
