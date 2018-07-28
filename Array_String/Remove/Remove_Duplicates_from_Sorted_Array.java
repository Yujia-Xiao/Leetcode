/*
Remove Duplicates from Sorted Array My Submissions Question
Total Accepted: 101331 Total Submissions: 315044 Difficulty: Easy
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Hide Company Tags Bloomberg Facebook
Hide Tags Array Two Pointers
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length; int position = 1; int pick = 1;;
        if(n<2)return n;
        while(pick<n && position<n){
            if(nums[position-1]>=nums[position]){
                //find the pick position, 
                while(pick<n && nums[position-1]>=nums[pick])pick++;
                if(pick>=n)break;
                nums[position]=nums[pick];
                position++;
            }
            else position++;
        }
        return position;
    }
}

//07/25/2018
class Solution {
    public int removeDuplicates(int[] nums) {
        //pointer1: insertion position 0,1,2,....,len-1, return len; len<=nums.length;
        //pointer2,3: finding the qualified number to insert. 0-len-1
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return 1;
        int insert = 1;
        int cul = 1; // the potential duplicates
        int pre = 0;
        //nums[0]will not moved
        for(;cul<nums.length;cul++){
            if(nums[cul]!=nums[pre]){
                //insert
                nums[insert]=nums[cul];
                insert++;
            }
            pre++;
        }//insert: always be the position to be inserted, == index of ans +1
        return insert;//
    }
}