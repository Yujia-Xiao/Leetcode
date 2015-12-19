/*
Integer to Roman 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Tags Math String
Hide Similar Problems (E) Roman to Integer (M) Integer to English Words
*/
public class Solution {
    public String intToRoman(int num) {
        //I-1 V-5 X-10 L-50 C-100 D-500 M-1000
        //0-1;1-10;2-100;3-1000
        String ans = "";    
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};   
        for(int i=0;num!=0;++i){  
            while(num>=value[i]){  
                num-=value[i];  
                ans+=symbol[i];  
            }  
        }  
        return ans;  
    }
}