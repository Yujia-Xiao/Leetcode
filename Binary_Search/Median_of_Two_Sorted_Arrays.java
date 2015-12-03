/*
Median of Two Sorted Arrays My Submissions Question
Total Accepted: 74889 Total Submissions: 424971 Difficulty: Hard
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Hide Company Tags Google Uber Zenefits
Hide Tags Divide and Conquer Array Binary Search
*/
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);    
    }
    public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;
 
        if (n <= 0)
            return B[startB + k - 1];
        if (m <= 0)
            return A[startA + k - 1];
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];
 
        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;
 
        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
            else
                return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
        } else {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
            else
                return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
        }
    }
}