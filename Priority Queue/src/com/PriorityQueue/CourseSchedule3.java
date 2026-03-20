package com.PriorityQueue;


// Every Item is same point
// But the time to get that them is differnt
// I need to maximize the points

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/course-schedule-iii

// This pattern says it is greedy + priorityQueue
public class CourseSchedule3 {
    public static void main(String[] args) {
        System.out.println(Solution1m0234.scheduleCourse(new int[][]{
            {100,200},{200,1300},{1000,1250},{2000,3200}})); // 3
    }
}


class Solution1m0234 {
    public static int scheduleCourse(int[][] courses) {

        // I need to pick the ones with the smaller deadlines so
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);

        // Now I have the courses with near deadlines at first

        // To Track durations
        int days = 0;

        // But when we reach a course and we see we already cross the days we should be able to swap the course if we already did a larger course
        // So at any moment we need to know which is the largest course done and since we already sorted on deadline we can simply swap to save days

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] course : courses){
            maxHeap.add(course[0]);

            days += course[0]; // Efforts

            if(days > course[1]){
                // Means we are out of the deadline so we need to remove the someone
                Integer largeCourse = maxHeap.poll();
                days -= largeCourse;
            }

        }

        return maxHeap.size(); // These are the pursued Course


    }
}