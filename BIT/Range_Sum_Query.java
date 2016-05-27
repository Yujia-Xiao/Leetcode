/*
Range Sum Query - Mutable My Submissions QuestionEditorial Solution
Total Accepted: 11365 Total Submissions: 64609 Difficulty: Medium
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
Hide Tags Segment Tree Binary Indexed Tree
Hide Similar Problems (E) Range Sum Query - Immutable (H) Range Sum Query 2D - Mutable
*/
public class NumArray {
    
    int n;
    int[] tree,arr;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n+1]; //tree[0]=0;    
        arr = new int[n];
        for(int i=0;i<n;i++)update(i,nums[i]);
    }

    void update(int i, int val) {
        int idx = i+1;
        int dif = val-arr[i];
        arr[i]=val;
        while(idx<=n){
            tree[idx]+=dif;
            idx+=idx&(-idx);
        }
    }

    public int sumRange(int i, int j) {
        return (cumRange(j)-cumRange(i-1));    
    }
    
    public int cumRange(int i){
        int idx = i+1;
        int sum = 0;
        while(idx>0){
            sum+=tree[idx];
            idx-=idx&(-idx);
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);