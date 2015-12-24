/*
Shortest Word Distance III
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Array
Hide Similar Problems (E) Shortest Word Distance (M) Shortest Word Distance II
*/
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words.length < 2) {
            return 0;
        }
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
            }
            if(index1 != -1 && index2 != -1 && index1 != index2){
                min = Math.min(min, Math.abs(index1 - index2));
            }
            if(words[i].equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1 && index1 != index2){
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}