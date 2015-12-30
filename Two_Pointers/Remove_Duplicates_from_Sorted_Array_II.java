/*
Remove Duplicates from Sorted Array II My Submissions Question
Total Accepted: 61383 Total Submissions: 194750 Difficulty: Medium
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Hide Company Tags Facebook
Hide Tags Array Two Pointers
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length; int position=2; int pick=2;
        if(n<3)return n;
        while(position<n && pick<n){
            if(nums[position]==nums[position-1] && nums[position-1]==nums[position-2]){
                //change the position, find a number bigger than nums[position]
                //end condition
                while(pick<n && nums[pick]<=nums[position-1])pick++;
                if(pick>=n)break;
                else{nums[position]=nums[pick];nums[pick]=nums[0];position++;}
            }
            else if(nums[position]<nums[position-1]){
                while(pick<n && nums[pick]<nums[position-1])pick++;
                if(pick>=n)break;
                else{nums[position]=nums[pick];nums[pick]=nums[0];}                
            }
            else{position++;pick++;}
        }
        return position;
    }
}