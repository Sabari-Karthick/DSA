package com.LinkedList.Problems;
//https://leetcode.com/problems/palindrome-linked-list/submissions/
public class PallindromeLinkedList {

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
//	    public boolean isPalindrome(ListNode head) {
//	        ListNode mid = middle(head);
//	        ListNode shead = reverseList(mid);
//	        ListNode rhead = shead;
//	        while(head != null && shead != null){//mid actually split the list before mid and after mid
//	            if(head.val != shead.val){
//	                return false;
//	            }
//	            head=head.next;
//	            shead=shead.next;
//	        }
//	         reverseList(rhead);
//	         return head==null||shead==null;
//	    }
//	  
//	    
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
//
//
//	    public ListNode reverseList(ListNode head) {
//	        if(head==null || head.next==null){
//	            return head;
//	        }
//
//	        ListNode past = null;
//			ListNode pres = head;
//			ListNode next = pres.next;
//			while (pres != null) {
//				pres.next=past;
//				past=pres;
//				pres=next;
//				if(next != null) {
//					next = next.next;
//				}
//			}
//			
//	        return past;
//	    }
//	}
}
