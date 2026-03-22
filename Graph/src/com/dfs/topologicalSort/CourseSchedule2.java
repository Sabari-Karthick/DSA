package com.dfs.topologicalSort;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution02N35.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))); //[0,2,1,3]
    }
}

class Solution02N35 {

    static int index = 0; // We need to know which index we put the course as we need a valid plan
    // We cant keep it inside dfs and keeping it in main will hide it between courses

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] plan = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        Set<Integer> tracker = new HashSet<>();

        // Why we remove the rule is because rule says whether the course is valid at the start and we wont get chance to update the plan
        Set<Integer> visited = new HashSet<>(); // Since we need to know whether this course is allready green, as we now not rely on the rules

        for (int c = 0; c < numCourses; c++) { // With this we can avoid the is there any rule check rule we had in CS-i
            map.put(c,new ArrayList<>());
        }


        for (int[] i : prerequisites) {
            map.get(i[0]).add(i[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(map, tracker, visited, c, plan)) {
                return new int[] {};
            }
        }

        return plan;

    }

    static boolean  dfs(Map<Integer, List<Integer>> map, Set<Integer> tracker,Set<Integer> visited, int course, int[] plan) {

        if(visited.contains(course)) return true; // If it is a already green course

        if (tracker.contains(course))
            return false;

        tracker.add(course);

        for (int preq : map.get(course)) {
            if (!dfs(map, tracker,visited, preq, plan)){
                return false;
            }
        }

        plan[index++] = course; // At this point we know the course is valid so we add it to the plan


        visited.add(course); // as well as the tracker
        tracker.remove(course);

        // We dont need to remove or mark the rule as empty as we had a new tracker


        return true;

    }
}