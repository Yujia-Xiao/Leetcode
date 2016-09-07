/*
54. Spiral Matrix  QuestionEditorial Solution  My Submissions
Total Accepted: 70859
Total Submissions: 299486
Difficulty: Medium
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Hide Company Tags Microsoft Google Uber
Hide Tags Array
Hide Similar Problems (M) Spiral Matrix II
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>(); //O(n)
        if(matrix==null || matrix.length==0)return ans;
        int ms=0; int me = matrix.length-1;
        int ns=0; int ne =matrix[0].length-1;
        while(ms<me && ns<ne){
            for(int i=ns;i<ne;i++)ans.add(matrix[ms][i]);
            for(int i=ms;i<me;i++)ans.add(matrix[i][ne]);
            for(int i=ne;i>ns;i--)ans.add(matrix[me][i]);
            for(int i=me;i>ms;i--)ans.add(matrix[i][ns]);
            ns++;ne--;
            ms++;me--;
        }
        if(ms==me)for(int i=ns;i<=ne;i++)ans.add(matrix[ms][i]);
        else if(ns==ne)for(int i=ms;i<=me;i++)ans.add(matrix[i][ns]);
        return ans;
    }
}