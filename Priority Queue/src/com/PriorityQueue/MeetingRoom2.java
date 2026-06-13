package com.PriorityQueue;

import java.util.List;
import java.util.PriorityQueue;


public class MeetingRoom2 {
    public static int minMeetingRooms(List <Interval> intervals) {

        // To get the correct start order
        intervals = new java.util.ArrayList<>(intervals); // to avoid modifying the original list
        intervals.sort((a, b) -> a.start - b.start);

        // Now to know whether I need a new room or not is depending on the current meeting end time
        // So at point of time I need to know the earliest meeting end time
        PriorityQueue<Integer> deadline = new PriorityQueue<>();


        for(Interval meeting : intervals){

            // If we add the deadline first we make ourself into a deadlock.
            // For example : { 8 , 10} and {10 , 12 } if we add deadline first we have {10,12} and we remove 10 later which  results in 1 room we can reusue the room

            if(!deadline.isEmpty() && meeting.start >= deadline.peek()){
                // Means we can resue the room with the earliest deadline
                deadline.poll(); // Remove the old deadline as we are reusing the room so we need to update the deadline with the new meeting end time
            }

            deadline.offer(meeting.end); // We need to add the new deadline as we are using the room for the new meeting

        }

        return  deadline.size(); // The size of the deadline is the number of rooms we need as it tells us how many meetings are going on at the same time

    }

    static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(List.of(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)))); // 2
    }

}