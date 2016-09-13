/*
186. Reverse Words in a String II  QuestionEditorial Solution  My Submissions
Total Accepted: 14062
Total Submissions: 48359
Difficulty: Medium
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array

Hide Company Tags Amazon Microsoft Uber
Hide Tags String
Hide Similar Problems (M) Reverse Words in a String (E) Rotate Array
*/

public class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        for(char str: s)System.out.print(str);
        int pre = -1;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                reverse(s,pre+1,i-1);
                pre=i;
            }
        }
        reverse(s,pre+1,s.length-1);
        return;
    }
    
    public void reverse(char[] s, int start, int end){
        if(s==null || s.length<2)return;
        System.out.println(start+" "+end);
        for(int i=0;i<=(end-start)/2;i++){
            char tem = s[start+i];
            s[start+i]=s[end-i];
            s[end-i]=tem;
        } 
        return;
    }
}