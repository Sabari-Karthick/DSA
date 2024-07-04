package com.notes;
/**
 * 
 * @author karthick
 * 
 *  Queue -> FIFO / LILO  -> internal implementation is array in java
 *  add() - > to insert -> throwing an {@code IllegalStateException} if no space is currently available
 *  offer() -> insert -> preffered in the capacity restricted queue, return false if not possible
 *  peek() -> return  the first
 *  remove() -> retrieve and remove the head -> throws exception if empty 
 *  poll() ->Retrieves and removes the head of this queue, or returns {@code null} if this queue is empty
 * 
 * Better is poll and offer
 * 
 * 
 * 
 * 
 * Stack -> FILO/LIFO -> internal array
 * 
 * 
 * search(Object o)-> Returns the 1-based position where an object is on this stack.
 * Push and pop ->  to insert and retrieve then remove operations 
 * 
 * 
 * 
 * When we needs the answer to be stored far , that is when the answer is needed for the long time for further use queues and stacks are used
 * Main is IN DFS and BFS 
 *  
 *  
 *  If Something deals with ordering/sequence stacks and queues be used
 *  Store the answer till particular point and retrieve after sometime then stack will be a good choice over there
 *  
 */


public class Notes {
}
