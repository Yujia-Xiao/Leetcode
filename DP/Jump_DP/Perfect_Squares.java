/*
Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming Breadth-first Search Math
Hide Similar Problems (E) Count Primes (M) Ugly Number II
*/
public class Solution {
    public int numSquares(int n) {
        //DP
        int dp[] = new int[n + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];       
    }
}

//07/18/2018
class Solution {
    public int numSquares(int n) {
        if(n==0)return 1;
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++)dp[i]=i;
        
        for(int i=1; i*i<=n; i++) dp[i*i]=1;
        for(int i=1; i<=n;i++){
            for(int j=1;i+j*j <=n ; j++){
                dp[i+j*j]= Math.min(dp[i+j*j],dp[i]+1);
            }
        }
        
        return dp[n];
    }
}