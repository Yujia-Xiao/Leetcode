/*
344. Reverse String My Submissions QuestionEditorial Solution
Total Accepted: 32717 Total Submissions: 55756 Difficulty: Easy
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Hide Tags Two Pointers String
Hide Similar Problems (E) Reverse Vowels of a String
*/
public class Solution {
    public String reverseString(String s) {
        if(s==null)return null;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length/2;i++){
            int last=arr.length-1-i;
            System.out.println(arr[i]+"  "+arr[last]);
            char temp = arr[i];
            arr[i]=arr[last];
            arr[last]=temp;
        }
        String ans=new String(arr);//do not use arr.toString, it will return an address
        return ans;
    }
}