/*
55. Jump Game  QuestionEditorial Solution  My Submissions
Total Accepted: 85328
Total Submissions: 297281
Difficulty: Medium
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Hide Company Tags Microsoft
Hide Tags Array Greedy
*/
public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(i>reachable)return false;
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }
}