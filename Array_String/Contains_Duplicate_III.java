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

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}