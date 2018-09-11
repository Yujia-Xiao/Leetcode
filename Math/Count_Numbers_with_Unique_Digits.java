/*
357. Count Numbers with Unique Digits My Submissions QuestionEditorial Solution
Total Accepted: 2371 Total Submissions: 5722 Difficulty: Medium
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Show Hint 
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming Backtracking Math
*/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n<0)return 0;
        if(n==0)return 1;
        int dp = 10;
        int prePreDp = 0;
        int preDp = 1;
        int availableDigits = 10;
        int lowerNum = 1;
        
        for(int i=2;i<=n;i++){
            availableDigits--;
            prePreDp=preDp;
            preDp=dp;
            dp+=(dp-prePreDp)*availableDigits;
        }
        return dp;
    }
}
/*
0 1 2 3 4 5 6 7 8 9 (10+9*9)
01 02 03 .... 09 (lost 0)
10 12 13.....19
....
(91-10)*8=648
648+91=739

739-
*/