/*
Meeting Rooms 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

Hide Company Tags Facebook
Hide Tags Sort
Hide Similar Problems (H) Merge Intervals (M) Meeting Rooms II
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals==null || intervals.length==0)return true;
        int count=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<intervals.length;i++){
            
            if(map.containsKey(intervals[i].start)){
                    map.put(intervals[i].start,map.get(intervals[i].start)+1);
                
            }
            else{
                map.put(intervals[i].start,1);
            }
            
            if(map.containsKey(intervals[i].end)){
                    map.put(intervals[i].end,map.get(intervals[i].end)-1);
                
            }
            else{
                map.put(intervals[i].end,-1);
            }           
        }       
        Object[] key = map.keySet().toArray();
        Arrays.sort(key);
        for(int i=0;i<key.length;i++){
            count+=map.get(key[i]);
            if(!(count==0 || count==1))return false;
        }        
        return true;
    }
}