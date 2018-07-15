/*
Evaluate Reverse Polish Notation 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Hide Company Tags LinkedIn
Hide Tags Stack
Hide Similar Problems (M) Basic Calculator (H) Expression Add Operators
*/
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0)return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            //assume the tokens is a correct reverse polish notation
            if(tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }
            else if(tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);                
            }
            else if(tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);                
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);                
            }
            else {
                System.out.println(tokens[i]);
                stack.push(Integer.parseInt(tokens[i]));}
        }
        return stack.pop();
    }
}