/*
Shortest Word Distance II 
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (E) Merge Two Sorted Lists (E) Shortest Word Distance (M) Shortest Word Distance III
*/
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class WordDistance {

    private Map<String, List<Integer>> ans = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
        for (int i=0;i<words.length;i++){
            if(ans.containsKey(words[i])){
                ans.get(words[i]).add(i);
            }
            else{
                List<Integer> mlist = new ArrayList<Integer>();
                mlist.add(i);
                ans.put(words[i],mlist);
            }
        }
        
    }

    public int shortest(String word1, String word2) {
        List<Integer> mlist1 = ans.get(word1);
        List<Integer> mlist2 = ans.get(word2);
        int dis = Integer.MAX_VALUE;//not the length of the list
        for(int i=0;i<mlist1.size();i++){
            for(int j=0;j<mlist2.size();j++){
                dis = Math.min(dis,Math.abs(mlist1.get(i)-mlist2.get(j)));
            }
        }
        return dis;
        
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
