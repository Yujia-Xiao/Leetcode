/*
Letter Combinations of a Phone Number My Submissions QuestionEditorial Solution
Total Accepted: 83943 Total Submissions: 286410 Difficulty: Medium
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

Hide Company Tags Amazon Dropbox Google Uber Facebook
Hide Tags Backtracking String
Hide Similar Problems (M) Generate Parentheses (M) Combination Sum
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if(digits==null || digits.length()==0)return ans;
        Map<Character,String> map = new HashMap<Character,String>();
        map.put('1',"");map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");
        map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");map.put('8',"tuv");
        map.put('9',"wxyz");map.put('0',"");
        backtrack(ans,new StringBuilder(),digits,digits.length(),0,map);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder temS, String digits, int remain,int start, Map<Character,String> map){
        if(remain==0)ans.add(temS.toString());
        else{
            for(int i=start;i<digits.length();i++){
                char ch = digits.charAt(start);
                String s = map.get(ch);
                for(int j=0;j<s.length();j++){
                    temS.append(s.charAt(j));
                    backtrack(ans,new StringBuilder(temS.toString()),digits,remain-1,i+1,map);
                    temS.deleteCharAt(temS.length()-1);   
                }
            }
        }
    }
}