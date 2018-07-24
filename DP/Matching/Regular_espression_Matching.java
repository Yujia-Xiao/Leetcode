/*
10. Regular Expression Matching  QuestionEditorial Solution  My Submissions
Total Accepted: 98491
Total Submissions: 429576
Difficulty: Hard
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Hide Company Tags Google Uber Airbnb Facebook Twitter
Hide Tags Dynamic Programming Backtracking String
Hide Similar Problems (H) Wildcard Matching
*/
public class Solution {
    public boolean isMatch(String s, String p) {
    
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        //DP
        if(s==null || p==null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        //Initialization
        dp[0][0]=true;  
        for(int j=1;j<p.length()+1;j++)if(p.charAt(j-1)=='*')dp[0][j]=dp[0][j-2];
       
        //DP formula
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!=s.charAt(i-1) && p.charAt(j-2)!='.')dp[i][j]=dp[i][j-2];
                    else dp[i][j]=dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}