/*
133. Clone Graph My Submissions QuestionEditorial Solution
Total Accepted: 68462 Total Submissions: 275234 Difficulty: Medium
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Hide Company Tags Pocket Gems Google Uber Facebook
Hide Tags Depth-first Search Breadth-first Search Graph
Hide Similar Problems (H) Copy List with Random Pointer
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)return null;
        Map<Integer,UndirectedGraphNode> visited = new HashMap<Integer,UndirectedGraphNode>();
        return dfs(node,visited);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> visited){
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        visited.put(ans.label,ans);
        for(UndirectedGraphNode n : node.neighbors){
            if(visited.containsKey(n.label)){ans.neighbors.add(visited.get(n.label));}
            else ans.neighbors.add(dfs(n,visited));
        }
        return ans;
    }
    
}