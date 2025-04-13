package com.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//import java.util.LinkedList;

public class PriorityQ {
	public static void main(String[] args) {
		
////		Queue<Double> q  = new LinkedList<>();if this is linked list it remains in the order where 
//		q.offer(2.5);
//		q.offer(3.0);
//		q.offer(4.0);
//		q.offer(1.5);
//      
//		while(!q.isEmpty()) {
//			System.out.println(q.poll());//Retrieves and removes
//		}
   // In priority Queue we generally insert the data in a particular way/order before poll it
		
		
		//Queue<Double> q = new PriorityQueue<Double>((x,y)->(int)(y-x));
		Queue<Double> q = new PriorityQueue<>(Collections.reverseOrder());//it gives a comparator 
		q.offer(2.5);
		q.offer(3.0);
		q.offer(4.0);
		q.offer(1.5);
		while(!q.isEmpty()) {
			System.out.println(q.poll());// now they are assigned in the order because of the number type
		}
		Queue<String> q1 = new PriorityQueue<>();
        q1.offer("Hi");
        q1.offer("Ha");
        q1.offer("Ho");
		while(!q1.isEmpty()) {
			System.out.println(q1.poll());// now they are assigned in the Alphabetical order because of the String type
		}
	}
}
