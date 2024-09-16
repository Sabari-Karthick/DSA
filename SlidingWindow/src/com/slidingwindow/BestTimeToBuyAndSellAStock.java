package com.slidingwindow;
/**
 * 
 * 
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
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
