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
        if(s==null || s.length()==0)return 0;
        int ans = 0; int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='I'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='V'){ans=ans+4;i=i+2;}
                    else if(s.charAt(i+1)=='X'){ans=ans+9;i=i+2;}
                    else{ans=ans+1;i=i+1;}
                }
                else{ans=ans+1;i=i+1;}
            }
            else if(s.charAt(i)=='X'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='L'){ans=ans+40;i=i+2;}
                    else if(s.charAt(i+1)=='C'){ans=ans+90;i=i+2;}
                    else{ans=ans+10;i=i+1;}
                }
                else{ans=ans+10;i=i+1;}
            }
            else if(s.charAt(i)=='C'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='D'){ans=ans+400;i=i+2;}
                    else if(s.charAt(i+1)=='M'){ans=ans+900;i=i+2;}
                    else{ans=ans+100;i=i+1;}
                }
                else{ans=ans+100;i=i+1;}
            }
            else if(s.charAt(i)=='V'){ans=ans+5;i++;}
            else if(s.charAt(i)=='L'){ans=ans+50;i++;}
            else if(s.charAt(i)=='D'){ans=ans+500;i++;}
            else if(s.charAt(i)=='M'){ans=ans+1000;i++;}
        }
        return ans;
    }
}