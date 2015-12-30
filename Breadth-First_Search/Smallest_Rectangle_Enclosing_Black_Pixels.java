/*
Smallest Rectangle Enclosing Black Pixels
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Hide Company Tags Google
Hide Tags Binary Search
*/
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        Integer xmin = x; Integer xmax = x;
        Integer ymin = y; Integer ymax = y;
        int[] parameters = {x,x,y,y};
        //bfs(image,x,y,xmin,xmax,ymin,ymax);
        bfs(image,x,y,parameters);
        //return (xmax-xmin+1)*(ymax-ymin+1);
        return (parameters[0]-parameters[1]+1)*(parameters[2]-parameters[3]+1);
    }
    //public void bfs(char[][]image, int x, int y, Integer xmin, Integer xmax, Integer ymin, Integer ymax){
    public void bfs(char[][]image, int x, int y, int[] parameters){
        //update
        //xmin=Math.min(xmin,x); xmax=Math.max(xmax,x);
        //ymin=Math.min(ymin,y); ymax=Math.max(ymax,y);
    	parameters[0]=Math.max(parameters[0],x);parameters[1]=Math.min(parameters[1],x);
    	parameters[2]=Math.max(parameters[2],y);parameters[3]=Math.min(parameters[3],y);
        image[x][y]='2';
        //search neighbour
        if(x-1>=0){
            //if(image[x-1][y]=='1')bfs(image,x-1,y,xmin,xmax,ymin,ymax);
        	if(image[x-1][y]=='1')bfs(image,x-1,y,parameters);
        }
        if(x+1<image.length){
            //if(image[x+1][y]=='1')bfs(image,x+1,y,xmin,xmax,ymin,ymax);
        	if(image[x+1][y]=='1')bfs(image,x+1,y,parameters);
        }
        if(y-1>=0){
            //if(image[x][y-1]=='1')bfs(image,x,y-1,xmin,xmax,ymin,ymax);
        	if(image[x][y-1]=='1')bfs(image,x,y-1,parameters);
        }
        if(y+1<image[0].length){
            //if(image[x][y+1]=='1')bfs(image,x,y+1,xmin,xmax,ymin,ymax);
        	if(image[x][y+1]=='1')bfs(image,x,y+1,parameters);
        }
        return;
    }    
}