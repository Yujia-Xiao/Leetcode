/*
376. Wiggle Subsequence  QuestionEditorial Solution  My Submissions
Total Accepted: 989
Total Submissions: 2439
Difficulty: Medium
A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

Credits:
Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.

Hide Tags Dynamic Programming Greedy
Have you met this question in a real interview? */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int positive = 0;
        int num=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>0 && (positive==-1 || positive==0)){
                positive=1;
                num++;
            }else if(nums[i]-nums[i-1]<0 && (positive==1 || positive==0)){
                positive=-1;
                num++;
            }
        }
        return num;
    }
}