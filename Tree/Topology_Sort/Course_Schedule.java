/*
Course Schedule
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hide Company Tags Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
Hide Similar Problems (M) Course Schedule II (M) Graph Valid Tree (M) Minimum Height Trees
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological sort, save the edges relationship -> calculate the prerequisite -> find 0, adjest the list
        //end: if can not find prerequisite = 0  and still nodes -> false ; else true;
        //list<Set<Integer>>
        if(numCourses==0 || numCourses==1){return true;}
        List<Set<Integer>> adjacency = new ArrayList<Set<Integer>>();
        for(int i=0;i<numCourses;i++){
            Set<Integer> adja = new HashSet<Integer>();
            adjacency.add(adja);
        } //initialization
        
        for(int i=0;i<prerequisites.length;i++){
            adjacency.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] preNum = new int[numCourses];
        for(int i=0;i<adjacency.size();i++){
            Iterator<Integer> iterator = adjacency.get(i).iterator();
            while(iterator.hasNext()){
                preNum[iterator.next()]++;
            }
        }
        
        for(int i=0;i<numCourses;i++){
            //try to remove all the nodes
            //but can return in the middle
            int j=0;
            for(;j<numCourses;j++){
                if(preNum[j]==0){break;}
            }
            
            if(j==numCourses){return false;}
            
            preNum[j]=-1;
            
            Iterator<Integer> temp = adjacency.get(j).iterator();
            while(temp.hasNext()){
                preNum[temp.next()]--;
            }   
        }        
        return true;        
    }
}