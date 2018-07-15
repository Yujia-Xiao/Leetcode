/*
Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Credits:
Special thanks to @minglotus6 for adding this problem and creating all test cases.

Hide Company Tags Dropbox
Hide Tags Hash Table
Hide Similar Problems (E) Isomorphic Strings (H) Word Pattern II
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        //for(String p:s)System.out.println(p);
        if(pattern.length()!=s.length)return false;
        Map<Character,String> map = new HashMap<Character,String>();
        Map<String,Character> map2 = new HashMap<String,Character>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(s[i]))return false;
            }
            else map.put(pattern.charAt(i),s[i]);
            
            if(map2.containsKey(s[i])){
                if(map2.get(s[i])!=pattern.charAt(i))return false;
            }
            else map2.put(s[i],pattern.charAt(i));
        }
        return true;
    }
}