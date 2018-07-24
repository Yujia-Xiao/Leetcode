class Solution {
    public int longestPalindromeSubseq(String s) {
        /*
        1.brute force O(n*3)
            i: 0 - len-1
                j: 0 - i
                    isPalindrome(str, j, i)?    
        2.Longest common subsequence(LCS)
            LCS(str1, str2): longest common subsequence:  abbbc, adc. -> ac
            LCS(str1, str1.reverse()):
                    abcdedf  i=5
                    fdedcba  j=6-3=3
                    -> ded
                    
                    fde abc edf    i=2
                    fde cba edf    j=8-2=6
                    ->fde
                    if is a palindrome, it can go through head to tail, makes i >= j.
                    j <= i
        LCS: 
        if(A.chatAt(i)==B.charAt(j)) F{A(i),B(j)}=+1F{A(i-1),B(j-1)}
        else F{i,j}=Max(F{A(i),B(j-1)},F{A(i-1),B(j)})
            
        */
        if(s==null)return 0; 
        if(s.length()==0)return 0;
        
        int max = 0;
        int[][] dp = new int[s.length()+1][s.length()+1];
        String strR = (new StringBuilder(s)).reverse().toString();
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=strR.length();j++){
                if(s.charAt(i-1)==strR.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(max<dp[i][j])max=dp[i][j];
            }
        }
        
        return max;
    }
}

//7/23/2018

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}