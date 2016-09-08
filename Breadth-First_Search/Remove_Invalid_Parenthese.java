/*
301. Remove Invalid Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 19068
Total Submissions: 56625
Difficulty: Hard
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
Credits:
Special thanks to @hpplayer for adding this problem and creating all test cases.

Hide Company Tags Facebook
Hide Tags Depth-first Search Breadth-first Search
Hide Similar Problems (E) Valid Parentheses
*/
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
    /*
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new LinkedList<String>();
        if(s==null || s.length()==0)return ans;
        List<Set<String>> tem = new LinkedList<Set<String>>();
        List<Integer> left = new LinkedList<Integer>();
        List<Integer> right = new LinkedList<Integer>();
        int start=0; int last=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')left.add(i);
            else if(s.charAt(i)==')')right.add(i);
            if(right.size()>left.size()){
                Set<String> segment = new HashSet<String>();
                for(int temInt:right){
                    String temStr=s.substring(start,temInt)+s.substring(temInt+1,i+1);
                    segment.add(temStr);
                }
                tem.add(segment);
                start=i+1;
                last=i;
                left = new LinkedList<Integer>();
                right = new LinkedList<Integer>();
            }
        }
        if(last!=s.length()-1){
            Set<String> segment = new HashSet<String>();
            if(right.size()==left.size())segment.add(s.substring(start,s.length()));
            else{
                String tail = s.substring(start,s.length());
                List<String> list = removeInvalidParentheses(new StringBuilder(tail).reverse().toString());
                for(String temStr:list)segment.add(new StringBuilder(temStr).reverse().toString());
            }
            tem.add(segment);
        }
        
        
        backtrack(ans,tem,"",0);
        return ans;
    }
    
    public void backtrack(List<String> ans, List<Set<String>> tem, String cul, int level){
        if(level>=tem.size()){
            ans.add(cul);
            return;
        }
        for(String str:tem.get(level)){
            cul+=str;
            backtrack(ans,tem,cul,level+1);
            cul=cul.substring(0,cul.length()-str.length());
        }
        return;
    } */
}