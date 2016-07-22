/*
45. Jump Game II  QuestionEditorial Solution  My Submissions
Total Accepted: 68595
Total Submissions: 268238
Difficulty: Hard
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Hide Tags Array Greedy
*/
public class Solution {
    public int jump(int[] A) {
        int count = 0, max = 0;
        for (int i = 0, nextMax = 0; i <= max && i < A.length - 1; i++) {
            nextMax = Math.max(nextMax, i + A[i]);
            if (i == max) {
                max = nextMax;
                count++;
            }
        }
        // if there is no way to get to the end, return -1
        return max >= A.length - 1 ? count : -1;
    } 
}