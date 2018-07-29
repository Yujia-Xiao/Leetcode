/*
Sort Colors My Submissions Question
Total Accepted: 80265 Total Submissions: 238659 Difficulty: Medium
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
Hide Company Tags Facebook
Hide Tags Array Two Pointers Sort
Hide Similar Problems (M) Sort List (M) Wiggle Sort
*/
public class Solution {
    public void sortColors(int[] nums) {
        //0-red. 1-white. 2-blue
        //order red white blue
        Arrays.sort(nums);
    }
}

// ideas: left is 0, right is 2

public class Solution {
    public void sortColors(int[] A) {
        //0-red. 1-white. 2-blue
        //order red white blue
        int j = 0, k =A.length-1;
        for (int i = 0; i <= k; ++i){
            if (A[i] == 0 && i != j)
                swap(A,i--,j++);
            else if (A[i] == 2 && i != k)
                swap(A,i--, k--);
        }
    }
    public void swap(int[] A, int i, int j){
        int tem=A[i];
        A[i]=A[j];
        A[j]=tem;
    }
}


// quick sort

class Solution {
    public void sortColors(int[] nums) {
        //quick sort:
        /*pointer low -> ......middle.........<-hight
            while low<high
                while low<middel, low++
                while hight >=middle, high--
                swap(low, high)
            quick sort(0,low)
            quick sort(hight+1,len-1)
        */
        
        quickSort(nums,0,nums.length-1);
        return;
    }
    
    public void quickSort(int[] nums, int s, int e){
        //System.out.println(s);
        //System.out.println(e);
        //System.out.println();
        if(s>=e)return;
        int pivot = nums[s+(e-s)/2];//2
        int l = s;//0
        int h = e;//5
        while(l<=h){// partition:  0 ~ mid-1  + mid~len-1
            while(nums[l]<pivot)l++;//
            while(nums[h]>pivot)h--; // this can move all the way to be l==h
            if(l<=h){
                int tem = nums[l];  // 0,0,2,1,1,2. --0,0,1,1,2,2
                nums[l]=nums[h];
                nums[h]=tem;
                l++;h--;
            }
            
        }
        // l==h or h<l
        quickSort(nums,s,h);
        quickSort(nums,l,e);
        return;
    }
}

//merge sort
class Solution {
    public void sortColors(int[] nums) {
        //merge sort
        /*recursion: go to the very atom one
        and then meger
        */
        //for(int i=0; i<nums.length; i++)System.out.println(nums[i]); 
        mergeSort(nums,0,nums.length-1);
        //for(int i=0; i<nums.length; i++)System.out.println(nums[i]); // in-place
        
        return;
    }
    
    public void mergeSort(int[] nums, int s, int e){
         int m = s + (e-s)/2; //2
        if(s<e){
            mergeSort(nums,s,m); //0 - 2  --   m:1, 0-1, 2-2, -- . m:0 0-0,1-1,
            mergeSort(nums,m+1,e); //3-5
            merge(nums,s,m,m+1,e); 
        }
        return;
    }
    
    public void merge(int[] nums, int ls, int le, int hs, int he){
        int[] ans = new int[nums.length];
        
        int insert = ls;
        int ll = ls;
        int hl = hs;
        
        while(ll<=le && hl<=he){
            if(nums[ll]<nums[hl]){
                ans[insert]=nums[ll];
                ll++;
                insert++;
            }else{
                ans[insert]=nums[hl];
                hl++;
                insert++;
            }
        }
        while(ll<=le){
            ans[insert]=nums[ll];
            ll++;
            insert++;
        }
        
        while(hl<=he){
            ans[insert]=nums[hl];
            hl++;
            insert++;
        }
        //System.out.println("OK");

        for(int i=ls; i<=he; i++)nums[i]=ans[i]; // in-place
        //for(int i=ls; i<=he; i++)System.out.println(ans[i]);
        //System.out.println();
        return;
    };
}