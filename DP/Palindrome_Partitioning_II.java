/*
132. Palindrome Partitioning II  QuestionEditorial Solution  My Submissions
Total Accepted: 58988
Total Submissions: 256852
Difficulty: Hard
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Hide Tags Dynamic Programming
Hide Similar Problems (M) Palindrome Partitioning
*/
public class Solution {
    public int minCut(String s) {
        if(s==null || s.length()==0)return 0;
        int sLen = s.length();
        boolean[][] dp = new boolean[sLen][sLen];
        for(int len=1;len<=sLen;len++){
            for(int i=0;i<sLen-len+1;i++){
                int j=i+len-1;
                if(len==1)dp[i][j]=true;
                else if(len==2 && s.charAt(i)==s.charAt(j))dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])dp[i][j]=true;
            }
        }
        
        int[] count = new int[sLen+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=-1;
        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=i;j++){
                if(dp[j-1][i-1] && count[j-1]<Integer.MAX_VALUE)count[i]=Math.min(count[i],count[j-1]+1);
            }
        }
        return count[sLen];
    }
}

public int minCut(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}