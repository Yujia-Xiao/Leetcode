/*
Word Break 
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length() == 0){return false;}
        
        boolean check[] = new boolean[s.length()+1];
        check[0] = true;
        
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String substr = s.substring(j,i);
                if(check[j] && wordDict.contains(substr)){
                    check[i]=true;
                    break;
                }
            }
        }
        return check[s.length()];
    }
}