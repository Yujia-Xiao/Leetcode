/*
Range Sum Query 2D - Mutable My Submissions QuestionEditorial Solution
Total Accepted: 2856 Total Submissions: 13325 Difficulty: Hard
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
Hide Company Tags Google
Hide Tags Binary Indexed Tree Segment Tree
Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable
*/
public class NumMatrix {

        int n = 0;
        int m = 0;    
        int[][] tree;
        int[][] arr;
    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        if(n!=0) m=matrix[0].length;
        
        tree=new int[n+1][m+1];
        arr=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                update(i,j,matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int idx_x=row+1; int idx_y=col+1;
        int dif = val-arr[row][col];
        arr[row][col]=val;
        while(idx_x<=n){
            idx_y=col+1;
            while(idx_y<=m){
                tree[idx_x][idx_y]+=dif;
                idx_y+=idx_y&(-idx_y);
            }
            idx_x+=idx_x&(-idx_x);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (cumRegion(row2,col2)-cumRegion(row1-1,col2)-cumRegion(row2,col1-1)+cumRegion(row1-1,col1-1));
    }
    
    public int cumRegion(int row,int col){
        int idx_x=row+1; int idx_y=col+1;
        int sum = 0;
        while(idx_x>0){
            idx_y=col+1;
            while(idx_y>0){
                sum+=tree[idx_x][idx_y];
                idx_y-=idx_y&(-idx_y);
            }
            idx_x-=idx_x&(-idx_x);
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);