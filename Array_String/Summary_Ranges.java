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
        if(nums==null || nums.length==0){return ans;}
        int start=0; int end = 0;
        while(start<nums.length){//two pointers
            String temStr="";
            int a = nums[start];
            while(end+1<nums.length){
                int b = nums[end+1];
                if(a+1==b){a++;end++;}
                else{break;}
            }
            if(start==end)temStr=nums[start]+"";
            else{temStr=nums[start]+"->"+nums[end];}
            ans.add(temStr);
            start=end+1;end=end+1;
        }
        return ans;
    }
}