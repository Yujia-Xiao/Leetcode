/*
Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Hide Company Tags Airbnb Facebook
Hide Tags Dynamic Programming
Hide Similar Problems (H) Maximal Rectangle
*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int max=0;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0)dp[i][j]=matrix[i][j]-'0';
                else if(matrix[i][j]=='0')dp[i][j]=0;
                else dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                if(max<dp[i][j])max=dp[i][j];
            }
        }
        return max*max;
    }
}