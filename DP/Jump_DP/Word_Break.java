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

//07/23/2018
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            string str
            break?(str, s, e) = {break?(str, s,k-1)+ wordDict.contains(k, e)} k=s, to e
            dynamic programming problem, break?(str,0,str.length()-1)
        */
        if(s==null || s.length()==0)return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){//fill each element in dp arr
            for(int k=0;k<=i-1;k++){//figure out ligitimate k
                if(!dp[k])continue; // if previous state is false, skip.
                if(wordDict.contains(s.substring(k,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}