/*
3Sum 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
Hide Company Tags Bloomberg Facebook
Hide Tags Array Two Pointers
Hide Similar Problems (M) Two Sum (M) 3Sum Closest (M) 4Sum (M) 3Sum Smaller
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums.length<3)return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0)break;
            if(i>0 && nums[i]==nums[i-1])continue;//skip duplicates
            int target=-nums[i];
            int start=i+1; int end=nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]==target){
                    ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while(start<end && nums[start]==nums[start+1])start++;
                    while(start<end && nums[end]==nums[end-1])end--;
                    start++;end--;
                }
                else if(nums[start]+nums[end]>target)end--;
                else start++;
            }
        }
        return ans;
    }
}