/*
 Longest Substring Without Repeating Characters  QuestionEditorial Solution  My Submissions
Total Accepted: 162775
Total Submissions: 720494
Difficulty: Medium
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Hide Company Tags Amazon Adobe Bloomberg Yelp
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1)return 1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
        
    }
}