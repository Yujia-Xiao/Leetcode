/*
Missing Number 
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Bloomberg
Hide Tags Array Math Bit Manipulation
Hide Similar Problems (H) First Missing Positive (M) Single Number (H) Find the Duplicate Number
*/
public class Solution {
    public int missingNumber(int[] nums) {
        int a = 0; int b = 0;
        if(nums.length==0 || nums==null)return 0;
        for(int i=1;i<=nums.length;i++){
            a^=i;
        }
        for(int i=0;i<nums.length;i++){
            b^=nums[i];
        }
        return a^b;
    }
}