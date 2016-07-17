/*
120. Triangle  QuestionEditorial Solution  My Submissions
Total Accepted: 74924
Total Submissions: 242692
Difficulty: Medium
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Hide Tags Array Dynamic Programming
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0)==null)return 0;
        int ans = triangle.get(0).get(0);
        List<Integer> lastList = triangle.get(triangle.size()-1);
        int[] temArray = new int[lastList.size()];
        for(int i=0;i<lastList.size();i++){
            temArray[i]=lastList.get(i);
        }
        
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> tem = triangle.get(i);
            for(int j=0;j<tem.size();j++){
                temArray[j]=Math.min(temArray[j],temArray[j+1])+tem.get(j);
            }
            if(i==0)ans=temArray[0];
        }
        return ans;   
    }
}