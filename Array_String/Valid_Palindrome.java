/*
Valid Palindrome My Submissions Question
Total Accepted: 81112 Total Submissions: 354733 Difficulty: Easy
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Hide Company Tags Microsoft Uber Facebook Zenefits
Hide Tags Two Pointers String
Hide Similar Problems (E) Palindrome Linked List
*/
public class Solution {
    public boolean isPalindrome(String str) {
        if(str==null || str.length()==0)return true;
        String lowerS = str.toLowerCase();
        int start = 0; int end = lowerS.length()-1;
        while(start<=end){
            char s = lowerS.charAt(start); char e =lowerS.charAt(end);
            if(!((s<='z' && s>='a')||(s<='9' && s>='0'))){start++;continue;}
            if(!((e<='z' && e>='a')||(e<='9' && e>='0'))){end--;continue;}
            if(s==e){start++;end--;}
            else return false;
        }
        return true;
    }
}