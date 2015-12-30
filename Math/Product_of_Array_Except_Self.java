/*
Product of Array Except Self 
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Hide Company Tags LinkedIn Facebook
Hide Tags Array
Hide Similar Problems (H) Trapping Rain Water (M) Maximum Product Subarray (H) Paint House II
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left=1;int right=1;
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=left;
            left*=nums[i];
        }
        for(int i=ans.length-1;i>=0;i--){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;
    }
}