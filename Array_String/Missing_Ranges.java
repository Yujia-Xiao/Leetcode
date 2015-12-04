/*
Missing Ranges
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

Hide Company Tags Google
Hide Tags Array
Hide Similar Problems (E) Summary Ranges
*/
public class Solution {  
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        if(nums==null || nums.length==0){
            if(lower==upper)ans.add(lower+"");
            else{ans.add(lower+"->"+upper);}
            return ans;}
        int start = 0; int next = start;
        if(nums[0]!=lower){
            if(lower==nums[0]-1){ans.add((lower)+"");}
            else{ans.add(lower+"->"+(nums[0]-1));}
        }    
        while(start<nums.length){
            int ca = nums[start];
            while(next+1<nums.length){
                int cb = nums[next+1];
                if(ca+1==cb){
                    start++;next++;
                    ca = nums[start];
                }
                else{break;}
            }
            //collect ans
            if(start==nums.length-1){
                if(nums[start]!=upper){
                    if(nums[start]==upper-1){ans.add(upper+"");}
                    else{ans.add((nums[start]+1)+"->"+upper);}
                }       
            }
            else{
                int ba = nums[start]+1; 
                int bb = nums[start+1]-1;
                if(ba==bb)ans.add(ba+"");
                else{ans.add(ba+"->"+bb);}
            }
            //next start point
            start=start+1;next=start;
        }
        return ans;
    }
}