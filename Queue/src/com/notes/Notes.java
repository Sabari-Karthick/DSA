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
 *  Dequeue:
 *     We can insert and remove from both the sides
 *                       -> a doubly ended list
 *     Implementation class is arraydeque       -> size is dynamic        
 *                 Null insertion is not allowed
 *     It helps good in trees      
 *  
 */
public class Notes {

}
