/*
Graph Valid Tree 
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Hide Company Tags Google Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Union Find
Hide Similar Problems (M) Course Schedule
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        //typical union-find method
        //if(n<=0 || edges==null || edges.length==0){return false;}
        if(edges.length != n-1){return false;}
        int[] set = new int[n];
        Arrays.fill(set,-1);
        int x = 0;
        int y = 0;
        for(int i=0;i<edges.length;i++){
            x=find(set,edges[i][0]);
            y=find(set,edges[i][1]);
            
            if(x == y){return false;}
            
            set[x]=find(set,y); //path compression
        }
        return true;        
    }
    public int find(int[] set, int num){
        if(set[num]==-1){return num;}
        return find(set,set[num]);
    }
}