/*
Paint Fence
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Hide Company Tags Google
Hide Tags Dynamic Programming
Hide Similar Problems (E) House Robber (M) House Robber II (M) Paint House (H) Paint House II
*/
public class Solution {
    public int numWays(int n, int k) {
        //DP
        //different color to i-1 d[i]=(k-1)*(s[i-1]+d[i-1])
        //same s[i]=1*d[i-1]
        if(n<=0 || k<=0){return 0;}
        int[] s = new int[n];
        int[] d = new int[n];
        s[0]=0;
        d[0]=k;
        for(int i=1;i<n;i++){
            s[i]=d[i-1];
            d[i]=(k-1)*(s[i-1]+d[i-1]);
        }
        int ans = s[n-1]+d[n-1];
        return ans;       
    }
}