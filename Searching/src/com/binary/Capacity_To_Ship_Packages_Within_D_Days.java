package com.binary;

import java.util.Arrays;

public class Capacity_To_Ship_Packages_Within_D_Days {
public static void main(String[] args) {
	int []weights = {1,2,3,1,1};
    int ans = shipWithinDays(weights,4);
    System.out.println(ans);
	 
}

private static int shipWithinDays(int[] weights, int days) {
	 int start = Arrays.stream(weights).max().getAsInt();
     int end = Arrays.stream(weights).sum();
     while(start < end){
         int w = 0;
         int day = 1;
         int mid = start +(end - start)/2;
         for(int i : weights){
            if(w+i<=mid){
                w+=i;
            }else{
                w = i;
                day++;
            }
         }
         if(day<=days){
            end = mid;
         }else{
             start = mid+1;
         }
     }
     return start;
}
}
