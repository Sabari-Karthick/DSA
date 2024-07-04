package com.LinkedList.Problems;
/**
 * @author _karthick
 * 
 * Cycle Detection,Finding a node in the cycle use -> Fast and slow pointer approach
 * 
 * Tortoise and Hare
 * 
 * https://leetcode.com/problems/linked-list-cycle-ii/submissions/
 *
 */
public class LinkedListCycle2 {
//	public ListNode detectCycle(ListNode head) {
//        
//        ListNode tortoise = head;
//        ListNode hare     = head;
//        boolean isCycle = false;
//        while(hare != null && hare.next != null){
//            hare = hare.next.next;
//            tortoise=tortoise.next;
//            if(tortoise == hare){
//                isCycle = true;
//             break;
//            }
//
//        }
//        if(!isCycle){
//            return null;
//        }
//        
//        tortoise = head;
//        while(tortoise != hare){
//            tortoise = tortoise.next;
//            hare=hare.next;
//        }
//        return tortoise;
//    
//    }
}
