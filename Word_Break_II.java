*/
Word Break II 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Hide Company Tags Google Uber
Hide Tags Dynamic Programming Backtracking
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<String>();
        if(s==null || s.length()==0) return ans;
        //DP
        List<String>[] dp = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>(); String subString;
        for(int i=1;i<s.length()+1;i++){
            for(int j=0;j<i;j++){
                subString = s.substring(j,i);
                if((dp[j]!=null) && wordDict.contains(subString)){
                    if(dp[i]==null){
                        List<String> dpMatch = new ArrayList<String>();
                        dpMatch.add(subString);
                        dp[i]=dpMatch;
                    }
                    else{
                        dp[i].add(subString);
                    }
                }
            }
        }
        
        if(dp[s.length()]==null) return ans;
        List<String> temp = new ArrayList<String>();int start=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]!=null && dp[i].size()!=0){
                start=i;break;
            }
        }
        dfs(dp,temp,s.length(),ans);
        //dfs2(dp,temp,start,s.length(),ans);
        return ans;
    }
    
    public void dfs(List<String>[] dp, List<String> temp, int end, List<String> ans){
        if(end<=0){ //end condition
                String ansString = "";
            for(String s:temp){
                ansString = s+" "+ansString;
            }
            
                ansString=ansString.substring(0,ansString.length()-1);
                ans.add(ansString);               
        }
        for(String endString:dp[end]){
            temp.add(endString);
            dfs(dp,temp,end-endString.length(),ans);
            temp.remove(endString);
        }
        return;
    }
    
    public void dfs2(List<String>[] dp, List<String>temp, int start,int end, List<String> ans){
        if(start>=end){
            String ansString = "";
            for(String s: temp){
                ansString=ansString+s+" ";
            }
            ansString=ansString.substring(0,ansString.length()-1);
            ans.add(ansString);
        }
        for(String startString:dp[start]){
            temp.add(startString);
            int newStart = start;
            for(int i=start+1;i<dp.length;i++){
                if(dp[i]!=null && dp[i].size()!=0){
                    newStart=i;break;
                }
            }
            dfs2(dp,temp,newStart,end,ans);
            temp.remove(startString);
        }
        return;
    }   
}