/*
377. Combination Sum IV  QuestionEditorial Solution  My Submissions
Total Accepted: 14682 Total Submissions: 36248 Difficulty: Medium
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

Hide Company Tags Google Snapchat Facebook
Hide Tags Dynamic Programming
Hide Similar Problems (M) Combination Sum
*/
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num>i)break;
                if(num==i)dp[i]++;
                else dp[i]+=dp[i-num];
            }
        }
        return dp[target];
    }
}