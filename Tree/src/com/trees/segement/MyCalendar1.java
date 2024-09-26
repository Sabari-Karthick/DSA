package com.trees.segement;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * https://leetcode.com/problems/my-calendar-i/description
 * 
 * This problem can be optimized with segment tree
 * 
 * 
 */
public class MyCalendar1 {

}
class MyCalendar {

    List<List<Integer>> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(List<Integer> event : events){
          if(!(start >= event.get(1) ||  end <= event.get(0))){
           return false;
          }
        }
        events.add(List.of(start,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */