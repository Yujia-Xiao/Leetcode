*/
Shortest Word Distance
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Array
Hide Similar Problems (M) Shortest Word Distance II (M) Shortest Word Distance III
*/
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans = 0;
        int w1=0;
        int w2=0;
        int a=0; 
        int b=0;
        for (int i=0;i<words.length;i++){
            if (words[i].equals(word1)){w1=i;a++;}
            if (words[i].equals(word2)){w2=i;b++;}
            
            if(a>0 && b>0 && ans == 0){ans=Math.abs(w1-w2);}
            else {
                if(a>0 && b>0 && ans > Math.abs(w1-w2)){ans=Math.abs(w1-w2);}
            }
        }
        return ans;
    }
}