/*
32. Longest Valid Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 75577
Total Submissions: 330254
Difficulty: Hard
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Hide Tags Dynamic Programming String
Hide Similar Problems (E) Valid Parentheses
*/
public class Solution {
    public int longestValidParentheses(String s) {
        s = ")" + s;
        int[] longest = new int[s.length() + 1];
        
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')' && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];
                longest[s.length()] = Math.max(longest[i], longest[s.length()]); 
            }
        }
        
        return longest[s.length()];
    }
}