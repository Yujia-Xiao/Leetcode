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