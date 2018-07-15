/*
275. H-Index II  QuestionEditorial Solution  My Submissions
Total Accepted: 27781
Total Submissions: 84306
Difficulty: Medium
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
Hide Company Tags Facebook
Hide Tags Binary Search
Hide Similar Problems (M) H-Index
*/
public class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int s=0,e=n-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(citations[m]==n-m)return n-m;
            else if(citations[m]>n-m)e=m-1;
            else s=m+1;
        }
        return n - (e+1);
    }
}