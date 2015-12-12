/*
Contains Duplicate II
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

Hide Company Tags Airbnb
Hide Tags Array Hash Table
Hide Similar Problems (E) Contains Duplicate (M) Contains Duplicate III
*/
import java.util.Hashtable;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer,Set> hash = new Hashtable<Integer,Set>();
        if(nums==null || nums.length<=1){return false;}
        
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i])){
                Iterator<Integer> it = hash.get(nums[i]).iterator();
                while(it.hasNext()){
                    if(Math.abs(it.next()-i)<=k){return true;}
                }
                hash.get(nums[i]).add(i);
            }
            
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            hash.put(nums[i],set);
        }
        return false;
    }
}