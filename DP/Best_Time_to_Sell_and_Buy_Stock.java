/*
Best Time to Buy and Sell Stock 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Hide Company Tags Uber Facebook
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown
*/
public class Solution {
    public int maxProfit(int[] prices) {
        /* if(prices==null || prices.length==0)return 0;
        int minPrice = prices[0];
        int[] dp = new int[prices.length];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],prices[i]-minPrice);
            minPrice=(prices[i]<minPrice)?prices[i]:minPrice;
        }
        return dp[prices.length-1];*/        
        if(prices==null || prices.length==0)return 0;
        int minPrice = prices[0];
        int P = 0;
        for(int i=1;i<prices.length;i++){
            P=Math.max(P,prices[i]-minPrice);
            minPrice=(prices[i]<minPrice)?prices[i]:minPrice;
        }
        return P;
    }
}