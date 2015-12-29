/*
Implement strStr()
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Hide Company Tags Microsoft Facebook
Hide Tags Two Pointers String
Hide Similar Problems (H) Shortest Palindrome
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())return -1;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.startsWith(needle,i))return i;
        }
        return -1;
    }
}