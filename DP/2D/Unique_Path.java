/*
Unique Paths 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Unique Paths II (M) Minimum Path Sum (H) Dungeon Game
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<0 || n<0)return 0;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!(i==0 && j==0)){
                    if(i-1>=0 && i-1<=n)dp[j][i]+=dp[j][i-1];
                    if(j-1>=0 && j-1<=m)dp[j][i]+=dp[j-1][i];
                }
            }
        }
        return dp[m-1][n-1];
    }
}