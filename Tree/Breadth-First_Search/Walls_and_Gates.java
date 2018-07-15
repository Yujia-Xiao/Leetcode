/*
Walls and Gates 
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Hide Company Tags Facebook
Hide Tags Breadth-first Search
Hide Similar Problems (M) Surrounded Regions (M) Number of Islands (H) Shortest Distance from All Buildings
*/
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)bfs(i,j,rooms);
            }
        }
        return;
    }
    public void bfs(int i, int j, int[][]rooms){
        int path = rooms[i][j];
        int[][] ad = {{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
        for(int n=0;n<ad.length;n++){
            if(ad[n][0]>-1 && ad[n][0]<rooms.length && ad[n][1]>-1 && ad[n][1]<rooms[0].length){
                int num=rooms[ad[n][0]][ad[n][1]];
                if(num!=-1 && num!=0){
                    if(path+1<num){
                    	rooms[ad[n][0]][ad[n][1]]=path+1;
                    	bfs(ad[n][0],ad[n][1],rooms);
                    }
                }
            }
        }
        return;
    }
}