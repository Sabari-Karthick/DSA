package com.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestNumberOfCandies {
public static void main(String[] args) {
	int  []candies = {2,3,5,1,3};
	int extraCandies = 3;
    System.out.println(kidsWithCandies(candies, extraCandies));
}
public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> list = new ArrayList<Boolean>();
    int max = Arrays.stream(candies).max().getAsInt();
    candies = Arrays.stream(candies).map(n->n+extraCandies).toArray();
    for(int candy : candies ){
        if(candy>=max){
            list.add(true);
        }else{
            list.add(false);
        }
    }
    return list;

}
}
//There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
//Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/