/*
334. Increasing Triplet Subsequence  QuestionEditorial Solution  My Submissions
Total Accepted: 25246
Total Submissions: 68474
Difficulty: Medium
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.

Credits:
Special thanks to @DjangoUnchained for adding this problem and creating all test cases.

Hide Company Tags Facebook
Hide Similar Problems (M) Longest Increasing Subsequence
*/
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] LIS = new int[3];
        int len = 0;
        for(int i=0;i<nums.length;i++){
            int tem = nums[i];
            int s = 0;
            int e = len-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(LIS[mid]==tem)break;
                else if(LIS[mid]<tem)s=mid+1;
                else e=mid-1;
            }
            if(s==len)len++;
            LIS[s]=tem;
            if(len==3)return true;
        }
        return false;
    }
}