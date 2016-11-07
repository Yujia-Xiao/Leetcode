
/*
424. Longest Repeating Character Replacement   QuestionEditorial Solution  My Submissions
Total Accepted: 358
Total Submissions: 1279
Difficulty: Medium
Contributors: Admin
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
Hide Company Tags Pocket Gems
*/
//TLE
public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,List<Integer>> indexMap = new HashMap<Character,List<Integer>>();
        for(int i=0;i<s.length();i++){
            char tem = s.charAt(i);
            if(!indexMap.containsKey(tem))indexMap.put(tem,new LinkedList<Integer>());
            indexMap.get(tem).add(i);
        }
        int ans = 0;
        for(List<Integer> temList : indexMap.values()){
            int temAns = helper(temList,k);
            temAns=(temAns>s.length())?s.length():temAns;
            if(temAns>ans)ans=temAns;
        }
        return ans;
    }
    public int helper(List<Integer> list, int k){//sliding window
        int s = 0;
        int ans = k+1;
        int UsedK = 0;
        for(int i=1;i<list.size();i++){//move right side
            UsedK+=list.get(i)-list.get(i-1)-1;
            while(UsedK>k && s<i){//move left side
                s++;
                UsedK-=list.get(s)-list.get(s-1)-1;
            }
            ans=Math.max(list.get(i)-list.get(s)+1+(k-UsedK),ans);
        }

        return ans;
    }
}

public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int j = 0;
        int i = 0;
        int[] cnt = new int[26];
        int maxCnt = 0;
        int maxLen = 0;
        while (i < s.length()) {
            if (cnt[s.charAt(i) - 'A']++ >= maxCnt) maxCnt = cnt[s.charAt(i) - 'A'];
            while (i - j + 1 - maxCnt > k) {
                if (cnt[s.charAt(j++) - 'A']-- == maxCnt) {
                    maxCnt--;
                    for (int l = 0; l < 26; l++) {
                        if (cnt[l] > maxCnt)
                            maxCnt = cnt[l];
                    }
                }
            }
            maxLen = Math.max(maxLen, i - j + 1);
            i++;
        }
        return maxLen;
    }
}