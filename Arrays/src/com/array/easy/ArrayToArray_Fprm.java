package com.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayToArray_Fprm {
public static void main(String[] args) {
	System.out.println(addToArrayForm(new int[] {9,9,9,9,9}, 1));
}
public static List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> ans = new ArrayList<>();
    num[num.length-1]+=k;
    ans.add(num[num.length-1]%10);
    int carry = num[num.length-1]/10;
    for(int i = num.length-2;i>=0;i--){
       num[i]+=carry;
       carry = num[i]/10;
       ans.add(num[i]%10);
    }  
    while(carry!=0){
        ans.add(carry%10);
        carry/=10;
    }
    Collections.reverse(ans);
    return  ans;
}
}
//The array-form of an integer num is an array representing its digits in left to right order.

//For example, for num = 1321, the array form is [1,3,2,1].
//Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
//https://leetcode.com/problems/add-to-array-form-of-integer/description/