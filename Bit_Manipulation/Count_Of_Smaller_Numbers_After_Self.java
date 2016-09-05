/*
Count of Smaller Numbers After Self My Submissions QuestionEditorial Solution
Total Accepted: 11070 Total Submissions: 35641 Difficulty: Hard
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

Hide Company Tags Google
Hide Tags Divide and Conquer Binary Indexed Tree Segment Tree Binary Search Tree
Hide Similar Problems (H) Count of Range Sum
*/
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new LinkedList<Integer>();
        if(nums.length==0|nums==null)return ans;
        
        int[] nums2 = Arrays.copyOf(nums,nums.length);
        
        Arrays.sort(nums2);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums2[i],i+1);//index is adjusted into idx form  -1 -> 1
        }
        
        int[] tree = new int[nums.length+1];//tree frequency
        for(int i=nums2.length-1;i>=0;i--){
            ans.add(0,getCF(map.get(nums[i])-1,tree));
            update(map.get(nums[i]),tree);
        }
        return ans;
    }
    
    public int getCF(int idx,int[] tree){
        int sum = 0;
        while(idx>0){
            sum+=tree[idx];
            idx-=idx&(-idx);
        }
        return sum;
    }
    public void update(int idx,int[] tree){
        while(idx<tree.length){
            tree[idx]++;
            idx+=idx&(-idx);
        }
    }
}