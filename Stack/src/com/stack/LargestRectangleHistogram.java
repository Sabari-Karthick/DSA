package com.stack;

public class LargestRectangleHistogram {
	

}
//When we need some answer in sequence till some point use stack
//we need maximum till some point from an index then we can use stack
//we take max till a particular index so stack is used  
//we need to find a items that needs to be strictly increasing
//the main idea is to find the next smallest in the left and in the right
//stack helps to find the next smallest in the item in the left\


//class Solution {
//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        int max = 0;
//        for(int i=1;i<heights.length;i++){
//            //condition to calculate the max
//            while(!stack.isEmpty()  && heights[i]< heights[stack.peek()])//the top is supposed to be small if it is larger than the i calculate the max
//            {
//                max = getMax(heights,stack,max,i);
//            }
//            stack.push(i);
//        }
//        int i = heights.length;//for the last value since i iterates till less than the last index 
//        while(!stack.isEmpty()){
//            max = getMax(heights,stack,max,i);
//        }
//
//        return max;
//    }
//
//    private static int getMax(int []heights,Stack<Integer> stack,int max , int index){
//               int area;
//               int popped  = stack.pop();
//               if(stack.isEmpty()){//the left part is all smaller so we can take the  full array till i
//                  area =  heights[popped]*index;
//               }else{
//                   area = heights[popped] * (index-1-stack.peek());
//               }
//
//
//
//               return Math.max(area,max);
//    }
//}