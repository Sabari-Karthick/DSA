package com.trees.segement;

import java.util.ArrayList;
import java.util.List;
/**\
 * 
 * https://leetcode.com/problems/my-calendar-ii
 * this can be optimized using a tree
 * 
 * 
 * 
 * 
 */
public class MyCalendar2 {

}
class MyCalendarTwo {
    List<List<Integer>> overlappingIntervals;
    List<List<Integer>> nonoverlappingIntervals;

    public MyCalendarTwo() {
        overlappingIntervals = new ArrayList<>();
        nonoverlappingIntervals = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(List<Integer> events : overlappingIntervals){
             if(start < events.get(1) && end > events.get(0)){
                return false;
             }
        }
         for(List<Integer> events : nonoverlappingIntervals){
             if(start < events.get(1) && end > events.get(0)){
                int overLappingStart = Math.max(start,events.get(0));
                int overLappingEnd = Math.min(end,events.get(1));
                overlappingIntervals.add(List.of(overLappingStart,overLappingEnd));
             }
        }
         nonoverlappingIntervals.add(List.of(start,end));
         return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */