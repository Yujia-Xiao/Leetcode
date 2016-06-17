/*
131. Palindrome Partitioning My Submissions QuestionEditorial Solution
Total Accepted: 67049 Total Submissions: 240612 Difficulty: Medium
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
Hide Company Tags Bloomberg
Hide Tags Backtracking
Hide Similar Problems (H) Palindrome Partitioning II
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans =  new LinkedList<List<String>>(); 
        boolean[][] dp = new boolean[s.length()][s.length()];
        dpPreprocess(s,dp);
        backtrack(ans,new LinkedList<String>(),dp,s,0);
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, List<String> temList,boolean[][] dp,String s, int start){
        if(start==s.length())ans.add(new LinkedList<String>(temList));
        for(int i=start;i<s.length();i++){
            if(dp[start][i]){
                temList.add(s.substring(start,i+1));
                backtrack(ans,new LinkedList<String>(temList),dp,s,i+1);
                temList.remove(temList.size()-1);
            }
        }
    }
    
    public void dpPreprocess(String s, boolean[][]dp){
        for(int i=0;i<dp.length;i++)dp[i][i]=true;
        for(int len=2;len<=s.length();len++){
            for(int start=0;start<s.length()-len+1;start++){//end=(s.length()-len)+len-1 = s.length()-1
                int end=start+len-1;
                if(len==2){
                    if(s.charAt(start)==s.charAt(end))dp[start][end]=true;
                }
                else{
                    if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1])dp[start][end]=true;
                }
            }
        }
    }
    
    
}