/*
Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.

Hide Company Tags Microsoft Facebook Zenefits
Hide Tags Math
Hide Similar Problems (E) Excel Sheet Column Number
*/
public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        return helper(n,ans);
    }
    public String helper(int n, String ans){
        if(n>26){
            char tmp = (char)('A'+ (n-1)%26);
            ans=tmp+ans;
            return helper((n-1)/26,ans);
        }
        else{
            char tmp = (char)('A'+ n-1);
            ans=tmp+ans;
            return ans; 
        }
    }
}