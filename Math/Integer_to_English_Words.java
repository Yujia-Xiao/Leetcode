/*
Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
Hide Company Tags Facebook
Hide Tags Math String
Hide Similar Problems (M) Integer to Roman
*/
public class Solution {
    public String numberToWords(int num) {
        //2^31-1=2,147,483,647 ->billion
        if(num==0) return "Zero";
        int[] intNum = {1000000000,1000000,1000,100,90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        String[] StrNum = {"Billion","Million","Thousand","Hundred","Ninety","Eighty","Seventy","Sixty","Fifty","Forty","Thirty","Twenty","Nineteen","Eighteen","Seventeen","Sixteen","Fifteen","Fourteen","Thirteen","Twelve","Eleven","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One"};
        String ans = "";
        for(int i=0;i<intNum.length;i++){
            if(num>=100){
                if(num>=intNum[i]){
                    int temp = 0;
                    while(num>=intNum[i]){
                        temp++;
                        num=num-intNum[i];
                    }
                    ans=ans+numberToWords(temp)+" "+StrNum[i]+" ";
                }
            }
            else{
                if(num>=intNum[i]){
                    num=num-intNum[i];
                    ans=ans+StrNum[i]+" ";
                }
            }
        }
        return ans.substring(0,ans.length()-1);    
    }
}