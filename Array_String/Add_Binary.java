/*
Add Binary 
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Hide Company Tags Facebook
Hide Tags Math String
Hide Similar Problems (M) Add Two Numbers (M) Multiply Strings (E) Plus One
*/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if(a.length()<b.length())return addBinary(b,a);//a>=b
        int carry = 0; int i = 0;
        for(;i<b.length();i++){
            int aa = (a.charAt(a.length()-1-i)=='1')?1:0;
            int bb = (b.charAt(b.length()-1-i)=='1')?1:0;
            String str = Integer.toBinaryString(aa+bb+carry);
            if(str.length()==2)carry=1;
            else carry=0;
            sb.insert(0,str.charAt(str.length()-1));
        }
        for(;i<a.length();i++){
            int aa2 = (a.charAt(a.length()-1-i)=='1')?1:0;
            String str = Integer.toBinaryString(aa2+carry);
            if(str.length()==2)carry=1;
            else carry=0;
            sb.insert(0,str.charAt(str.length()-1));
        }
        if(carry==1)sb.insert(0,"1");
        return sb.toString();
    }
}