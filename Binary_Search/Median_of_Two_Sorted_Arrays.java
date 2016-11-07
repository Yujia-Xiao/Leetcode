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

//Solution2
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length+nums2.length;
    if(total%2==0){
        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
    }else{
        return findKth(total/2+1, nums1, nums2, 0, 0);
    }
}
 
public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
    if(s1>=nums1.length)
        return nums2[s2+k-1];
 
    if(s2>=nums2.length)
        return nums1[s1+k-1];
 
    if(k==1)
        return Math.min(nums1[s1], nums2[s2]);
 
    int m1 = s1+k/2-1;
    int m2 = s2+k/2-1;
 
    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
 
    if(mid1<mid2){
        return findKth(k-k/2, nums1, nums2, m1+1, s2);
    }else{
        return findKth(k-k/2, nums1, nums2, s1, m2+1);
    }
}