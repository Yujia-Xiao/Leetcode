/*
Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Array
Hide Similar Problems (M) Missing Ranges
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        int start=0; int end = 0;
        String str="";
        if(nums==null || nums.length==0){return ans;}
        
        while(start<nums.length && end+1<nums.length){
            if((nums[end+1]-nums[end])!=1){
                if(start==end){
                     str=nums[start]+"";
                }
                else{
                     str=nums[start]+"->"+nums[end];
                }
                ans.add(str);
                start=end+1;
                end++;
                    
                }
            else{end++;}
        }
        //end is the last, means end is not included
        if(end+1==nums.length && start!=end){
            str=nums[start]+"->"+nums[end];
            ans.add(str);
        }
        if(end+1==nums.length && start==end){
            str=nums[start]+"";
            ans.add(str);
        }   
        return ans;
    }
}