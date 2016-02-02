/*
Sparse Matrix Multiplication My Submissions Question
Total Accepted: 3302 Total Submissions: 7067 Difficulty: Medium
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
Hide Company Tags LinkedIn
Hide Tags Hash Table
*/
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int A_Rows = A.length, A_Columns = A[0].length, B_Columns = B[0].length;
        int[][] C = new int[A_Rows][B_Columns];
        for (int i = 0; i < A_Rows; i++)// 
            for (int j = 0; j < A_Columns; j++) {
                if (A[i][j] == 0)
                    continue;
                for (int k = 0; k < B_Columns; k++) {
                    if (B[j][k] == 0)
                        continue;
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        return C;
    }
}