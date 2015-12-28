/*
Bitwise AND of Numbers Range 
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for(;m!=n;i++){
            m>>=1;
            n>>=1;
        }
        return n<<i;
    }
}