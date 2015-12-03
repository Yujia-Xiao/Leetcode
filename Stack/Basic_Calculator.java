/*
Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.

Hide Company Tags Google
Hide Tags Stack Math
Hide Similar Problems (M) Evaluate Reverse Polish Notation (M) Basic Calculator II (M) Different Ways to Add Parentheses (H) Expression Add Operators
*/
public class Solution {
    
    private Stack<String> st = new Stack<String>();
    public int calculate(String s) {
        int ans = 0;
        if(s==null || s.length()==0){return ans;}
        //space, do nothing
        //1 ,first peek, + pop pop int plus and push;- pop pop int minus and push;( push  *number may be 2 digits
        //+ push; )==num;num;
        //- push; ) ;num
        //( ;+;-;push
        //) pop int pop ( push int
        //end condition: num 
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==' ' && i<s.length()){i++;}
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='('){
                st.push(s.substring(i,i+1));
                i++;
            }
            else if(s.charAt(i)==')' && i<s.length()){
                String str = st.pop();
                st.pop(); //(
                popnum(str);
                i++;
            }
            else if (i<s.length()){
                String temNum = "";
                
                while(i<s.length() && s.charAt(i)!='+' && s.charAt(i)!='-' && s.charAt(i)!='(' && s.charAt(i)!=')' && s.charAt(i)!=' '){
                    temNum = temNum + s.charAt(i);
                    i++; 
                    //when break, ith is added and i++ is not added
                }
                popnum(temNum);
                
            }
        }
        ans = Integer.valueOf(st.pop());
        return ans;
    }
    
    public void popnum(String num){
        if(st.empty()){st.push(num);}
        else{
            if(st.peek().equals("+") || st.peek().equals("-")){
                String operator = st.pop();
                String numBefore = st.pop();
                int temNum = 0;
                if(operator.equals("+")){temNum = Integer.valueOf(numBefore)+Integer.valueOf(num);}
                if(operator.equals("-")){temNum = Integer.valueOf(numBefore)-Integer.valueOf(num);}
                numBefore = temNum+"";
                st.push(numBefore);
            }
            else if(st.peek().equals("(")){st.push(num);}
        }
    }
}