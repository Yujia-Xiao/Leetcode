/*
Meeting Rooms II 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Hide Company Tags Google Facebook
Hide Tags Heap Greedy Sort
Hide Similar Problems (H) Merge Intervals (E) Meeting Rooms
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
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer,Integer> roomChange= new HashMap<Integer,Integer>();       
        for(Interval i:intervals){
            int start = roomChange.get(i.start)==null?0:roomChange.get(i.start);
            roomChange.put(i.start,start+1);
            int end = roomChange.get(i.end)==null?0:roomChange.get(i.end);
            roomChange.put(i.end,end-1);
        }        
        int ans = 0;
        int num = 0;
        Object[] array = roomChange.keySet().toArray();
        Arrays.sort(array);
        
        for(Object i : array){
        	num = num+roomChange.get(i);
        	ans = Math.max(num, ans);
        }       
        return ans;
    }
}