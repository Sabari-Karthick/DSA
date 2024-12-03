package com.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/adding-spaces-to-a-string
 * 
 * 
 */
public class AddSpaceBetweenString {

}

class Solution24342 {
    public String addSpaces(String s, int[] spaces) { //Better 
        StringBuilder result = new StringBuilder();
        int ptr = 0;
        for (int i = 0 ;i<spaces.length ; i++){
        	result.append(s, ptr, spaces[i]);
        	result.append(" ");
            ptr=spaces[i];
        }
        result.append(s.substring(ptr));
        return result.toString();
    }
}

class Solutionsadfasdf {
    public String addSpaces(String s, int[] spaces) { //Two Pointer
        int i = 0 , j = 0;
        List<String> res = new ArrayList<>();
        while(i < s.length() && j< spaces.length){
             if(i < spaces[j]){
                res.add(String.valueOf(s.charAt(i)));
                i++;
             }else{
                res.add(" ");
                j++;
             }
        }
        if(i < s.length()){
            res.add(s.substring(i));
        }

        return String.join("",res);
    }
}