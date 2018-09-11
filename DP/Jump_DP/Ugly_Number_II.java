/*
264. Ugly Number II My Submissions QuestionEditorial Solution
Total Accepted: 32200 Total Submissions: 112121 Difficulty: Medium
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Dynamic Programming Heap Math
Hide Similar Problems (H) Merge k Sorted Lists (E) Count Primes (E) Ugly Number (M) Perfect Squares (M) Super Ugly Number
*/
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<2)return n;
        int[] dp = new int[n];dp[0]=1;
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(2*dp[p2],Math.min(3*dp[p3],5*dp[p5]));
            if(dp[i]==dp[p2]*2)p2++;
            if(dp[i]==dp[p3]*3)p3++;
            if(dp[i]==dp[p5]*5)p5++;
        }
        return dp[n-1];
    }
}
