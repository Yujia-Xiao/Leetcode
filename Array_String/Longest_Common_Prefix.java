/*
Longest Common Prefix My Submissions Question
Total Accepted: 78222 Total Submissions: 293367 Difficulty: Easy
Write a function to find the longest common prefix string amongst an array of strings.

Hide Tags String
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prifex = ""; int j = 0; boolean conti = true;
        if(strs==null || strs.length==0)return prifex;
        while(conti){
            if(strs[0].length()<j+1)break;
            char current = strs[0].charAt(j);
            conti = true;
            for(int i=1;i<strs.length;i++){
                if(strs[i].length()<j+1 || strs[i].charAt(j)!=current){conti=false;break;}
            }
            if(conti)prifex+=current;
            j++;
        }
        return prifex;
    }
}