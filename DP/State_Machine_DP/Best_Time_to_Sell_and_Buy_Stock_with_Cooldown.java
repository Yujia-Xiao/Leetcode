/*
309. Best Time to Buy and Sell Stock with Cooldown  QuestionEditorial Solution  My Submissions
Total Accepted: 19707
Total Submissions: 52173
Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if(size<2)return 0;
        int[] s0 = new int[size];
        int[] s1 = new int[size];
        int[] s2 = new int[size];
        s0[0]=0;s1[0]=-prices[0];s2[0]=Integer.MIN_VALUE;
        for(int i=1;i<size;i++){
            s0[i]=Math.max(s0[i-1],s2[i-1]);
            s1[i]=Math.max(s1[i-1],s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
        }
        return Math.max(s0[size-1],s2[size-1]);
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)return 0;
        int len = prices.length;
        
        int[] state0 = new int[len];
        int[] state1 = new int[len];
        int[] state2 = new int[len];
        
        state0[0] = 0;
        state1[0] = -prices[0];
        state2[0] = Integer.MIN_VALUE; // invalid situation
        
        for(int i = 1; i < len ; i++){
            state0[i] = Math.max(state0[i-1], state2[i-1]);
            state1[i] = Math.max(state0[i-1] - prices[i], state1[i-1]);
            state2[i] = state1[i-1] + prices[i];
        }
        
        return Math.max(state0[len-1],state2[len-1]);
    }
}

/*
    state0: rest(self-loop) or buy
    state 1: rest(self-loop) or sell
    state2: cooldown 


*/