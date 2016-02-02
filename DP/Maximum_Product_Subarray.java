/*
Maximum Product Subarray My Submissions Question
Total Accepted: 50914 Total Submissions: 238196 Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Hide Company Tags LinkedIn
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self
*/
public class Solution {
    public int maxProduct(int[] A) {
        int min;
        int res = A[0], max = min = A[0]; // max, min means max and min product among the subarrays whose last element is A[i].
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                max = Math.max(max * A[i], A[i]);
                min = Math.min(min * A[i], A[i]);               
            }
        else {
           int lastMax = max;
           max = Math.max(min * A[i], A[i]);
           min = Math.min(lastMax * A[i], A[i]);                           
        }
        res = Math.max(res, max);
        }
        return res;
    }
}