/*
Power of Two
Total Accepted: 44895 Total Submissions: 133990 Difficulty: Easy
Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Math Bit Manipulation
Hide Similar Problems (E) Number of 1 Bits
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        int ans = 0;
        if(n<0){
            return false;
        }
        for(int i=0; i<31;i++){
            if((n&1)==1){
                if(ans==1)return false;
                ans++;
            }
            n=n>>1;
        }
        if(ans==1)return true;
        else return false;
    }
}


//class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1)return false;
        int count = 0;
        for(int i=0;i<31;i++){
            int mask = 1<<i;
            int bit = n & mask;
            //System.out.println(i);
            //System.out.println(bit);
            if(bit!=0){
                if(count!=0)return false;
                count=1;
            }
        }
        return true;
    }
}
