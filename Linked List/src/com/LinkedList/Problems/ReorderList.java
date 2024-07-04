package com.LinkedList.Problems;

public class ReorderList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
//	class Solution {
//	    public void reorderList(ListNode head) {
//	          
//	          if(head == null || head.next == null){
//	              return;
//	          }
//	          ListNode hf = head;
//	          ListNode mid = middle(head);
//	          ListNode hs = reverseList(mid);
//	          ListNode  temp  = null;
//	          while(hf != null && hs != null){
//	              temp = hf.next;
//	              hf.next= hs;
//	              hf= temp;
//	              temp = hs.next;
//	              hs.next=hf;
//	              hs=temp;
//
//	          }
//	          if(hf != null){
//			
//	              hf.next=null;
//	          }
//
//
//	    }
//	     ListNode middle(ListNode head){
//		         ListNode hare = head;
//		          ListNode tortoise = head;
//		          while(hare != null && hare.next !=null){
//		              hare = hare.next.next;
//		              tortoise=tortoise.next;
//		          }
//		          return tortoise;
//		    }
//	      public ListNode reverseList(ListNode head) {
//		        if(head==null || head.next==null){
//		            return head;
//		        }
//
//		        ListNode past = null;
//				ListNode pres = head;
//				ListNode next = pres.next;
//				while (pres != null) {
//					pres.next=past;
//					past=pres;
//					pres=next;
//					if(next != null) {
//						next = next.next;
//					}
//				}
//				
//		        return past;
//		    }
//	}
}
