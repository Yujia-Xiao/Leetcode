/*
Best Time to Buy and Sell Stock II
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Greedy
Hide Similar Problems (M) Best Time to Buy and Sell Stock (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;  
        }  
        int totalProfit = 0;  
        int startIndex = 0;  
        int i;  
          
        for(i=1; i<prices.length; i++){  
            if(prices[i] < prices[i-1]){ 
                totalProfit += prices[i-1] - prices[startIndex];  
                startIndex = i;    
            }  
        }  
        if(prices[i-1] > prices[startIndex]){  
            totalProfit += prices[i-1] - prices[startIndex];  
        }  
        return totalProfit;  
    } 
}

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;  
        int totalProfit = 0;
        for(int i=1; i<prices.length; i++){  
            if(prices[i] > prices[i-1]){ 
                totalProfit += prices[i] - prices[i-1];  
            }  
        }  
  
        return totalProfit;
    }
}