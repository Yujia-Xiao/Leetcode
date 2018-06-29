class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // DP: dp[n] = {dp[i] && substring(i+1, n) is a word}
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i = 0; i < len; i++)
        {
            
            if(wordDict.contains(s.substring(0,i+1)))
            {
                dp[i] = true;
                continue;
            }
            
            for( int j = 0; j < i; j++)
            {
                if(dp[j] && wordDict.contains(s.substring(j+1,i+1))) 
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        //System.out.println(dp);
        return dp[len -1];
    }
}