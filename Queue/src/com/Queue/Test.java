package com.Queue;

public class Test {
	public static void main(String[] args) throws Exception {
//                     CustomQueue queue = new CustomQueue(5);
//                     queue.insert(1);
//                     queue.insert(2);
//                     queue.insert(3);
//                     queue.insert(4);
//                     queue.display();
//                     queue.remove();
//                     queue.display();
                     
                     
                     CircularQueue queue = new CircularQueue(5);
                     queue.insert(1);
                     queue.insert(2);
                     queue.insert(3);
                     queue.insert(4);
                     queue.display();
                     queue.remove();
                     queue.display();
                     queue.insert(44);
                     queue.display();
                     
	}
}
