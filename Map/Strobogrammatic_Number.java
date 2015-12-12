*/
Strobogrammatic
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.

Hide Company Tags Google
Hide Tags Hash Table Math
Hide Similar Problems (M) Strobogrammatic Number II (H) Strobogrammatic Number III
*/
public class Solution {
    public boolean isStrobogrammatic(String num) {
         if(num == null || num.length() == 0) {
            return true;
        }        
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
         
        int lo = 0;
        int hi = num.length() - 1;
         
        while (lo <= hi) {
            char c1 = num.charAt(lo);
            char c2 = num.charAt(hi);            
            if (!map.containsKey(c1) || map.get(c1) != c2) {
                return false;
            }            
            lo++;
            hi--;
        }        
        return true;        
    }
}