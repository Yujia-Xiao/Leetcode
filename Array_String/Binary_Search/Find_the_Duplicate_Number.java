/*
287. Find the Duplicate Number  QuestionEditorial Solution  My Submissions
Total Accepted: 34180
Total Submissions: 85717
Difficulty: Hard
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Bloomberg
Hide Tags Binary Search Array Two Pointers
Hide Similar Problems (H) First Missing Positive (M) Single Number (M) Linked List Cycle II (M) Missing Number

*/

 public class Solution {
    public int findDuplicate(int[] nums) {
    int min=1, max=nums.length-1;  //n+1 length array where each integer is    between 1 and n 
   while(min<=max){
        int cnt=0;
        int mid=min+(max-min)/2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid)
                cnt++;
        }
        if(cnt>mid){
            max=mid-1;
        }
        else min=mid+1;
    }
    return min;
}