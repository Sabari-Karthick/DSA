package com.LinkedList.Problems;


public class MergeSortLinkedList {
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
//	    public ListNode sortList(ListNode head) {
//	        if(head==null || head.next == null){
//	            return head;
//	        }
//	        ListNode mid = middleNode(head);
//	        
//	        ListNode left = sortList(head);
//	        ListNode right = sortList(mid);
//	        return mergeTwoLists(left,right);
//	    }
//	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//	        ListNode head =  new ListNode();
//	        ListNode node = head;
//	        while(list1  != null && list2 != null){
//	            if(list1.val < list2.val){
//	                node.next=list1;//adding in the answer
//	                list1=list1.next;//moving the  list node
//	                node=node.next;//moving the answer node to insert tht next
//	               
//	            }else{
//	                 node.next=list2;//adding in the answer
//	                list2=list2.next;//moving the  list node
//	                node=node.next;//moving the answer node to insert tht next
//	            }
//	        }
//	        node.next = (list1 != null) ? list1:list2;
//	        return head.next;
//	    }
//	     public ListNode middleNode(ListNode head) {//to split the array to half
//
//	          ListNode midPrev = null;
//	         
//	          while(head != null && head.next !=null){
//	            midPrev = (midPrev==null)?head:midPrev.next;
//	            head=head.next.next;
//	          }
//	          ListNode mid = midPrev.next;
//	          midPrev.next=null;
//	          return mid;
//	    }
//	}
//	
}
