/*
210. Course Schedule II  QuestionEditorial Solution  My Submissions
Total Accepted: 37592
Total Submissions: 160815
Difficulty: Medium
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
Have you met this question in a real interview? Yes  */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0){return new int[0];}
        int[] ans = new int[numCourses];
        
        Map<Integer,Set<Integer>> adjacency = new HashMap<Integer,Set<Integer>>();
        int[] preNum = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int cul = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(!adjacency.containsKey(pre))adjacency.put(pre,new HashSet<Integer>());
            boolean tem = adjacency.get(pre).add(cul);
            if(tem)preNum[cul]++;
        }
        
        for(int i=0;i<numCourses;i++){//try to remove all the nodes,but can return in the middle
            int j=0;
            for(;j<numCourses;j++){
                if(preNum[j]==0){break;}
            }
            if(j==numCourses){return new int[0];}
            preNum[j]=-1;
            ans[i]=j;

            for(int tem:adjacency.getOrDefault(j,new HashSet<Integer>()))preNum[tem]--;
        }
        return ans;
    }
}
