/*
Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Hide Tags Array Binary Search
Hide Similar Problems (E) First Bad Version
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0; int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(target==nums[mid])return mid;
            if(target<nums[mid]){end=mid-1;}            
            else start=mid+1;
        }
        return start;

    }

}