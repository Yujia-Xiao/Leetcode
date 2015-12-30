/*
Sort Colors My Submissions Question
Total Accepted: 80265 Total Submissions: 238659 Difficulty: Medium
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
Hide Company Tags Facebook
Hide Tags Array Two Pointers Sort
Hide Similar Problems (M) Sort List (M) Wiggle Sort
*/
public class Solution {
    public void sortColors(int[] nums) {
        //0-red. 1-white. 2-blue
        //order red white blue
        Arrays.sort(nums);
    }
}