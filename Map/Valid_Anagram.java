/*
Valid Anagram 
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Hide Company Tags Amazon
Hide Tags Hash Table Sort
Hide Similar Problems (M) Group Anagrams (E) Palindrome Permutation
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer> comMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(comMap.containsKey(s.charAt(i)))comMap.put(s.charAt(i),comMap.get(s.charAt(i))+1);
            else comMap.put(s.charAt(i),1);
        }
        for(int i=0;i<t.length();i++){
            if(comMap.containsKey(t.charAt(i))){
                if(comMap.get(t.charAt(i))==1)comMap.remove(t.charAt(i));
                else comMap.put(t.charAt(i),comMap.get(t.charAt(i))-1);
            }
            else return false;
        }
        if(comMap.isEmpty())return true;
        return false;
    }
}