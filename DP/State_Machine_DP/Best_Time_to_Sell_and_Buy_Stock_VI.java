/*
188. Best Time to Buy and Sell Stock IV  QuestionEditorial Solution  My Submissions
Total Accepted: 29461
Total Submissions: 128411
Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Tags
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock III
*/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2)return 0;
        if(prices.length/2<k)return max(prices);
        // DP - state machine
        int[][] hold = new int[prices.length][k+1];//the last state + first State
        int[][] unhold = new int[prices.length][k+1];
        for(int j=0;j<=k;j++)hold[0][j]=-prices[0];
        for(int i=1;i<prices.length;i++) hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j]=Math.max(hold[i-1][j],unhold[i-1][j]-prices[i]);
                unhold[i][j]=Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
                //System.out.println(i+" "+j+" "+hold[i][j]+" "+unhold[i][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
    }
    public int max(int[] prices){
        int ans = 0;
        int min=prices[0]; int i=0;
        for(i=0;i<prices.length;i++){
            if(i>0 && prices[i]<prices[i-1]){
                ans+=prices[i-1]-min;
                min=prices[i];
            }
        }
        if(prices[i-1]>min)ans+=prices[i-1]-min;
        return ans;
    }
}


////////////////////

public class Solution {
public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2)return 0;
        if(prices.length/2<k)return max(prices);
        // DP - state machine
        int[][] hold = new int[prices.length][k+1];//the last state + first State
        int[][] unhold = new int[prices.length][k+1];
        for(int j=0;j<=k;j++)hold[0][j]=-prices[0];
        for(int i=1;i<prices.length;i++) hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j]=Math.max(hold[i-1][j],unhold[i-1][j]-prices[i]);
                unhold[i][j]=Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
                //System.out.println(i+" "+j+" "+hold[i][j]+" "+unhold[i][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
    }
    public int max(int[] prices){
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

/*

    Easy to understand explanation for the above solution

        dp[i][j] = maximum profit from at most i transactions using prices[0..j]

        A transaction is defined as one buy + sell.

        Now on day j, we have two options

        Do nothing (or buy) which doesn't change the acquired profit : dp[i][j] = dp[i][j-1]

        Sell the stock: In order to sell the stock, you must've bought it on a day t=[0..j-1]. Maximum profit that can be attained is t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) where prices[j]-prices[t] is the profit from buying on day t and selling on day j. dp[i-1][t-1] is the maximum profit that can be made with at most i-1 transactions with prices prices[0..t-1].

        Time complexity of this approach is O(n2k).

        In order to reduce it to O(nk), we must find t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) this expression in constant time. If you see carefully,

        t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) is same as

        prices[j] + t:0->j-1 max(dp[i-1][t-1]-prices[t])

        Second part of the above expression maxTemp = t:0->j-1 max(dp[i-1][t-1]-prices[t]) can be included in the dp loop by keeping track of the maximum value till j-1.

        Base case:

        dp[0][j] = 0; dp[i][0] = 0

        DP loop:

        for i : 1 -> k
        maxTemp = -prices[0];
        for j : 1 -> n-1
        dp[i][j] = max(dp[i][j-1], prices[j]+maxTemp);
        maxTemp = max(maxTemp, dp[i-1][j-1]-prices[j]);
        return dp[k][n-1];

        */