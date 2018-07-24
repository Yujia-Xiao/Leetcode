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
-------------

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return null;
        if(s.length() == 1) return s;
        int len = s.length();
        int max = 0;
        String ans = "";
        String sR = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i ++)
        {
            for(int j = 0; j < len; j++)
            {
                if(s.charAt(i) == sR.charAt(j)) 
                {
                    if(i == 0 || j == 0)dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j-1] + 1;
                    
                    if(dp[i][j] > max){
                        
                        if(Palindromic(s.substring(i-dp[i][j]+1,i+1)))
                        {
                            ans = s.substring(i-dp[i][j]+1,i+1);
                            max = dp[i][j];
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    public boolean Palindromic (String s){
        if(s == null || s.length() == 0)return false;
        if(s.length() == 1) return true;
        int j = s.length() - 1;
        for(int i = 0; i < j; i++){
            if(s.charAt(i) != s.charAt(j))return false;
            j--;
        }
        return true;
    }
}


// 7/23/2018
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        if(s==null)return ans; 
        if(s.length()==0)return ans;
        
        int max = 0;
        int[][] dp = new int[s.length()+1][s.length()+1];
        String strR = (new StringBuilder(s)).reverse().toString();
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=strR.length();j++){
                if(s.charAt(i-1)==strR.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=0;
                                  
                if(max<dp[i][j] && i-1-dp[i][j]+1==s.length()-j){
                    
                    max=dp[i][j];
                    ans = s.substring(s.length()-j,i);
                }
                
            }
        }
        
        return ans;
    }
}

class Solution {
private int lo, maxLen,len;

public String longestPalindrome(String s) {
	len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
    if(maxLen==len)return;
}}