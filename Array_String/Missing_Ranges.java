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
        String str = ""; int s; int e;
        if(nums==null || nums.length==0){            
            //return null;
            if(lower == upper){
                str=lower+"";
            }
            else{
                str=lower+"->"+upper;
            }
            ans.add(str);
            return ans;
        }
        if(nums[0]!=lower){
            if(nums[0]==lower+1){str=lower+"";}
            else{
                s = nums[0]-1;
                str=lower+"->"+s;
            }
            ans.add(str);
        }

        for(int i=1;i<nums.length;i++){
            ans=addAns(ans,nums,i-1,i);
        }
        
        if(nums[nums.length-1]!=upper){
            if(nums[nums.length-1]==upper-1){str=upper+"";}
            else{
                s = nums[nums.length-1]+1;
                str=s+"->"+upper;
            }
            ans.add(str);
        }       
        return ans;
    }
    
    public static List<String> addAns(List<String> ans,int[] nums,int start,int end){
        if((nums[end]-nums[start])<=1){return ans;}
        int s;int e;
        if((nums[end]-nums[start]) == 2){
            s= nums[start]+1;
            String str = s+"";
            ans.add(str);
        }
        else{   s= nums[start]+1;e= nums[end]-1;
                String str = s+"->"+e;
                ans.add(str); 
        }
        return ans;
    }
}