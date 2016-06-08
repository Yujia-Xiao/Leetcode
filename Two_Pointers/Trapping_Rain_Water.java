/*
42. Trapping Rain Water My Submissions QuestionEditorial Solution
Total Accepted: 68717 Total Submissions: 210828 Difficulty: Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Hide Company Tags Google Twitter Zenefits Amazon Apple Bloomberg
Hide Tags Array Stack Two Pointers
Hide Similar Problems (M) Container With Most Water (M) Product of Array Except Self
*/
public class Solution {
    public int trap(int[] height) {
        if(height.length<2)return 0;
        int left = 0; int right = height.length-1;
        int ans = 0;
        boolean ifLeft=true; int pointer = 0; int minWall=0;
        //initial
        if(height[left]>height[right]){
            minWall=height[right];
            pointer=right-1;
            ifLeft=false;
        }
        else{
            minWall=height[left];
            pointer=left+1;
            ifLeft=true;
        }
        
        while(left<right){
            if(height[pointer]<minWall){ //success trapping water, update pointer
                ans+=minWall-height[pointer];
                if(ifLeft)left++;
                else right--;
                pointer=(ifLeft)?left+1:right-1;
            }
            else{ //else update the minWall and pointer
                if(ifLeft){
                    if(height[right]>height[pointer]){
                        minWall=height[pointer];
                        pointer++;
                        left++;
                    }
                    else{
                        minWall=height[right];
                        pointer=right-1;
                        left++;
                        ifLeft=false;
                    }
                }
                else{
                    if(height[left]>height[pointer]){
                        minWall=height[pointer];
                        pointer--;
                        right--;
                    }
                    else{
                        minWall=height[left];
                        pointer=left+1;
                        right--;
                        ifLeft=true;
                    }    
                }
            }
        }
        return ans;
    }
}
