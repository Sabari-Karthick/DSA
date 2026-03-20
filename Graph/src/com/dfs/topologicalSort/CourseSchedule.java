package com.dfs.topologicalSort;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(Solutionkp234.canFinish(2,new int[][]{{1,0},{0,1}}));
    }

}

class Solutionkp234 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // If brute force means we need to parse the whole array again to check the rules

        // To avoid that lets build a map so that when we see a course we can get the rules for it
        Map<Integer, List<Integer>> map = new HashMap<>();


        for (int[] i : prerequisites)
            map.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);

        // We need to keep the track of the pursing course to identify whether we lock into a deadlock or not
        Set<Integer> visited = new HashSet<>();

        // Now we need to evaluate each and every course
        for (int course = 0; course < numCourses; course++) // We cannpot simply start from course 0 as we may not have direct need with other course so see every course
            if (!dfs(map, visited, course)) return false;

        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int course) {
        // For recursion the breaker is always the at last step and a certainty
        // If we have no rules or empty rules we can say that course can be finished
        if (map.get(course) == null || map.get(course).isEmpty()) return true;

        // If we are already pursing a course and we asked to pursue the same course again we are in a deadlock
        if (visited.contains(course)) return false;

        // Now we evaluated our last steps Means we can now process the fresh course
        // Mark it as pursing
        visited.add(course);

        for (int preR : map.get(course)) {
            if (!dfs(map, visited, preR)) return false; // Means we cant pursue the pre-requesite
        }

        // Now we can say we are confident in finshing this course
        visited.remove(course);

        // And to avoid future computing
        map.put(course, new ArrayList<>()); // Or make it null

        return true;

    }
}