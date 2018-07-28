/*
Minimum Window Substring 
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

Hide Company Tags LinkedIn Facebook
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Substring with Concatenation of All Words (M) Minimum Size Subarray Sum (H) Sliding Window Maximum
*/

public class Solution {
    boolean sContainsT(int mapS[], int mapT[]) {// Runtime = O(256) = O(1)
        for (int i = 0; i < mapT.length; i++) {// s should cover all characters in t
            if (mapT[i] > mapS[i])
                return false; 
        }           
        return true;
    }

    public String minWindow(String s, String t) {   
        int mapS[] = new int[256];// Count characters in s
        int mapT[] = new int[256];// Count characters in t      
        for (char ch : t.toCharArray())
            mapT[ch]++;

        String res = "";
        int right = 0, min = Integer.MAX_VALUE;         
        for (int i = 0; i < s.length(); i++) {// Two pointers of the sliding window: i(left), right
            while (right < s.length() && !sContainsT(mapS, mapT)) {// Extend the right pointer of the sliding window
                mapS[s.charAt(right)]++;
                right++;
            }
            if (sContainsT(mapS, mapT) && min > right - i + 1) {
                res = s.substring(i, right);
                min = right - i + 1;
            }
            mapS[s.charAt(i)]--;// Shrink the left pointer from i to i + 1
        }
        return res;
    }
}


//7/25/2018
class Solution {
    public String minWindow(String s, String t) {
        //Have string s. find the minimal length substring which contains all chars in string t.
        /*sliding window: 
            i:0 -> s.length()-1    , i++, O(n)
            left: updated to the max as i move.   int[]:we know the position
            update ansStr each time as i move when len of substring[left,i] is less then ans 
        //dynamically know if substring of s contains all char of t
        
        */
        int[] map = new int[123]; //A:65, 90, a:97, 122
        boolean[] mapKey = new boolean[123]; // to see if the 
        for(char ch: t.toCharArray()){map[ch]++;mapKey[ch]=true;}
        
        int count = t.length(); 
        int left=0;
        int head = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char tem = s.charAt(i);
            if(mapKey[tem]){//adjest count due to i update
                map[tem]--;
                if(map[tem]>=0)count--;
            }
            while(count==0 && left<i){ // substring[left,i] has all the char needed
                char l = s.charAt(left);
                if(mapKey[l] && map[l]==0)break;//do not update left
                if(mapKey[l] && map[l]<0){map[l]++;}
                left++; //update left
            }
            if(count==0 && min>i-left+1){
                    min=i-left+1;
                    head=left;
            }
        }
        System.out.println(head);
        return (min==Integer.MAX_VALUE) ? "" : s.substring(head,head+min);
    }
}