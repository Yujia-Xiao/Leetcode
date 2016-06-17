/*
Gray Code My Submissions QuestionEditorial Solution
Total Accepted: 63010 Total Submissions: 170431 Difficulty: Medium
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

Hide Company Tags Amazon
Hide Tags Backtracking
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList<Integer>();
        if(n==0){ans.add(0);return ans;}
        backtrack(ans,0,n);
        return ans;
    }
    
    public void backtrack(List<Integer> ans, int now,int n){
        if(now==n)return;
        else{
            if(ans==null || ans.size()==0){
                ans.add(0);ans.add(1);
            }
            else{
                int high = (int)Math.pow(2,now);
                for(int i=ans.size()-1;i>=0;i--){
                    ans.add(high+ans.get(i));
                }
            }
            backtrack(ans,now+1,n);
        }
    }
}