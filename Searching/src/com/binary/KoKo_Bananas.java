package com.binary;

import java.util.Arrays;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours.

//Input: piles = [3,6,7,11], h = 8
//Output: 4

//Time : O(n⋅log(maxPile))
public class KoKo_Bananas {
	public static void main(String[] args) {

	}
}

class Solutionksdfj90 {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        while(start < end){
            int mid = start + (end - start)/2;
            if(canEat(piles,mid,h)){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }

    public boolean canEat(int[]piles,int k,int h){
        int time = 0;
        for(int i : piles){
           time+=(int) Math.ceil(i * 1.0/k);// multiply convert that to double so that we can get the decimal
        }
        if(time > h){
            return false;
        }else{
            return true;
        }
    }
}
