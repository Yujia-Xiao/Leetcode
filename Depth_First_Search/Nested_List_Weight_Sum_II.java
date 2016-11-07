/*
364. Nested List Weight Sum II   QuestionEditorial Solution  My Submissions
Total Accepted: 5674
Total Submissions: 11628
Difficulty: Medium
Contributors: Admin
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

Hide Company Tags LinkedIn
Hide Tags Depth-first Search
Hide Similar Problems (E) Nested List Weight Sum
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int ans = 0;
        List<List<Integer>> levelList = new LinkedList<List<Integer>>();
        dfs(levelList,nestedList,0);
        int level = levelList.size();
        for(int i=0;i<levelList.size();i++){
            for(int temNum:levelList.get(i))ans+=level*temNum;
            level--;
        }
        return ans;
    }
    public void dfs(List<List<Integer>> levelList,List<NestedInteger> nestedList, int index){
        List<Integer> list = new LinkedList<Integer>();
        if(levelList.size()>index)list=levelList.get(index);
        else{
            levelList.add(list);
        }
        
        for(int i=0;i<nestedList.size();i++){
            NestedInteger tem = nestedList.get(i);
            if(tem.isInteger()){
                list.add(tem.getInteger());
            }else{
                dfs(levelList,tem.getList(),index+1);
            }
        }    
    }
}