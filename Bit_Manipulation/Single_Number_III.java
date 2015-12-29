/*
Single Number III 
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Hide Similar Problems (M) Single Number (M) Single Number II
*/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] a=new int[2];
        int t1=0,t2=0,n=nums.length,t=0,s=1;
        for(int i=0;i<n;i++)t^=nums[i];
        while((t&s)==0){
            s=s<<1;
        }
        for(int i=0;i<n;i++){
            if((nums[i]&s)==0)t1^=nums[i];
            else if((nums[i]&s)!=0)t2^=nums[i];
        }
        a[0]=t1;
        a[1]=t2;
        return a;    
    }
}