/*
Remove Duplicates from Sorted Array II My Submissions Question
Total Accepted: 61383 Total Submissions: 194750 Difficulty: Medium
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Hide Company Tags Facebook
Hide Tags Array Two Pointers
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length; int position=2; int pick=2;
        if(n<3)return n;
        while(position<n && pick<n){
            if(nums[position]==nums[position-1] && nums[position-1]==nums[position-2]){
                //change the position, find a number bigger than nums[position]
                //end condition
                while(pick<n && nums[pick]<=nums[position-1])pick++;
                if(pick>=n)break;
                else{nums[position]=nums[pick];nums[pick]=nums[0];position++;}
            }
            else if(nums[position]<nums[position-1]){
                while(pick<n && nums[pick]<nums[position-1])pick++;
                if(pick>=n)break;
                else{nums[position]=nums[pick];nums[pick]=nums[0];}                
            }
            else{position++;pick++;}
        }
        return position;
    }
}

//7/25/2018

class Solution {
    public int removeDuplicates(int[] nums) {
        //1,1. at lease len==3
        if(nums==null)return 0;
        if(nums.length<3)return nums.length;

        /*
         a. find the position
         1(pre), 2(cul), 2(post), 2, 2, 3
         1(pre), 2, 2, 2, 2(cul), 3(post)
         
         1(pre), 2(cul), 2(post), 2, 2, null
         1(pre), 2, 2, 2, 2(cul), null(post)
         
         b.
         1(pre), 2, 2(cul), 3(post)
         if cul-pre >= 2, insert 2
         c.
         1(pre), 2(cul), 3(post)
         if cul-pre == 1, insert 1
         
         else 
        */
        int pre=-1;
        int cul=0;
        int post=1;
        int insert=0; // 0 do not to be moved
        
        while(cul<nums.length){//post might be out of boundary
            //move only one step in while loop to make sure no time out
            if(post<nums.length && nums[cul]==nums[post]){ // find the position of cul!=post
                cul++;
                post++;
            }
            else if(cul-pre>=2){
                //insert
                nums[insert]=nums[cul];
                insert++;
                nums[insert]=nums[cul];
                insert++;
                //move
                pre=cul;
                cul=post;
                post=post+1;
            }
            else{
                nums[insert]=nums[cul];
                insert++;
                //move
                pre=cul;
                cul=post;
                post=post+1;
            }
            
        }
        return insert;
    }
}

//

class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0; // total number of saved item
        for(int n : nums){
            if(l < 2 || n > nums[l-2]) 
                {nums[l] = n; l++;}
        }
        return l;
    }
}