/*
91. Decode Ways  QuestionEditorial Solution  My Submissions
Total Accepted: 75454
Total Submissions: 421639
Difficulty: Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Hide Company Tags Microsoft Uber Facebook
Hide Tags Dynamic Programming String
*/
public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)return 0;
        if(s.length()==1 && s.charAt(0)=='0')return 0;
        int[] dp = new int[s.length()+1];
        dp[s.length()]=1;
        dp[s.length()-1]=(s.charAt(s.length()-1)=='0')?0:1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)!='0')dp[i]+=dp[i+1];
            if(s.charAt(i)=='1' ||  (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
}