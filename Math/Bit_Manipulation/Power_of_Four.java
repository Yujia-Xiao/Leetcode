/*
342. Power of Four  QuestionEditorial Solution  My Submissions
Total Accepted: 32042
Total Submissions: 89512
Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.

Hide Company Tags Two Sigma
Hide Tags Bit Manipulation
Hide Similar Problems (E) Power of Two (E) Power of Three
*/
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<0)return false;
        int ans = 0; int bitN = -1;
        for(int i=0;i<31;i++){
            if((num & 1) == 1){
                if(ans==1)return false;
                bitN=i;
                ans++;
            }
            num>>=1;
        }
        if(ans==1 && (bitN!=1))return true;
        return false;
    }
}

//7/26/2018
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<1)return false;
        int count = 0;
        for(int i=0;i<31;i++){
            int mask = 1<<i;
            int bit = num & mask;
            //System.out.println(i);
            //System.out.println(bit);
            //System.out.println();
            if(bit!=0){
                if(i % 2 ==0){
                    if(count!=0)return false;
                    count=1;
                }
                else return false;
            }
        }
        return true;
    }
}
