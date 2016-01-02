/*
Pow(x, n) 
Implement pow(x, n).

Hide Company Tags LinkedIn Bloomberg Facebook
Hide Tags Math Binary Search
Hide Similar Problems (M) Sqrt(x)
*/
public class Solution {
    public double myPow(double x, int n) {
        if(n==0)return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}