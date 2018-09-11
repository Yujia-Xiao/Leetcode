/*
Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Tags Tree Dynamic Programming
Hide Similar Problems (M) Unique Binary Search Trees II
*/
public class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n][n];
        for(int i=0;i<dp.length;i++)dp[i][i]=1;
        for(int step=1;step<n;step++){
            for(int start=0;start<n-step;start++){
                for(int root=start;root<=start+step;root++){
                    int l = 1; int r = 1;
                    if(root-1>=start)l=dp[start][root-1];
                    if(root+1<=start+step)r=dp[root+1][start+step];
                    dp[start][start+step]+=l*r;
                }
            }
        }
        return dp[0][n-1];
    }
}