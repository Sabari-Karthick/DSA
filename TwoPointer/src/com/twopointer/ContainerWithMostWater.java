package com.twopointer;
//The small height is our bottle neck so shift
//https://leetcode.com/problems/container-with-most-water/submissions/1372502633/
public class ContainerWithMostWater {

}

class Solutiondfsd7sdgs {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max =0;
        while (start <= end){
           max = Math.max(max,Math.min(height[start],height[end]) * (end - start));
           if(height[start] < height[end]){
            start ++;
           }else{
            end --;
           }
        }
        return max;
    }
}