/*
Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Hide Company Tags LinkedIn Google Bloomberg Microsoft
Hide Tags Array Sort
Hide Similar Problems (H) Insert Interval (E) Meeting Rooms (M) Meeting Rooms II
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return (a.end-b.end); //when end is bigger, it is bigger
            }
        });
        //start to merge the interval from bottom
        for(int i=intervals.size()-1;i>-1;i--){
            if(i==0)return intervals;
            Interval last = intervals.get(i);
            Interval first = intervals.get(i-1);
            //first.end>=last.end
            if(first.end>=last.start){//'=' is important
                first.start=Math.min(first.start,last.start);
                first.end=last.end;
                intervals.remove(last);
            }
        }
        return intervals;
    }
}