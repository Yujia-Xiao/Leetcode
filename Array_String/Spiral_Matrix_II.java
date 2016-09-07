/*
59. Spiral Matrix II  QuestionEditorial Solution  My Submissions
Total Accepted: 61964
Total Submissions: 169057
Difficulty: Medium
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
Hide Tags Array
Hide Similar Problems (M) Spiral Matrix
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int ms=0; int me = n-1;
        int ns=0; int ne = n-1;
        int num = 1;
        while(ms<me && ns<ne){
            for(int i=ns;i<ne;i++){matrix[ms][i]=num;num++;}
            for(int i=ms;i<me;i++){matrix[i][ne]=num;num++;}
            for(int i=ne;i>ns;i--){matrix[me][i]=num;num++;}
            for(int i=me;i>ms;i--){matrix[i][ns]=num;num++;}
            ns++;ne--;
            ms++;me--;
        }
        if(ms==me)for(int i=ns;i<=ne;i++){matrix[ms][i]=num;num++;}
        else if(ns==ne)for(int i=ms;i<=me;i++){matrix[i][ns]=num;num++;}
        return matrix;        
    }
}

public int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    int count = 1, i = 0;
    for (; i < n>>1; i++) { // Spiral print
        for (int j = i; j < n-i-1; j++) ans[i][j] = count++;
        for (int j = i; j < n-i-1; j++) ans[j][n-i-1] = count++;
        for (int j = n-i-1; j > i; j--) ans[n-i-1][j] = count++;
        for (int j = n-i-1; j > i; j--) ans[j][i] = count++;
    }
    // Case when there is just one element in the innermost layer
    if (i<<1 == n-1) ans[i][i] = count;
    
    return ans;
}