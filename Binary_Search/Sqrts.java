/*
Sqrt(x) 
Implement int sqrt(int x).

Compute and return the square root of x.

Hide Company Tags Bloomberg Facebook
Hide Tags Math Binary Search
Hide Similar Problems (M) Pow(x, n)
*/
public class Solution {
    public int mySqrt(int x) {
        //the critical point i*i<=x && (i+1)*(i+1)>x
        if(x==0)return 0;
        int start = 1; int end = x; int mid = start+(end-start)/2;
        while(start<=end){
            mid=start+(end-start)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1))return mid;
            else if(mid>x/mid)end=mid;
            else start=mid+1;
        }
        return end;//return start;
    }
}