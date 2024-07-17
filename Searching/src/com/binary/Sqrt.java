package com.binary;

public class Sqrt {

}

//https://leetcode.com/problems/sqrtx/description/
class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        int start = 1;
        int end = x/2;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((long)mid * mid > x){
                end = mid-1;
            }else {
                start = mid +1;
            }
        }
        return end;
    }
}