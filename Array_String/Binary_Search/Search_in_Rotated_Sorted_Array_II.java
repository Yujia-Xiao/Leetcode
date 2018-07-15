/*
81. Search in Rotated Sorted Array II  QuestionEditorial Solution  My Submissions
Total Accepted: 67874
Total Submissions: 210431
Difficulty: Medium
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Hide Tags Array Binary Search
Hide Similar Problems (H) Search in Rotated Sorted Array
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        
       int l=0; int h=nums.length-1;int mid=l+(h-l)/2;
       while(l<=h){
           mid=l+(h-l)/2; //52 -> l could be mid 
           if(nums[mid]==target)return true;
           if(nums[l]<nums[mid]){
               if(target>=nums[l] && target<nums[mid]) h=mid-1;
               else l=mid+1;
           }
           else if(nums[l]>nums[mid]){
               if(target>nums[mid] && target<=nums[h])l=mid+1;
               else h=mid-1;
           }
           else{
               l++;
           }
       }
       
       return false;
    }
}