/*
345. Reverse Vowels of a String  QuestionEditorial Solution  My Submissions
Total Accepted: 27301
Total Submissions: 75936
Difficulty: Easy
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Hide Company Tags Google
Hide Tags Two Pointers String
Hide Similar Problems (E) Reverse String
*/
public class Solution {
    public String reverseVowels(String s){
        //O(n) is the best situation
        if(s==null || s.length()<=1)return s;
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');vowels.add('o');vowels.add('e');vowels.add('i');vowels.add('u');
        int start = 0; int end = s.length()-1;
        char[] sArrOri = s.toCharArray();
        s=s.toLowerCase();
        char[] sArr = s.toCharArray();
        while(start<=end){
            while(sArr[start]<'a' || sArr[start]>'z' || !vowels.contains(sArr[start])){
                if(start<s.length()-1)start++;
                else break;
            }
            while(sArr[end]<'a' || sArr[end]>'z' || !vowels.contains(sArr[end])){
                if(end>0)end--;
                else break;
            }
            if(start>end)break;
            char tem = sArrOri[start];
            sArrOri[start]=sArrOri[end];
            sArrOri[end]=tem;
            start++;end--;
        }
        return new String(sArrOri);
    }
}