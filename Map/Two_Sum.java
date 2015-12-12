/*
Two Sum 
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Hide Company Tags Amazon Airbnb Facebook
Hide Tags Array Hash Table
Hide Similar Problems (M) 3Sum (M) 4Sum (M) Two Sum II - Input array is sorted (E) Two Sum III - Data structure design
*/
public class Solution{
	public int[] twoSum(int[] nums, int target){
	
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		if(nums.length<2)return null;
		int[] indexnums=new int[2];

		for(int i=0;i<nums.length;i++)map.put(nums[i],i+1);

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
			    if(map.get(target-nums[i])==i+1)continue;
				indexnums[0]=i+1;
				indexnums[1]=map.get(target-nums[i]);
				return indexnums;
			}
		}
		return indexnums;		
	}
}