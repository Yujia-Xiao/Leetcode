/*
Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
Hide Tags Dynamic Programming
Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable
*/
public class NumArray {
    
    private int[] dp = null;
    public NumArray(int[] nums) {
        dp = nums;
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]+dp[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i<=j && i<dp.length && j<dp.length){
            if(i>0)return dp[j]-dp[i-1];
            else return dp[j];
        }
        return 0;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);