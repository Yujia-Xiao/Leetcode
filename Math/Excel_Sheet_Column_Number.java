/*
Excel Sheet Column Number
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Uber
Hide Tags Math
Hide Similar Problems (E) Excel Sheet Column Title
*/
public class Solution {
    public int titleToNumber(String s) {
        if(s==null || s.length()==0)return 0;
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(i==0)num=s.charAt(s.length()-i-1)-'A'+1;
            else num=num+(int)Math.pow(26,i)*(s.charAt(s.length()-i-1)-'A'+1);
        }
        return num;
    }
}
