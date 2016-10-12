/*
115. Distinct Subsequences  QuestionEditorial Solution  My Submissions
Total Accepted: 59352
Total Submissions: 196903
Difficulty: Hard
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Hide Tags Dynamic Programming String
*/
public class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen==0 || tLen==0)return 0;
        int ans = 0;
        int[][] dp = new int[sLen+1][tLen+1];
        int[][] count = new int[sLen+1][tLen+1];
        Arrays.fill(count[0],1);
        for(int i=0;i<sLen;i++)count[i][0]=1;
        for(int i=0;i<sLen;i++){
            for(int j=0;j<tLen;j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                    count[i+1][j+1]+=count[i][j];
                    if(dp[i+1][j+1]==dp[i+1][j])count[i+1][j+1]+=count[i+1][j];//other options
                    if(dp[i+1][j+1]==dp[i][j+1])count[i+1][j+1]+=count[i][j+1];
                    
                    if(dp[i+1][j+1]==tLen)ans+=count[i][j];
                }
                else{
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                    if(dp[i+1][j+1]==dp[i+1][j])count[i+1][j+1]+=count[i+1][j];
                    if(dp[i+1][j+1]==dp[i][j+1])count[i+1][j+1]+=count[i][j+1];
                }
            }
        }
        return ans;
    }
}

public int numDistinct(String S, String T) {
    // array creation
    int[][] mem = new int[T.length()+1][S.length()+1];

    // filling the first row: with 1s
    for(int j=0; j<=S.length(); j++) {
        mem[0][j] = 1;
    }
    
    // the first column is 0 by default in every other rows but the first, which we need.
    
    for(int i=0; i<T.length(); i++) {
        for(int j=0; j<S.length(); j++) {
            if(T.charAt(i) == S.charAt(j)) {
                mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
            } else {
                mem[i+1][j+1] = mem[i+1][j];
            }
        }
    }
    
    return mem[T.length()][S.length()];
}