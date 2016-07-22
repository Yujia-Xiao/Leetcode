/*
367. Valid Perfect Square  QuestionEditorial Solution  My Submissions
Total Accepted: 8944
Total Submissions: 24424
Difficulty: Medium
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Hide Company Tags LinkedIn
Hide Tags Binary Search Math
Hide Similar Problems (M) Sqrt(x)
*/
public class Solution {
    public boolean isPerfectSquare(int num) {
        int s=1,e=num;
        while(s<=e){
            int m=s+(e-s)/2;
            if(m==num/m){if(num%m==0)return true;else s=m+1;}
            else if(m<num/m)s=m+1;
            else e=m-1;
        }
        return false;
    }
}