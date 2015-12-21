/*
Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
Hide Tags Array
Hide Similar Problems (E) Pascal's Triangle II
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();  
        if(numRows==0)return ans;
        List<Integer> MotherLevel = new LinkedList<Integer>();
        for(int i=0;i<numRows;i++){
            List<Integer> CurrentLevel = new LinkedList<Integer>();
            CurrentLevel.add(1);
            for(int j=1;j<i;j++){
                CurrentLevel.add(MotherLevel.get(j-1)+MotherLevel.get(j));
            }
            if(i!=0)CurrentLevel.add(1);
            ans.add(CurrentLevel);
            MotherLevel.clear();
            MotherLevel.addAll(CurrentLevel);
        }
        return ans;
    }
}