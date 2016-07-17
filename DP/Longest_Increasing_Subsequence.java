/*
300. Longest Increasing Subsequence  QuestionEditorial Solution  My Submissions
Total Accepted: 35989
Total Submissions: 101814
Difficulty: Medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

Hide Company Tags Microsoft
Hide Tags Dynamic Programming Binary Search
Show Similar Problems
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len=0;
        for(int i=0;i<nums.length;i++){
            int target = nums[i];
            int s=0; int e=len-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(target==dp[mid]){s=mid;break;}
                else if(target<dp[mid])e=mid-1;
                else s=mid+1;
            }
            //System.out.println(i+" s: "+s+" len: "+len);
            dp[s]=target;
            if(s==len){
                len++;}
        }
        return len;
    }
}