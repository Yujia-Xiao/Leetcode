/*
Single Number II 
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Hide Tags Bit Manipulation
Hide Similar Problems (M) Single Number (M) Single Number III
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0; int two = 0; int three = 0;
        for(int i = 0; i < nums.length; i++){
            two |= one & nums[i];
            one ^= nums[i]; 
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}


// logic gate design
class Solution {
    public int singleNumber(int[] nums) {
        /*
        
        */
        int ones = 0;
        int twos = 0;
        for(int i=0;i<nums.length;i++){
            ones = (ones^nums[i]) & (~twos);
            twos = (twos^nums[i]) & (~ones);
        }
        return ones;
    }
}