/*
28. Implement strStr()  QuestionEditorial Solution  My Submissions
Total Accepted: 126643
Total Submissions: 486771
Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Hide Company Tags Pocket Gems Microsoft Apple Facebook
Hide Tags Two Pointers String
Hide Similar Problems (H) Shortest Palindrome
*/

public class Solution {
    public int strStr(String target, String source) {
        if(source.equals("")) return 0;
        if(target.equals("")) return -1;
        int sourceLength = source.length();  
        int targetLength = target.length();  
        int[] result = preProcess(source);  
        int j = 0;  
        int k = 0;  
        for(int i=0;i<targetLength;i++){  
            while(j>0 && source.charAt(j) != target.charAt(i))
                j = result[j-1];  
            if(source.charAt(j) == target.charAt(i))  
                j++;  
            if(j == sourceLength){  
                j = result[j-1];  
                k++;  
                System.out.println("find"); 
                return i-sourceLength+1;
            }  
        }
        return -1;
    }
    
    public int[] preProcess(final String s) {  
      int size = s.length();  
      int[] result = new int[size];  
      int j = 0;  
      for(int i=1;i<size;i++){  
          while(j>0 && s.charAt(j) != s.charAt(i)) 
              j = result[j-1];  
          if(s.charAt(j) == s.charAt(i))
              j++;  
          result[i] = j;  
      }  
      return result;  
    } 
}