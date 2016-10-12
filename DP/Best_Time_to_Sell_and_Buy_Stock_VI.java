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