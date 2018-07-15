/*
The Skyline Problem 
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
Credits:
Special thanks to @stellari for adding this problem, creating these two awesome images and all test cases.

Hide Company Tags Google
Hide Tags Divide and Conquer Heap
*/
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<int[]>();
        if(buildings==null || buildings.length==0) return ans;
        //convert buildings to Edges class
        List<Edges> edges = new ArrayList<Edges>();
        for(int i=0;i<buildings.length;i++){
            Edges start = new Edges(buildings[i][0],buildings[i][2],true);
            Edges end = new Edges(buildings[i][1],buildings[i][2],false);
            edges.add(start);
            edges.add(end);
        }
        
        //sort the Edges class
        Collections.sort(edges,new Comparator<Edges>(){
            public int compare(Edges e1, Edges e2){
                if(e1.index==e2.index){
                    if(e1.isStart) return Integer.compare(e1.height,e2.height);
                    else return Integer.compare(e2.height,e1.height);
                }
                else return Integer.compare(e1.index,e2.index);
            }
        });
        //Maxheap to decide the mas height for the current index, and add to the ans
        PriorityQueue<Integer> maxHeight = new PriorityQueue<Integer>(10,Collections.reverseOrder());
        int preIndex = -1; int curIndex=0;
        int preHeight = 0; int curHeight;
         for(Edges e : edges){
        	curIndex = e.index;
        	if(preIndex==-1)preIndex=curIndex;   	
        	if(preIndex!=curIndex){
        		if(maxHeight.isEmpty()){
        		    ans.add(new int[]{preIndex,0});
        		    preIndex=curIndex;
        		    preHeight=0;
        		}
        		else{ 
        		    if(preHeight!=maxHeight.peek()){ans.add(new int[]{preIndex,maxHeight.peek()});}
        		    preIndex=curIndex;
        		    preHeight=maxHeight.peek();
        		}      		
        	}       	
        	if(e.isStart){
        		maxHeight.add(e.height);
        	}
        	else{
        		maxHeight.remove(e.height);
        	}        	
        }
        if(maxHeight.isEmpty()){
        	if(preHeight!=0)ans.add(new int[]{curIndex,0});}
        else{
        	if(preHeight!=maxHeight.peek())ans.add(new int[]{curIndex,maxHeight.peek()});}
        
        return ans;
    }
}

class Edges{
    int index;
    int height;
    boolean isStart;
    public Edges(int index, int height, boolean isStart){
        this.index = index;
        this.height = height;
        this.isStart = isStart;
    }
}
