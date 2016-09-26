/*
296. Best Meeting Point  QuestionEditorial Solution  My Submissions
Total Accepted: 5914
Total Submissions: 12274
Difficulty: Hard
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?
Hide Company Tags Twitter
Hide Tags Math Sort
Hide Similar Problems (H) Shortest Distance from All Buildings
*/
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> I = new ArrayList<>(m);
        List<Integer> J = new ArrayList<>(n);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    I.add(i);
                    J.add(j);
                }
            }
        }
        
        return getMin(I) + getMin(J);
    }
    
    private int getMin(List<Integer> list){
        int ret = 0;
        
        Collections.sort(list);
        
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            ret += list.get(j--) - list.get(i++);
        }
        
        return ret;
    }
}