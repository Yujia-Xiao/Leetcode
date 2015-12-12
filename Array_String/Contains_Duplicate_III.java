/*
Contains Duplicate III 
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

Hide Company Tags Airbnb
Hide Tags Binary Search Tree
Hide Similar Problems (E) Contains Duplicate (E) Contains Duplicate II

*/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0){return false;}
 
	    TreeSet<Integer> set = new TreeSet<Integer>();
 
	    for (int i = 0; i < nums.length; i++) {
		    int c = nums[i];
		    if ((set.floor(c) != null && c <= set.floor(c) + t) || (set.ceiling(c) != null && c >= set.ceiling(c) -t))
			{return true;}
 
		    set.add(c);
 
		    if (i >= k){set.remove(nums[i - k]);}
	    }
 
	    return false;
    }
}