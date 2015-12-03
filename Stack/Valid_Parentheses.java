/*
Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Hide Company Tags Amazon Google
Hide Tags Stack String
Hide Similar Problems (M) Generate Parentheses (H) Longest Valid Parentheses (H) Remove Invalid Parentheses
*/
public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0){return true;}
        if(s.length()%2 == 1){return false;}
        // use stack;
        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));
        int i=1;

        while(i<s.length()){ 
            if(s.charAt(i) == ')'){
               if(st.peek() == '('){st.pop();}
               else{st.push(s.charAt(i));}
            }
            else if(s.charAt(i) == ']'){
               if(st.peek() == '['){st.pop();}
               else{st.push(s.charAt(i));}
            }
            else if(s.charAt(i) == '}'){
               if(st.peek() == '{'){st.pop();}
               else{st.push(s.charAt(i));}
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
        //after travesal of every char in this string
        if(st.empty()){return true;}
        else{return false;}        
    }
}