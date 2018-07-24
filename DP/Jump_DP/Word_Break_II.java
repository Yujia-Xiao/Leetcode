/*
140. Word Break II  QuestionEditorial Solution  My Submissions
Total Accepted: 64913
Total Submissions: 309999
Difficulty: Hard
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Hide Company Tags Dropbox Google Uber Snapchat Twitter
Hide Tags Dynamic Programming Backtracking
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<String>();
        if(s==null || s.length()==0) return ans;
        
        List<String>[] dp = new LinkedList[s.length()+1];
        dp[0]=new LinkedList<String>();
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String tem = s.substring(j,i);
                if(dp[j]!=null && wordDict.contains(tem)){
                    if(dp[i]==null)dp[i]=new LinkedList<String>();
                    dp[i].add(tem);
                }
            }
        }
        
        dfs(dp,ans,"",s.length());
        return ans;
    }
    
    public void dfs(List<String>[] dp,List<String> ans,String cul,int root){
       // System.out.println(root);
        if(dp[root]==null)return;
        for(String str:dp[root]){
            String tem=str+" "+cul;
            int newRoot=root-str.length();
            if(newRoot==0)ans.add(tem.substring(0,tem.length()-1));
            dfs(dp,ans,tem,newRoot);
        }
        return;
    }
    
    
}
///07/23/2018

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
         /*
            string str
            break?(str, s, e) = {break?(str, s,k-1)+ wordDict.contains(k, e)} k=s, to e
            dynamic programming problem, break?(str,0,str.length()-1)
        */
        List<String> ans = new LinkedList<String>();
        if(s==null || s.length()==0)return ans;
        
        boolean[] dp = new boolean[s.length()+1];
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
        dp[0]=true;
        for(int i=1;i<=s.length();i++){//fill each element in dp arr
            for(int k=0;k<=i-1;k++){//figure out ligitimate k
                if(!dp[k])continue; // if previous state is false, skip.
                if(wordDict.contains(s.substring(k,i))){
                    dp[i]=true;
                    //keep record of all words that have previous state as true
                    if(!map.containsKey(i))map.put(i,new LinkedList<String>());
                    map.get(i).add(s.substring(k,i));
                }
            }
        }
        if(dp[s.length()])dfs(map,ans,s.length(), new StringBuilder());
        
        return ans;
    }
    
    public void dfs(Map<Integer,List<String>>map, List<String> ans, int index, StringBuilder strb){
        if(index==0){ans.add(strb.substring(0,strb.length()-1));return;}
        System.out.println(index);
        for(String str: map.get(index)){
            strb.insert(0, str+" ");
            dfs(map,ans,index-str.length(),strb);
            strb.delete(0,str.length()+1);
        }
        return;
    }
}