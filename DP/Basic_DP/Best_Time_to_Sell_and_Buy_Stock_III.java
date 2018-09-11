/*
Best Time to Buy and Sell Stock III My Submissions Question
Total Accepted: 47664 Total Submissions: 189869 Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock IV
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        return  maxProfit;
    }
}