/*
Palindrome Permutation II My Submissions QuestionEditorial Solution
Total Accepted: 5833 Total Submissions: 20643 Difficulty: Medium
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
Hide Tags Backtracking
Hide Similar Problems (M) Next Permutation (M) Permutations II (E) Palindrome Permutation
*/
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new LinkedList<String>();
        boolean odd = false; char oddChar = ' '; int len=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        List<Character> e = new LinkedList<Character>();
        for(int i =0;i<s.length();i++){
            char tem = s.charAt(i);
            if(!map.containsKey(tem))map.put(tem,1);
            else if(map.get(tem)==1){map.remove(tem);e.add(tem);}
        }
        if(map.size()>1)return ans;
        if(map.size()==1){
            odd=true;
            Set<Character> temSet=map.keySet();
            for(char temChar:temSet)oddChar=temChar;
        }
        len=e.size();
        Collections.sort(e);
        boolean[] dp = new boolean[len];
        backtrack(ans, new StringBuilder(),odd,oddChar,0,e,len,dp);
        return ans;
    }
    
    public void backtrack(List<String> ans, StringBuilder temS, boolean odd, char oddChar, int idx, List<Character> e, int len,boolean[] dp){
        if(idx==len){
            String add="";
            if(odd)add=temS.toString()+oddChar+temS.reverse().toString();
            else add=temS.toString()+temS.reverse().toString();
            ans.add(add);
        }else{
            for(int i=0;i<len;i++){
                if(dp[i])continue;//two case;!!!! do not write to gether
                if(i>0 && e.get(i-1)==e.get(i)&&!dp[i-1]){dp[i]=false;continue;}
                temS.append(e.get(i));
                dp[i]=true;
                backtrack(ans,new StringBuilder(temS.toString()),odd,oddChar,idx+1,e,len,dp);
                temS.deleteCharAt(temS.length()-1);   
                dp[i]=false;    
                
            }
        }    
    }
    
}