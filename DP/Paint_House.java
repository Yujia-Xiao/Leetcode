/*
Paint House My Submissions Question
Total Accepted: 3968 Total Submissions: 9697 Difficulty: Medium
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Hide Company Tags LinkedIn
Hide Tags Dynamic Programming
Hide Similar Problems (E) House Robber (M) House Robber II (H) Paint House II (E) Paint Fence
*/
public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)return 0;
        int[] r = new int[costs.length+1];
        int[] b = new int[costs.length+1];
        int[] g = new int[costs.length+1];
        r[0]=0; b[0]=0; g[0]=0;
        for(int i=1;i<costs.length+1;i++){
            r[i]=Math.min(b[i-1],g[i-1])+costs[i-1][0];
            b[i]=Math.min(r[i-1],g[i-1])+costs[i-1][1];
            g[i]=Math.min(r[i-1],b[i-1])+costs[i-1][2];
        }
        return Math.min(Math.min(r[costs.length],b[costs.length]),g[costs.length]);
    }
}