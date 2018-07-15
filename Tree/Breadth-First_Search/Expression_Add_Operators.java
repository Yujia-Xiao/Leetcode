/*
Expression Add Operators 
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
Credits:
Special thanks to @davidtan1890 for adding this problem and creating all test cases.
Hide Company Tags Google Cryptic Studios
Hide Tags Divide and Conquer
Hide Similar Problems (M) Evaluate Reverse Polish Notation (M) Basic Calculator (M) Basic Calculator II (M) Different Ways to Add Parentheses
*/
public class Solution {
    List<String> result =new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        for(int i=1;i<=num.length();i++){
            if(i>=2 && num.charAt(0)=='0') continue;
            bfs(num.substring(i),num.substring(0,i),target,0,Long.parseLong(num.substring(0,i)),true);
        }
        return result;
    }

    public void bfs(String s,String trace,int target,long pre,long current,boolean sign){
        long sum = sign? pre+current:pre-current;
        if(s.length()==0){
            if(sum==(long) target) result.add(trace);
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(i>=2 && s.charAt(0)=='0') continue;
            int number = Integer.parseInt(s.substring(0,i));
            bfs(s.substring(i),trace+"+"+number,target,sum,number,true);
            bfs(s.substring(i),trace+"-"+number,target,sum,number,false);
            bfs(s.substring(i),trace+"*"+number,target,pre,current*number,sign);
        }
    }
}