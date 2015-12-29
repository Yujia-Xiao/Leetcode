/*
Count and Say My Submissions Question
Total Accepted: 65424 Total Submissions: 241559 Difficulty: Easy
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Hide Company Tags Facebook
Hide Tags String
Hide Similar Problems (M) Encode and Decode Strings
*/
public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i=1;i<n;i++){
            ans=helper(ans);
        }
        return ans;
    }
    public String helper(String ans){
        int count = 0; String next = "";
        for(int i=0;i<ans.length();i++){
            count++;
            if(i+1>=ans.length()){next=next+Integer.toString(count)+ans.charAt(i);}
            else{ 
                if(ans.charAt(i)!=ans.charAt(i+1)){
                    next=next+Integer.toString(count)+ans.charAt(i);
                    count=0;
                }
            }
        }
        return next;
    }
}