package com.LinkedList.Problems;

public class DeleteMiddle {

}

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
//class Solution {
//    public ListNode deleteMiddle(ListNode head) {
//			if(head == null || head.next == null){
//				return null;
//			}
//        ListNode mid = middle(head);
//				ListNode temp= head;
//				while(temp.next  != null){
//					temp = temp.next;
//				}
//				temp.next= mid.next;
//				
//				return head;
//    }
//
//	    ListNode middle(ListNode head){
//	        if(head.next==null){
//	            return head;
//	        }
//	        ListNode midPrev = null;
//	        while(head != null && head.next !=null ){
//	            midPrev = (midPrev==null)?head:midPrev.next;
//	            head     = head.next.next;
//	        }
//	        ListNode mid = midPrev.next;
//	        midPrev.next = null;
//	        return mid;
//	    }
//}