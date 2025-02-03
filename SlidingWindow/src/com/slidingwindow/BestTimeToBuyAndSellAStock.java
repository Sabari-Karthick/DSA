package com.slidingwindow;
/**
 * 
 * 
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * To sell a stock on the ith day I'll choose a day which is minimum in the from 1 to (i-1)
 * This problem can be done in a psedo DP way of remembering the minimum 
 * 
 * 
 * The Sliding Window tries to find the perfect low starting price and selling price to max Profit
 * 
 */
public class BestTimeToBuyAndSellAStock {

}

class Solution123gfsdg {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int profit = 0;
        while(r < prices.length){
            if(prices[l]>prices[r]){// a new low price is found
                l = r; // always ensure the left is at the low price
            }else{
                int currentProfit = prices[r] - prices[l];
                profit = Math.max(profit,currentProfit);
            }
                r++;// at any cost we need to update the right
        }
        return profit;
    }
}

class Solution23r {
    public int maxProfit(int[] prices) {
        int min = prices[0],profit = 0;
        for(int i=1;i< prices.length ; i++){
            int pro = prices[i] - min; // Find the profit by using the min
            profit = Math.max(pro,profit);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }
}
