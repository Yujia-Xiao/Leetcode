/*
Burst Balloons
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:
Given [3, 1, 5, 8]
Return 167
    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
Credits:
Special thanks to @peisi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Divide and Conquer Dynamic Programming
Have you met this 
*/
public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int[][] dp = new int[nums.length][nums.length];
    for (int len = 1; len <= nums.length; len++) {
        for (int start = 0; start <= nums.length - len; start++) {
            int end = start + len - 1;
            for (int i = start; i <= end; i++) {
                int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                dp[start][end] = Math.max(dp[start][end], coins);
            }
        }
    }
    return dp[0][nums.length - 1];
}

private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
    if (i < 0 || i >= nums.length) {
        return 1;
    }
    return nums[i];
}

//7/20/2018
class Solution {
    public int maxCoins(int[] nums) {
        //
        if(nums==null || nums.length==0)return 0;
        int size = nums.length;
        int[][] dp = new int[size][size];
        
        for(int len=1;len<=size;len++){
            
            for(int i=0;i<size-len+1;i++){
                int j = i + len - 1;
                int max = 0;
                int cul = 0;
                int l = (i==0)? 1 : nums[i-1];
                int r = (j==size-1) ? 1 :nums[j+1];
                
                for(int k = i; k<=j;k++){
                    cul+=l*r*nums[k];
                    
                    if(len!=1){
                        if(k==i)cul+=dp[i+1][j];
                        else if(k==j)cul+=dp[i][j-1]; 
                        else cul+= dp[i][k-1]+dp[k+1][j];
                        }
                    
                    if(cul>max)max=cul;
                    cul=0;
                }
                
                dp[i][j]=max;
                max=0;
            }
        }
        return dp[0][size-1];
    }
}