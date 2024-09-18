package com.InsertionSort;
//https://leetcode.com/problems/largest-number/
import java.util.Arrays;
import java.util.stream.Collectors;
//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//Since the result may be very large, so you need to return a string instead of an integer.
public class Largest_Number {
public static void main(String[] args) {
	int nums[]= {3,30,34,5,9};
	System.out.println(largestNumber(nums));
}
public static String largestNumber(int[] nums) {
    String ans[]=new String[nums.length];
    for(int i=0;i<nums.length;i++){
        ans[i]=String.valueOf(nums[i]);
    }
    Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
    Arrays.sort(ans,(s1,s2)->{//Array is object type so we can use comparator
        String n1=s1+s2,n2=s2+s1;
        //need to swap if n2 is greater
        return n2.compareTo(n1);
    });
    if(ans[0].equals("0")) return "0";
    StringBuilder sb = new StringBuilder();
    for(String i:ans){
        sb.append(i);
    }
    return sb.toString();
}
}
class Solution1234212 {
    public String largestNumber(int[] nums) {
        String ans[] =  Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(ans,(s1,s2)->{
           String n1 = s1+s2,n2 = s2+s1;
           return n2.compareTo(n1);
        });
        if(ans[0].equals("0")) return "0";

        return Arrays.stream(ans).collect(Collectors.joining());
    } 
}
