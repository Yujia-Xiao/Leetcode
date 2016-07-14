/*
213. House Robber II  QuestionEditorial Solution  My Submissions
Total Accepted: 32734
Total Submissions: 103913
Difficulty: Medium
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Hide Company Tags Microsoft
Hide Tags Dynamic Programming
Hide Similar Problems (E) House Robber (M) Paint House (E) Paint Fence (M) House Robber III
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
    }
    
    public int helper(int[] nums, int s, int e){
        int[] b = new int[e-s+2];
        int[] n = new int[e-s+2];
        b[0]=0;
        n[0]=0;
        for(int i=1;i<=e-s+1;i++){
            b[i]=n[i-1]+nums[s+i-1];
            n[i]=Math.max(b[i-1],n[i-1]);
        }
        return Math.max(b[e-s+1],n[e-s+1]);
    }
}