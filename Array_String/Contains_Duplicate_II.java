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
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)return true;
                else map.put(nums[i],i);
            }else{
                map.put(nums[i],i)
            }
        }
        return false;
    }
}