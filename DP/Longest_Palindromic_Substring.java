/*
Longest Palindromic Substring 
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Hide Company Tags Amazon Microsoft Bloomberg
Hide Tags String
Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation
*/
public class Solution {
    public String longestPalindrome(String s) {
       //dp solution
       //in [j,i] if charAt(i)==charAt(j) then judge (1)i-j+1<=2->true (2)dp[j+1][i-1]==true;
       //base case dp[i][i]==true
       //length (2,n),n=s.length()
       //O(n^2)
       if(s==null || s.length()==0) return "";
       int n = s.length(); int ans = 1; int start=0;int end =0;
       boolean[][] dp = new boolean[n][n];
       for(int i=0;i<n;i++){
           dp[i][i]=true;
       }
       for(int len=2;len<=n;len++){
           for(int i=len-1;i<n;i++){
               int j=i-len+1;
               if(s.charAt(i)==s.charAt(j) && ((i-j+1==2)||(dp[j+1][i-1]))){
                   dp[j][i]=true;
                    if(i-j+1>ans){
                        ans=i-j+1;
                        start=j;
                        end=i;
                    }    
               }
               else dp[j][i]=false;
           }
       }
       return s.substring(start,end+1);
    }
}