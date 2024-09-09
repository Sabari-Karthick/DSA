package com.twopointer;
/**
 * 
 * 
 * 
 * The main equation is Min(H[L],H[R]) - H[i] is the trapping water unit
 * Trapped Water=Height of Shorter Boundary − Height of the Bar
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class TrappingRainWater {

}
class Solution124sgasf {
    public int trap(int[] height) {
        if (height.length==0) return 0;
        int l=0;
        int r=height.length-1;
        int maxL = height[l];
        int maxR = height[r];
        int res = 0;
        while(l < r){
          if(maxL < maxR){ //The lower boundary (maxL in this case) determines the amount of water that can be trapped at each step when maxL < maxR.
            l++; //lower boundry determines the amount of water can be trapped.
            maxL  = Math.max(maxL,height[l]); // ensure the max value we have encountered till now
            res += maxL - height[l];//we moved the pointer only because the boundry is short and that short boundry is the determining factor so we do not need other boundry
          }else{
            r--;
            maxR = Math.max(maxR,height[r]);
            res += maxR - height[r];
          }
        }
        return res;
    }
}