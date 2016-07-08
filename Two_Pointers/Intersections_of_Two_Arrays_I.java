/*
349. Intersection of Two Arrays  QuestionEditorial Solution  My Submissions
Total Accepted: 26329
Total Submissions: 59093
Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays II
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tem = new HashSet<Integer>();
        Set<Integer> ans = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            tem.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(tem.contains(nums2[i]))ans.add(nums2[i]);
        }
        int[] a = new int[ans.size()];
        int i=0;
        for(int e:ans){a[i]=e;i++;}
        return a;
    }
}