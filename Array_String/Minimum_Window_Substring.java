/*
76. Minimum Window Substring  QuestionEditorial Solution  My Submissions
Total Accepted: 71274
Total Submissions: 315982
Difficulty: Hard
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

Hide Company Tags LinkedIn Uber Facebook
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Substring with Concatenation of All Words (M) Minimum Size Subarray Sum (H) Sliding Window Maximum
*/
public class Solution {
    public String minWindow(String s, String t) {   
        Map<Character,Integer> map = new HashMap<Character,Integer>();    
        for (char ch : t.toCharArray()){
            if(!map.containsKey(ch))map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
        }
        int len = t.length();

        String res = "";
        int left = 0, min = Integer.MAX_VALUE;         
        for (int i = 0; i < s.length(); i++){// sliding window: left, right(i);
            char tem = s.charAt(i);
            if(map.containsKey(tem)){
                map.put(tem,map.get(tem)-1);
                if(map.get(tem)>=0)len--;
            }
            while(len==0 && left<=i){
                tem = s.charAt(left);
                if(map.containsKey(tem) && map.get(tem)==0){
                    break;
                }else if(map.containsKey(tem) && map.get(tem)<0){
                    left++;
                    map.put(tem,map.get(tem)+1);
                }else{left++;}
            }
            if(len==0 && min>i-left+1){
                min=i-left+1;
                res=s.substring(left,i+1);
            }
        }
        
        return res;
    }
    
}