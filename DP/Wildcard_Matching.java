/*
44. Wildcard Matching  QuestionEditorial Solution  My Submissions
Total Accepted: 69324
Total Submissions: 376508
Difficulty: Hard
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
Hide Company Tags Google Snapchat Facebook
Hide Tags Dynamic Programming Backtracking Greedy String
Hide Similar Problems (H) Regular Expression Matching
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int j=0;j<pLen;j++){
            if(p.charAt(j)=='*')dp[0][j+1]=dp[0][j];
        }
        //System.out.print("  ");
        //for(int j=0;j<pLen;j++) System.out.print(p.charAt(j)+" ");
        for(int i=0;i<sLen;i++){
            //System.out.println();
            //System.out.print(s.charAt(i)+" ");
            for(int j=0;j<pLen;j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')dp[i+1][j+1]=dp[i][j];
                else if(p.charAt(j)=='*')dp[i+1][j+1]=dp[i+1][j] || dp[i][j+1];
                //String tem = dp[i+1][j+1]==true ? "T" : "F";
                //System.out.print(tem+" ");
            }
        }
        
        return dp[sLen][pLen];
    }
}


// 06/30/2018
class Solution {
    public boolean isMatch(String s, String p) {
        /*This is a DP formula
         b: '*'
         s(1,a-1 to n)p(1,b) = s(1,a-1)p(1,1-b)
         b: '?'
         b == a
         s(1,a)p(1,b) = s(1,a-1)p(1,1-b)
         b != a
         s(1,a)p(1,b) = false
        */
        if(s == null || p == null) return false;
        
        int sLen = s.length(); 
        int pLen = p.length();
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        
        dp[0][0] = true;
        
        for(int i = 0 ; i < pLen; i++ ){
            if(p.charAt(i) == '*') dp[0][i+1] = dp[0][i];
            else break;
        }
        
        for(int i = 0; i < sLen; i++){

            for(int j = 0; j < pLen; j++){
                
                
                if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) dp[i+1][j+1] = dp[i][j];
                
                else if(p.charAt(j) == '*') dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
            }
    }
        return dp[sLen][pLen];
    }
}