/*
Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Hide Company Tags LinkedIn
*/
public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    Set<String> reached = new HashSet<String>();
    reached.add(beginWord);
    wordDict.add(endWord);
    int distance = 1;
    while(!reached.contains(endWord)) {
        Set<String> toAdd = new HashSet<String>();
        for(String each : reached) {
            for (int i = 0; i < each.length(); i++) {
                char[] chars = each.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);
                    if(wordDict.contains(word)) {
                        toAdd.add(word);
                        wordDict.remove(word);
                    }
                }
            }
        }
        distance ++;
        if(toAdd.size() == 0) return 0;
        reached = toAdd;
    }
    return distance;
}
}


public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

       Set<String> reachedDict = new HashSet<String>();
       wordDict.add(endWord);
       reachedDict.add(beginWord);
       int num = 1;
       while(!reachedDict.contains(endWord)){
           Set<String> reachTemp = new HashSet<String>();
           for(String str:reachedDict){
               for(int i=0;i<str.length();i++){
                for(char a = 'a';a<='z';a++){
                    char[] ch = str.toCharArray();
                    ch[i]=a;
                    //String rr = ch.toString();
                    //System.out.println(rr);
                    String temp = new String(ch);
                   // System.out.println(temp);
                    if(wordDict.contains(temp)){
                        reachTemp.add(temp);
                        wordDict.remove(temp);
                    }
                 }                   
               }
           }
           num++;
           if(reachTemp.size()==0)return 0;
           reachedDict=reachTemp;
       }
       return num;
   }
}