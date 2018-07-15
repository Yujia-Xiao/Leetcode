/*
153. Find Minimum in Rotated Sorted Array  QuestionEditorial Solution  My Submissions
Total Accepted: 101651
Total Submissions: 274120
Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Hide Company Tags Microsoft
Hide Tags Array Binary Search
Hide Similar Problems (H) Search in Rotated Sorted Array (H) Find Minimum in Rotated Sorted Array II
*/
public class Solution {
    public int findMin(int[] nums) {
        int s=0; int e = nums.length-1;
        while(s<=e){
            if(nums[s]<=nums[e])return nums[s];
            int m=s+(e-s)/2;
            if(nums[s]<=nums[m])s=m+1;
            else e=m;
        }
        return 0;///anything is ok
    }
}