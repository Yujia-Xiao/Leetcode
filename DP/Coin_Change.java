/*
322. Coin Change  QuestionEditorial Solution  My Submissions
Total Accepted: 28246
Total Submissions: 111576
Difficulty: Medium
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Dynamic Programming
*/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if(amount<0)return -1;
        if(amount==0)return 0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i<coins[j])continue;
                if(i==coins[j])dp[i]=1;
                if(dp[i-coins[j]]>0)dp[i]=(dp[i]==0)?dp[i-coins[j]]+1:Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        return (dp[amount]==0)?-1:dp[amount];
    }
}
