/*
347. Top K Frequent Elements My Submissions QuestionEditorial Solution
Total Accepted: 14054 Total Submissions: 33242 Difficulty: Medium
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Hide Company Tags Pocket Gems Yelp
Hide Tags Hash Table Heap
Hide Similar Problems (M) Word Frequency (M) Kth Largest Element in an Array
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //bucket sort;
        
        List<Integer> ans = new LinkedList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))map.put(nums[i],1);
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        
        List<Integer>[] fc = new LinkedList[nums.length+1];
        for(int i:map.keySet()){
            if(fc[map.get(i)]==null)fc[map.get(i)]=new LinkedList<Integer>();
            fc[map.get(i)].add(i);
        }
        

        for(int i=nums.length;i>0;i--){
            if(fc[i]==null)continue;
            for(int j=0;j<fc[i].size();j++){
                ans.add(fc[i].get(j));
                k--;
                if(k==0)return ans;
            }
        }
        return ans;
    }
}
