/*
154. Find Minimum in Rotated Sorted Array II  QuestionEditorial Solution  My Submissions
Total Accepted: 55981
Total Submissions: 159863
Difficulty: Hard
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Hide Tags Array Binary Search
Hide Similar Problems (M) Find Minimum in Rotated Sorted Array
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int s=0; int e = nums.length-1;
        while(s<=e){
            if(nums[s]<nums[e])return nums[s];
            int m=s+(e-s)/2;
            if(nums[s]<nums[m])s=m+1;
            else if(nums[s]>nums[m])e=m;
            else s++;
        }
        return nums[e];
    }
}