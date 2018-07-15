/*
Generalized Abbreviation 
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Hide Company Tags Google
Hide Tags Backtracking Bit Manipulation
Hide Similar Problems (M) Subsets (E) Unique Word Abbreviation
*/
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        int maxLen = 1<<word.length();
        for(int i=0;i<maxLen;i++){
            result.add(getString(i,word));
        }
        return result;
    }
    public String getString(int num,String word){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0;i<word.length();i++){
            int bit = (num>>i)&1;
            if(bit==1){
                if(count!=0){
                    sb.append(count);
                    count = 0;
                }
                sb.append(word.charAt(i));
            }
            else{
                count+=1;
            }
        }
        if(count!=0) sb.append(count);
        return sb.toString();
    }
}