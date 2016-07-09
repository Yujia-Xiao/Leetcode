/*
159. Longest Substring with At Most Two Distinct Characters  QuestionEditorial Solution  My Submissions
Total Accepted: 13460
Total Submissions: 37417
Difficulty: Hard
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.

Hide Company Tags Google
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (M) Longest Substring Without Repeating Characters (H) Sliding Window Maximum (H) Longest Substring with At Most K Distinct Characters
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start=0;
        int max=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char z = s.charAt(i);
            if(!map.containsKey(z)){
                //map.put(z,Arrays.asList(i)); as List will creat static List --> only can be used when adding the answer;
                if(map.size()==2){
                    List<Character> tem = new ArrayList<Character>(map.keySet());
                    char key = (map.get(tem.get(0)) < map.get(tem.get(1)))? tem.get(0):tem.get(1);
                    start=map.get(key)+1;
                    map.remove(key);
                    map.put(z,i);  
                }else{
                    map.put(z,i);   
                }
            }else{
                map.put(z,i);
            }
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}