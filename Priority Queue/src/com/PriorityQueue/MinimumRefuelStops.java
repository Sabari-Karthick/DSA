package com.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Collections;

public class MinimumRefuelStops {
    public  static  int minRefuelStops(int target, int startFuel, int[][] stations) {

        // There are two ways to approach this.
        // The pattern is straight forward anyway , be greedy always believe that the next station will be better than the current one.
        // But again if not we need to undo the last decision means we need a bag to keep all the stations we have passed and at any moment we need to station with the maximum fuel to undo the last decision.

        // So there are two actions , Either skip and put in the bag and refuel.

        // One way lets say at every station we can see can i reach the next station or not if yes then skip and put in the bag else refuel from the bag and then check again.
        // But it have some more math and may cause some confusion so lets do the other way.

        // So the other way is approach the stations as target with the current fuel how many stations can I reach.
        // This allows as to just keep one tracker and say maxReach < station then we need to refuel from the bag and then check again.
        // If else means we can keep continuing and add the station to the bag.
        // So basically we let the truck make dry and then we refuel from the bag and keep going.

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap to keep the stations we have passed and at any moment we need to station with the maximum fuel to undo the last decision.

        int stops = 0;
        int maxReach = startFuel; // The max distance we can reach with the current fuel This is the tracker we keep to see if we can reach the next station or not.

        for (int[] station : stations) {
            int pos = station[0];
            int fuel = station[1];

            // The Dry truck scenario
            while (maxReach < pos) {
                // We cant reach the next station so we need to refuel from the bag
                // But if the bag is empty then we cant reach the target so return -1
                if (maxHeap.isEmpty()) return -1;

                // Else we can refuel from the bag and keep going
                maxReach += maxHeap.poll(); // Refuel from the station with the maximum fuel
                stops++; // We have made a stop to refuel

            }

            // Having enough fuel scenario
            maxHeap.offer(fuel); // Add the current station to the bag for future use

        }

        // There is one more scenario where we have reached the last station and we still have not reached the target so we need to refuel from the bag and keep going.
        // Like you arrived at the last station with 0 fuel and the target is still far away so we need to refuel from the bag and keep going.
        // Because in the first loop we only check for the stations and not the target so we need to check for the target as well.
        while (maxReach < target) {
            // If the bag is empty then we cant reach the target so return -1
            if (maxHeap.isEmpty()) return -1;

            // Else we can refuel from the bag and keep going
            maxReach += maxHeap.poll(); // Refuel from the station with the maximum fuel
            stops++; // We have made a stop to refuel

        }

        return stops;

    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}})); // 2
        System.out.println(minRefuelStops(100, 1, new int[][]{{10, 100}})); // -1
        System.out.println(minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 25}, {75, 25}})); // 2
        System.out.println(minRefuelStops(100, 100, new int[][]{})); // 0
    }


}