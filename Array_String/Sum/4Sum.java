/*
18. 4Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 78435
Total Submissions: 322534
Difficulty: Medium
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Hide Tags Array Hash Table Two Pointers
Hide Similar Problems (E) Two Sum (M) 3Sum
*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length<4)return ans;
        int len = nums.length;
        Arrays.sort(nums);
        int max = nums[len-1];
        for(int i=0;i<len-3;i++){//make sure three elements in between, controlling only one side
            int min = nums[i];
           // System.out.println(min+" "+max+" i:"+i);
            if(i>0 && nums[i]==nums[i-1])continue;//avoid duplicate
            if(min+3*max<target)continue; // min is too small
            if(min*4>target)break;// min is too 
            if(min*4==target){
                if(nums[i+3]==min)ans.add(Arrays.asList(min,min,min,min));
                break;
            }
           // System.out.println("OK");
            threeSum(ans,nums,i+1,len-1,target-min,min);
        }
        return ans;
    }
    
    public void threeSum(List<List<Integer>> ans, int[] nums, int s, int e, int target,int a1){
        //System.out.println(a1+" "+s+" "+e);
        int max = nums[e];
        for(int i=s;i<=e;i++){
            int min = nums[i];
            if(i>s && nums[i]==nums[i-1])continue;
            if(min+2*max<target)continue; //min is too small
            if(min*3>target)break;
            if(min*3==target){
                if(i+2<=e && nums[i+2]==min)ans.add(Arrays.asList(a1,min,min,min));
                break;
            }
            //sum 2
            int start = i+1; int end = e;
            while(start<end){
               // System.out.println(target+" "+min+" "+nums[start]+" "+nums[end]);
                if(nums[start]+nums[end]+min<target)start++;
                else if(nums[start]+nums[end]+min>target)end--;
                else {
                    ans.add(Arrays.asList(a1,min,nums[start],nums[end]));
                    while(start+1<end && nums[start+1]==nums[start])start++;
                    while(start<end-1 && nums[end-1]==nums[end])end--;
                    start++;
                }
            }
        }
    }
}