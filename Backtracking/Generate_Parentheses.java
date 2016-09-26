/*
Generate Parentheses 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Hide Company Tags Google Zenefits
Hide Tags Backtracking String
Hide Similar Problems (M) Letter Combinations of a Phone Number (E) Valid Parentheses
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if(n==0){return ans;}
        String tempStr = "";
        addOneParenthesis(n,0,0,tempStr,ans);
        return ans;
    }
    
    public void addOneParenthesis(int n,int left, int right, String s, List<String> ans){
        if(left<right){return;}
        if(left==n && right==n){
            ans.add(s);
            return;
        }
        if(left==n){
            addOneParenthesis(n,left,right+1,s+")",ans);
            return; 
        }
        addOneParenthesis(n,left+1,right,s+"(",ans);
        addOneParenthesis(n,left,right+1,s+")",ans);
    }   
}