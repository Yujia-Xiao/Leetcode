/*
Palindrome Permutation 
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
Hide Company Tags Google Uber
Hide Tags Hash Table
Hide Similar Problems
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {       
        if (s == null || s.length() <= 1) {
            return true;
        }        
        Map<Character, Integer> map = new HashMap<Character, Integer>();        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
             
            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }        
        int tolerance = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
             
            if ((int) pair.getValue() % 2 != 0) {
                tolerance++;
            }
        }         
        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }       
    }
}