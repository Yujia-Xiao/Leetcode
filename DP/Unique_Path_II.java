/*
Unique Paths II 
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Unique Paths
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; int n = obstacleGrid[0].length;
        if(m<=0 || n<=0)return 0;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==0)dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[j][i]==1)dp[j][i]=0;
                else{
                    if(!(i==0 && j==0)){
                        if(i-1>=0 && i-1<n && obstacleGrid[j][i-1]==0)dp[j][i]+=dp[j][i-1];
                        if(j-1>=0 && j-1<m && obstacleGrid[j-1][i]==0)dp[j][i]+=dp[j-1][i];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}