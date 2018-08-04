/*
Single Number 
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Hide Tags Hash Table Bit Manipulation
Hide Similar Problems (M) Single Number II (M) Single Number III (M) Missing Number (H) Find the Duplicate Number
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}



//
class Solution {
    public int singleNumber(int[] nums) {
        /* only one num appear one time --> bit manipulation
         i: 0- len-1,  ans = ans ^ num[i]   :    5. ----> 000 ^ 101 == 101, and 5 again 101 ^ 101 == 000
         exclusive or is used for toggle the bit. bits toggle even number is 0, and only the single num will remain
        */ 
        int ans = 0;
        for(int i =0; i< nums.length; i++){
            ans= ans^nums[i];
        }
        return ans;
    }
}