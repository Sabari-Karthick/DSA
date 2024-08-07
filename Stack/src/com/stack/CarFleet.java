package com.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/car-fleet/description/
public class CarFleet {

}
class Solutiosfsn {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1)
              return 1;


        int combine[][] = new int[position.length][2];
        Stack<Double> stack = new Stack<>();

        for(int i = 0;i< position.length ; i++){
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine,java.util.Comparator.comparingInt(a -> a[0]));
        for(int i = combine.length -1 ;i>=0;i--){
            double time = (double)(target - combine[i][0])/combine[i][1];

            if(!stack.isEmpty() && time <= stack.peek()){
                continue;
            }else{
                stack.push(time);
            }
        }

       return stack.size();
    }
}