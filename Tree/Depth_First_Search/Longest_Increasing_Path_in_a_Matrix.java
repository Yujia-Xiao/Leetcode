/*
329. Longest Increasing Path in a Matrix   QuestionEditorial Solution  My Submissions
Total Accepted: 23582
Total Submissions: 68803
Difficulty: Hard
Contributors: Admin
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Depth-first Search Topological Sort Memoization
*/
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];//dp ---> catch
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans = Math.max(ans,dfs(matrix,dp,i,j));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix,int[][] dp,int x, int y){
        if(dp[x][y]!=0)return dp[x][y];//memorization
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int max = 1;
        for(int i=0;i<dirs.length;i++){
            int newI = x+dirs[i][0];
            int newJ = y+dirs[i][1];
            if(newI<0 || newI>=matrix.length || newJ<0 || newJ>=matrix[0].length || matrix[x][y]<=matrix[newI][newJ])continue;
            max=Math.max(max,1+dfs(matrix,dp,newI,newJ));
            dp[x][y]=max;
        }
        return max;
    }
    
}