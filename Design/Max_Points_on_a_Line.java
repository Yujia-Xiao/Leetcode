/*
Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Hide Company Tags LinkedIn
Hide Tags Hash Table Math
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
class Line{
    public double slope;
    public Point basePoint;
    double EPS = 0.00001;

    public Line(Point p1, Point p2){
        //If Slope does not exist, this sets MAX_VALUE as a flag;
        if(p1.x - p2.x == 0)
            slope = Integer.MAX_VALUE;
        else    
            slope = (double)((p2.y - p1.y))/((p2.x - p1.x)); //Straightforward calculation of the slope of a line.
        //Setting point p1 to use in the equation of a line    
        basePoint = p1;
    }
    public boolean pointOnLine(Point p){
        //If the slope does not exist, we just need to check if the x of p is equal to the x of the basepoint.
        if(slope == Integer.MAX_VALUE)
            return p.x == basePoint.x;
        //Uses the equation of the line to check if point p is on the line (equation of a line: (y - y1) = slope*(x - x1))
        return Math.abs((p.y - basePoint.y) - slope*(p.x - basePoint.x)) < EPS;
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int maxPoints = 0;
        int currentNumber;
        Point currentPoint = null;
        if(points.length == 1)
            return 1;

        for(int i = 0; i < points.length; i++){
            currentPoint = points[i];
            for(int j = i + 1; j < points.length; j++){
                currentNumber = 0;
                Line currentLine = new Line(currentPoint,points[j]);
                for(int z = 0; z < points.length; z++){
                    //Calculates the number of points on the current line
                    if(currentLine.pointOnLine(points[z]))
                        currentNumber++;
                }
                //If points on current line is higher than the points on previous lines, we set the maxPoints variable 
                if(currentNumber > maxPoints)
                    maxPoints = currentNumber;
            }
        }
        return maxPoints;
    }
}
