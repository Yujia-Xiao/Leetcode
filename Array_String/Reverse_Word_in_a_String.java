/*
Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Hide Tags String
Hide Similar Problems (M) Reverse Words in a String II
*/
public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)return "";
        String[] array=s.split(" ");
        StringBuilder ans=new StringBuilder();
        for(int i=array.length-1;i>=0;--i){
            if(!array[i].equals(""))ans.append(array[i]).append(" ");
        }
        
        return ans.length() == 0 ? "" : ans.substring(0, ans.length() - 1);
    }
}