/*
8. String to Integer (atoi)   QuestionEditorial Solution  My Submissions
Total Accepted: 132581
Total Submissions: 962566
Difficulty: Easy
Contributors: Admin
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Hide Company Tags Amazon Microsoft Bloomberg Uber
Hide Tags Math String
Hide Similar Problems (E) Reverse Integer (H) Valid Number
*/

public class Solution {
    public int myAtoi(String str) {
        int ans = 0;
        int sign = 1;
        int i = 0;
        while(i<str.length() && str.charAt(i)==' ')i++;
        if(i<str.length() && (str.charAt(i)=='+' || str.charAt(i)=='-')){
            if(str.charAt(i)=='-')sign=-1;
            i++;
        }
        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
            System.out.println(ans);
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && str.charAt(i)>'7')){
                if(sign==1)return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ans=ans*10+str.charAt(i)-'0';
            i++;
        }
        
        return sign*ans;
    }
}