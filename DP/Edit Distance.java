/*
72. Edit Distance
Question Editorial Solution  
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.) 
You have the following 3 operations permitted on a word: 
 a) Insert a character
 b) Delete a character
 c) Replace a character
Hide Tags Dynamic Programming String  
Hide Similar Problems
 (M) One Edit Distance 
 */
 public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0)dp[i][j]=j;
                else if(j==0)dp[i][j]=i;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else 
                    dp[i][j]=1+min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
            }
        }
        //System.out.println(dp[0][0]+" "+dp[0][1]+" "+dp[0][2]);
        //System.out.println(dp[1][0]+" "+dp[1][1]+" "+dp[1][2]);
        //System.out.println(dp[2][0]+" "+dp[2][1]+" "+dp[2][2]);
        return dp[len1][len2];
    }
    public int min(int a, int b, int c){
        if(a<=b && a<=c)return a;
        else if(b<=a && b<=c)return b;
        else return c;
    }
}