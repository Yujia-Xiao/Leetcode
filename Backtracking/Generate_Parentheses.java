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
        //(( -> (()  ((( ->  (()) (()( ; ((()
        //(())(  ; (()()    -->(())() ;(()())
        //() -> ()(
        //backtracking, use recursion to find all posibilities
        //end condition: 1. left<right return 2.right==3 && left==3 add, return
        //left==3 add ")"
        //add either "(" or ")" to current str --> next recursion
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
            return; //need a return, otherwith it will casue the stackOverFlow error, because multiple  
            //addOneParenthesis(n,left,right+1,s+")",ans);
        }
        addOneParenthesis(n,left+1,right,s+"(",ans);
        addOneParenthesis(n,left,right+1,s+")",ans);
    }   
}