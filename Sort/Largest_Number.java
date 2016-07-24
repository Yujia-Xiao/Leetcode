/*
179. Largest Number  QuestionEditorial Solution  My Submissions
Total Accepted: 50575
Total Submissions: 254285
Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Sort
*/
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)return "";
        String[] tem = new String[nums.length];
        for(int i=0;i<nums.length;i++)tem[i]=nums[i]+"";
        Arrays.sort(tem,new Comparator<String>(){
            public int compare(String a, String b){
                String c1 = a+b;
                String c2 = b+a;
                return c1.compareTo(c2);
            }
        });
        
        if(tem[tem.length-1].charAt(0)=='0')return "0";
        StringBuilder str = new StringBuilder();
        for(int i=tem.length-1;i>=0;i--)str.append(tem[i]);
        return str.toString();
    }
}