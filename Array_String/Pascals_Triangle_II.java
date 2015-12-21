/*
Pascal's Triangle II
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

Hide Tags Array
Hide Similar Problems (E) Pascal's Triangle
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<Integer>();
        if(rowIndex<0)return ans;
        ans.add(1);
        for(int i=1;i<=rowIndex;i++){
            int previousJ = 1;
            for(int j=1;j<i;j++){
                int currentJ =ans.get(j);
                ans.set(j,ans.get(j)+previousJ);
                previousJ=currentJ;
            }
            ans.add(1);
        }
        return ans;
    }
}