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

//7/27/2018
class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0 )return true;
        if( s.length()%2!=0) return false;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==')'){
                if(stack.peek()=='(')stack.pop();
                else return false;
            }
            else if(arr[i]==']'){
                if(stack.peek()=='[')stack.pop();
                else return false;
            }
            else if(arr[i]=='}'){
                if(stack.peek()=='{')stack.pop();
                else return false;
            }
            else stack.push(arr[i]);
        }
        return (stack.size()==0);
    }
}