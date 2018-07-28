/*
27. Remove Element  QuestionEditorial Solution  My Submissions
Total Accepted: 128002
Total Submissions: 368437
Difficulty: Easy
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Show Hint 
Hide Tags Array Two Pointers
Hide Similar Problems (E) Remove Duplicates from Sorted Array (E) Remove Linked List Elements (E) Move Zeroes
*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            if(nums[start] == val){
                if(nums[end] == val)
                    end--;    
                else{
                    nums[start] = nums[end];
                    start++; end --;
                }
            }else{
                start++;
            }
        }
        return start;
    }
}