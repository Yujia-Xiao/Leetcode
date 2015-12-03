/*
Course Schedule II 
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hide Company Tags Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
Hide Similar Problems (M) Course Schedule (H) Alien Dictionary (M) Minimum Height Trees
*/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort, save the edges relationship -> calculate the prerequisite -> find 0, adjest the list
        //end: if can not find prerequisite = 0  and still nodes -> false ; else true;
        //list<Set<Integer>>
        int[] ans = new int[0];
        List<Integer> ansList = new ArrayList<Integer>();
        if(numCourses==0){return ans;}
        
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
            
            if(j==numCourses){return ans;}
            
            preNum[j]=-1;
            ansList.add(j);
            
            Iterator<Integer> temp = adjacency.get(j).iterator();
            while(temp.hasNext()){
                preNum[temp.next()]--;
            }
        }        
        int[] newAns = new int[ansList.size()];
        for(int i=0;i<ansList.size();i++){
            newAns[i]=ansList.get(i);
        }
        return newAns;       
    }
}