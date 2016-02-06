/*
Valid Number 
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

Hide Company Tags LinkedIn
Hide Tags Math String
Hide Similar Problems (E) String to Integer (atoi)
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() <= 0) return false;
        s = s.trim();
        if(s.length() == 0 || s.contains(" ")) return false;
        if(s.length() == 1) return isNum(s);
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            s = s.substring(1);
        }
        int len = s.length();
        if(s.contains("e")) {
            int index  = s.indexOf("e");
            if(index == 0 || index == len - 1) return false;
            String part1 = s.substring(0, index);
            String part2 = s.substring(index + 1, len);
            if(part1.contains("e") || part2.contains("e")) return false;
            if(part2.contains(".")) return false;
            return isNumber(part1) && isNumber(part2) ;
        } 
        else if(s.contains(".")) {
            int index  = s.indexOf(".");
            if(index == 0) return isNum(s.substring(index + 1, len));
            if(index == len -1) return isNum(s.substring(0, index));
            String part1 = s.substring(0, index);
            String part2 = s.substring(index + 1, len);
            return isNum(part1) && isNum(part2);
        } 
        return isNum(s);
    }

    public boolean isNum(String s) {
        int len = s.length(); 
        if(len == 0) return false;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; i++) {
            if(! (charArray[i] <= '9' && charArray[i] >= '0')) {
                return false;
            }
        }
        return true;
    }
}
