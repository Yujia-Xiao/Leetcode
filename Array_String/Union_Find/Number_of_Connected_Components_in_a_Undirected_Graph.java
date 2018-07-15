/*
Number of Connected Components in an Undirected Graph My Submissions QuestionEditorial Solution
Total Accepted: 7928 Total Submissions: 18433 Difficulty: Medium
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Hide Company Tags Google
Hide Tags Depth-first Search Breadth-first Search Graph Union Find
Hide Similar Problems (M) Number of Islands (M) Graph Valid Tree
*/
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length==0)return n;
        
        int[] repre = new int[n];
        for(int i=0;i<repre.length;i++)repre[i]=i;
        
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            merge(x,y,repre);
        }
        
        int count = 1;
        Arrays.sort(repre);
        for(int i=1;i<repre.length;i++){
            if(repre[i]!=repre[i-1])count++;
        }
        return count;
    }
    
    public int find(int x,int[] repre){
        return repre[x];
    }
    public void merge(int x, int y,int[] repre){
        int reX = find(x,repre);
        int reY = find(y,repre);
        for(int i=0;i<repre.length;i++){
            if(repre[i]==reX)repre[i]=reY;
        }
    }
}