/*
Roman to Integer My Submissions Question
Total Accepted: 64375 Total Submissions: 175611 Difficulty: Easy
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Hide Company Tags Uber
Hide Tags Math String
Hide Similar Problems (M) Integer to Roman
*/
public class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length()-1; i++){
            int a = charToInt(s.charAt(i));
            int b = charToInt(s.charAt(i+1));
            if(a>=b)ans+=a;
            else ans-=a;
        }
        ans+=charToInt(s.charAt(s.length()-1));
        return ans;
    }

    public int charToInt(char cha){
        switch(cha){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}