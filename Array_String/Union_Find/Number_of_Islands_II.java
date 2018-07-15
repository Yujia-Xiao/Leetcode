/*
305. Number of Islands II My Submissions QuestionEditorial Solution
Total Accepted: 6665 Total Submissions: 19208 Difficulty: Hard
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

Hide Company Tags Google
Hide Tags Union Find
Hide Similar Problems (M) Number of Islands
*/
public class Solution{
    
    public int[][][] grid;int num=0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<Integer>();
        grid = new int[m][n][2];//rank and representative
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                grid[i][j][0]=-1;
                grid[i][j][1]=1;
            }
        for(int i=0;i<positions.length;i++){
            int a = positions[i][0];
            int b = positions[i][1];
            grid[a][b][0]=a*n+b;num++;
            if(a>0 && grid[a-1][b][0]!=-1)union(a,b,a-1,b);
            if(a<m-1 && grid[a+1][b][0]!=-1)union(a,b,a+1,b);
            if(b>0 && grid[a][b-1][0]!=-1)union(a,b,a,b-1);
            if(b<n-1 && grid[a][b+1][0]!=-1)union(a,b,a,b+1);
            int toAdd = num;
            ans.add(toAdd);
        }
        return ans;
    }
    
    public int union(int i,int j,int a, int b){
    //rank
        int repre1 = find(i,j);
        int repre2 = find(a,b);
        if(repre1==repre2)return num;
        int m = grid[0].length;
        int rank1 = grid[repre1/m][repre1%m][1];
        int rank2 = grid[repre2/m][repre2%m][1];
        if(rank1>rank2){
            grid[repre1/m][repre1%m][1]++;
            grid[repre2/m][repre2%m][0]=repre1;
        }
        else{
            grid[repre2/m][repre2%m][1]++;
            grid[repre1/m][repre1%m][0]=repre2;
        }
        return num--;
    }
    
    public int find(int i,int j){
    //path compression
        int n = grid[0].length;
        int repre = grid[i][j][0];
        if(repre!=i*n+j){
            grid[i][j][0]=find(repre/n,repre%n);
        }
        return grid[i][j][0];
    }
}


//07/11/2018
class Solution {
    public int[][][] grid; 
    int num = 0; // This is the answer
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<Integer>();
        grid = new int[m][n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j][0] = -1; // -1 means there is no '1'
                grid[i][j][1] = 1; //rank
            }
        }
        
        for(int i=0;i<positions.length;i++){
            num++;// will cancel this if there is any merge
            int a = positions[i][0];
            int b = positions[i][1];
            
            grid[a][b][0] = a*n+b;
            
            if(a>0 && grid[a-1][b][0] != -1)union(a-1, b, a, b);
            if(a<m-1 && grid[a+1][b][0] != -1)union(a+1, b, a, b);
            if(b>0 && grid[a][b-1][0] != -1)union(a, b-1, a, b);
            if(b<n-1 && grid[a][b+1][0] != -1)union(a, b+1, a, b);
            
            ans.add(num);
        }
        
        return ans;
    }
    
    public void union(int a, int b, int i, int j){
        
        int repreA = find(a,b);
        int repreB = find(i,j);
        
        if(repreA==repreB)return;
        int m = grid[0].length;
        
        int rankA = grid[repreA/m][repreA%m][1];
        int rankB = grid[repreB/m][repreB%m][1];
        
        if(rankA > rankB){
            grid[repreA/m][repreA%m][1]++;
            grid[repreB/m][repreB%m][0] = repreA;
        }else{
            grid[repreB/m][repreB%m][1]++;
            grid[repreA/m][repreA%m][0] = repreB;
        
        }
        
        num--;
        
        return;
    }
     
    public int find(int i, int j){
        int m = grid[0].length;
        int repre = grid[i][j][0];
        if(repre!=i*m+j)grid[i][j][0] = find(repre/m, repre%m);
        return grid[i][j][0];
    }
    
}