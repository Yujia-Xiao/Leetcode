/*
Two Sum II - Input array is sorted 
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Hide Company Tags Amazon
Hide Tags Array Two Pointers Binary Search
Hide Similar Problems (M) Two Sum
*/
public class Solution {
    public int[] twoSum(int[] num, int target) {
       int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if(v == target){
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            }
            else if(v > target){
                right --;
            } 
            else{
                left ++;
            }
        }
        return indice;
    }
}