/*
Minimum Height Trees
Total Accepted: 1610 Total Submissions: 6679 Difficulty: Medium
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?
Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Credits:
Special thanks to @peisi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Breadth-first Search Graph
Hide Similar Problems (M) Course Schedule (M) Course Schedule II
*/

public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if(n<=0) return ans; 
        // a discrete point is a tree with height=0; edges can be null or size of 0
        int[] level = new int[n];
        Integer[] levelPre = new Integer[n];
        Map<Integer, Set<Integer>> adjacency = new HashMap<Integer,Set<Integer>>();
        // it is easier to record the level and the adjacency at the same time
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            level[a]++;
            level[b]++;
            if(adjacency.containsKey(a)){
               adjacency.get(a).add(b);
            }
            else{
                Set<Integer> ad = new HashSet<Integer>();
                ad.add(b);
                adjacency.put(a,ad);
            }
            if(adjacency.containsKey(b)){
               adjacency.get(b).add(a);
            }
            else{
                Set<Integer> ad = new HashSet<Integer>();
                ad.add(a);
                adjacency.put(b,ad);
            }
        }

        int NodeNum = n;
        for(int i=0;i<n;i++){
            if(level[i]==0)ans.add(i);
            levelPre[i]=level[i];
        }
        if(ans!=null && ans.size()!=0){return ans;} //check if there are discreate points, return at middle
        
        while(NodeNum>1){//NodeNumber may be trun to 0 before it is juedges as leaves: [1,3],[2,3] 1--,2--
          //record which node should be removed in each layer, to avoid Concurrent Modification
          List<Integer> currentLayer = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                if(level[i]==1){ //higher order object will change the value of later and influence the results
//                    level[i]=0;
//                    NodeNum--;
//                    Set<Integer> ad = adjacency.get(i);
//                    for(Integer j : ad){
//                        level[j]--;
//                        adjacency.get(j).remove(i);
//                    }
                  currentLayer.add(i);
                }
            }
            for(int i=0;i<currentLayer.size();i++){
              level[currentLayer.get(i)]=0;
              NodeNum--;
              Set<Integer> ad = adjacency.get(currentLayer.get(i));
              for(Integer j : ad){
                  level[j]--;
                  adjacency.get(j).remove(currentLayer.get(i));
              }             
            }
            if(NodeNum>1){
                for(int i=0;i<n;i++){
                    levelPre[i]=level[i];
                }
            }
        }
        
        int max = (int) Collections.max(Arrays.asList(levelPre)); //using Integer[] is great
        for(int i=0;i<n;i++){
            if(levelPre[i]==max) ans.add(i);
        }
        
        return ans;
    }
}