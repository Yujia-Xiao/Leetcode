/*
House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

Hide Company Tags LinkedIn Airbnb
Hide Tags Dynamic Programming
Hide Similar Problems (M) Maximum Product Subarray (M) House Robber II (M) Paint House (E) Paint Fence
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int[] b = new int[nums.length+1];
        int[] n = new int[nums.length+1];
        b[0]=0;n[0]=0;//b[1]=nums[0];n[1]=0;
        for(int i=1;i<nums.length+1;i++){
            b[i]=n[i-1]+nums[i-1];
            n[i]=Math.max(n[i-1],b[i-1]);
        }
        return Math.max(b[nums.length],n[nums.length]);
    }
}