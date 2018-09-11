/*
Maximum Subarray 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

Hide Company Tags LinkedIn
Hide Tags Divide and Conquer Array Dynamic Programming
Hide Similar Problems (M) Best Time to Buy and Sell Stock (M) Maximum Product Subarray
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int[] sum = new int[nums.length];
        int min=0; sum[0]=nums[0];int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
            if(min>sum[i-1])min=sum[i-1];
            if(sum[i]-min>ans)ans=sum[i]-min;
        }
        return ans;
    }
}